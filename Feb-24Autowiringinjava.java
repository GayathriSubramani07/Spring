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
		obj.code();
		System.out.println(obj.getAge());
		 
        

    }
} 

//Config.java

package com.velox;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class Config {

    // Defining the Desktop bean
    @Bean
       public Desktop desk() {
        return new Desktop();  // Creates and returns a new Desktop object
    }
    //without @Autowired it will work
    @Bean
    public Alien alien(@Autowired Computer com) {
    	Alien obj=new Alien();
    	obj.setAge(30);
    	obj.setCom(com);
    	
    	return obj;
      }
}
//Alien.java

package com.velox;

public class Alien {
	
	private int age;
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
		this.com = com;
	}




	public void code() {
		System.out.println("Hello");
		com.compiler();
	}
}

//computer.java

package com.velox;

public interface Computer {
    
    void compiler();  
}

//Desktop.java

package com.velox;

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

public class Laptop implements Computer{
	
	
	Laptop(){
		System.out.println("Laptop object is created");
	}

  
    public void compiler() {
        System.out.println("Compiler logic implemented in Laptop");
    }
}

 
