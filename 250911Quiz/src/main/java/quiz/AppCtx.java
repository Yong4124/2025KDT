package quiz;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppCtx {

    @Bean(destroyMethod = "close")
    public static DataSource dataSource() {
        DataSource ds = new DataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3305/spring5fs?characterEncoding=utf8");
        ds.setUsername("root");
        ds.setPassword("1234");
        return ds;
    }
}
