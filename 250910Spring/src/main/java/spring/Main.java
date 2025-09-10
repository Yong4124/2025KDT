package spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class Main {

	public static void main(String[] args) {
		AbstractApplicationContext ctx = 
				new AnnotationConfigApplicationContext(AppCtx.class);
		
//		Client client = ctx.getBean(Client.class);
//		client.send();
		
		Client2 client = ctx.getBean(Client2.class);
		client.send();
		
		ctx.close();

	}

}
