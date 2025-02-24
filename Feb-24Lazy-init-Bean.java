//Main.java
package com.velox;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("NewFile.xml");
        
        // Retrieve the "alien" bean and call its code() method
        Alien obj = (Alien) context.getBean("alien");
        obj.code();
    }
}



//NewFile.xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

   
    <bean id="com" class="com.velox.Laptop" primary="true"></bean>
   <!-- The object will not be created by default; it will only be created when needed." -->
    <bean id="com1" class="com.velox.Desktop" lazy-init="true"></bean>

     
    <bean id="alien" class="com.velox.Alien" autowire="byType">
    
    </bean>
</beans>

  //Alien.java

  package com.velox;

public class Alien {
	
	public Computer com;

	
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

//Computer.java
package com.velox;

public interface Computer {
    
    void compiler();  
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
 
