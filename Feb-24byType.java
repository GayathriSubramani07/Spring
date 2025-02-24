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

    <!-- Define the Laptop bean with ID 'com' -->
    <bean id="com" class="com.velox.Laptop"></bean>
    <!-- The Desktop bean is commented out here, but it could also be another implementation of the 'Computer' interface -->
    <!-- <bean id="com1" class="com.velox.Desktop"></bean> -->

    <!--
    Autowiring by Type:
    When autowire="byType" is used, Spring will check the type of the property to be autowired in the 'Alien' class.
    In this case, the 'Alien' class expects a property of type 'Computer'. 
    Since both the 'Laptop' and 'Desktop' classes implement the 'Computer' interface, 
    Spring would find two possible candidates.
    
    If both beans are defined in the context, Spring will encounter an issue because it doesn't know which one to inject.
    
    To resolve this ambiguity, you need to mark one of the beans as 'primary' by setting 'primary="true"'
    (e.g., <bean id="com" class="com.velox.Laptop" primary="true"/>), indicating which bean should be injected.
    -->

    <bean id="alien" class="com.velox.Alien" autowire="byType"></bean>
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
