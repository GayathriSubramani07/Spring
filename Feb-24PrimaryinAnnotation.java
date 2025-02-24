//Main.java
package com.velox;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {

    	ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

		Alien obj=context.getBean(Alien.class);

		Desktop obj1=context.getBean(Desktop.class);
		System.out.println(obj.getAge());
		obj.code();
		
		 
        

    }
} 

//config.java
package com.velox;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan("com.velox")
public class Config {

    
      
}


//Alien.java

package com.velox;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Alien {
	@Value("10")
	private int age;
	@Autowired
	
	public Computer com;
	
	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}




	

	
	Alien(){
		System.out.println("Alien object is created");
	}


	public Computer getCom() {
		return com;
	}




	public void setCom(Computer com) {
		System.out.println("Using setter");
		this.com = com;
	}




	public void code() {
		System.out.println("Hello");
		com.compiler();
	}
}

//Computer.java

package com.velox;

import org.springframework.stereotype.Component;

@Component
public interface Computer {
    
    void compiler();  
}


//Desktop.java
package com.velox;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("desk")
@Primary
public class Desktop implements Computer{
	
	Desktop(){
		System.out.println("Desktop object is created");
	}

    public void compiler() {
        
        System.out.println("Compiler logic implemented in Desktop");
    }
	

}


//Laptop.java

package com.velox;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component

public class Laptop implements Computer{
	
	
	Laptop(){
		System.out.println("Laptop object is created");
	}

  
    public void compiler() {
        System.out.println("Compiler logic implemented in Laptop");
    }
}
