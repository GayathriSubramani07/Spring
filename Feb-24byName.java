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

    <bean id="com" class="com.velox.Laptop"></bean>
     <bean id="com1" class="com.velox.Desktop"></bean>

  
<!--  "In this Spring application, the 'Alien' class is autowired by name."
"When autowire='byName' is set, Spring looks for a property in the Alien class"
 "that matches the name of an existing bean. In this case, the Alien class has" 
"a property 'com' (or setter method 'setCom'). Spring will check if a bean"
"with the ID 'com' exists. Since we have defined a bean with the ID 'com' (which"
 "corresponds to the class 'com.velox.Laptop'), Spring will inject the 'Laptop' bean"
 "into the 'Alien' class using the 'com' property."
     --> 
    <bean id="alien" class="com.velox.Alien" autowire="byName"></bean>
</beans>

//Alien.java

  package com.velox;

public class Alien {
	
	public Computer com;

	
	

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


//Desktop.java

package com.velox;

public class Desktop implements Computer{

    public void compiler() {
        
        System.out.println("Compiler logic implemented in Desktop");
    }
	

}


//Laptop.java

package com.velox;

public class Laptop implements Computer{
  
    public void compiler() {
        System.out.println("Compiler logic implemented in Laptop");
    }
}
