package com.example.todo.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.crypto.password.NoOpPasswordEncoder; // 단순 암호 비교 (개발용)

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final DataSource dataSource;

    public SecurityConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // JDBC 인증 설정
        auth.jdbcAuthentication()
            .dataSource(dataSource)
            .usersByUsernameQuery("SELECT username, password, true FROM users WHERE username = ?")
            .authoritiesByUsernameQuery("SELECT username, 'ROLE_USER' FROM users WHERE username = ?")
            // 비밀번호 암호화 없이 비교 (개발용, 실제론 암호화 필수)
            .passwordEncoder(NoOpPasswordEncoder.getInstance());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                // 로그인한 사용자만 접근 가능
                .antMatchers("/add", "/toggle/**", "/delete/**").authenticated()
                // 회원가입, 로그인 페이지는 모두 접근 가능
                .antMatchers("/register", "/login", "/css/**", "/js/**").permitAll()
                .anyRequest().permitAll()
            .and()
            .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/", true)
                .permitAll()
            .and()
            .logout()
                .permitAll()
            .and()
            .csrf().disable(); // 개발 중 편의를 위해 CSRF 해제 (실제 배포시 켜는걸 권장)
    }
}
