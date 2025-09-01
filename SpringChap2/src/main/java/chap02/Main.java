package chap02;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx 
				= new AnnotationConfigApplicationContext(AppContext.class);  	// Bean공장
		Greeter g = ctx.getBean("greeter", Greeter.class);
		Greeter g2 = ctx.getBean("greeter", Greeter.class);
		Greeter g3 = ctx.getBean("greeter", Greeter.class);
		
		System.out.println(g.greet("스프링"));
		System.out.println(g3.greet("스프링"));
		System.out.println(g == g2);
		System.out.println(g == g3);
		ctx.close();
	}

}
