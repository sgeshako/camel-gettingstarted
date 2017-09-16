package camel;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FileCopierWithCamel {
	public static void main(String args[]) throws Exception {
		
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("\\META-INF\\spring\\camel-context.xml");
        ctx.start();
        System.out.println("Application context started");
        try {
            Thread.sleep(5 * 10 * 1000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        ctx.stop();
        ctx.close();
	}
}