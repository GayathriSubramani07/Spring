//Main.java

package com.velox;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {

    	ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

		/* Alien obj = (Alien) context.getBean("alien"); */
        Desktop des= context.getBean("desk",Desktop.class);
		des.compiler();
		 Desktop des1= context.getBean("desk",Desktop.class);
		 
        
//        Computer com=context.getBean(Computer.class);
//        Desktop obj=context.getBean(Desktop.class); 
    }
}


//Config.java
package com.velox;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class Config {

    // Defining the Desktop bean
    @Bean("desk") 
    @Scope("prototype")
    public Desktop desk() {
        return new Desktop();  // Creates and returns a new Desktop object
    }
}
