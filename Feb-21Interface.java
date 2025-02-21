//Main.java

package com.velox;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
       
        ApplicationContext context = new ClassPathXmlApplicationContext("NewFile.xml");

        
        Alien obj = (Alien) context.getBean("alien");
        obj.code();

      
           
    }
}


//NewFile.xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
                           http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context-3.0.xsd">
    
    <!-- Define the Laptop bean -->
    <bean id="laptop" class="com.velox.Laptop"></bean>

    <!-- Define the Alien bean with autowiring -->
    <bean id="alien" class="com.velox.Alien">
        <property name="laptop" ref="laptop" />
    </bean>

</beans>


//Alien.java
package com.velox;

import org.springframework.stereotype.Component;


public class Alien {
	

	private int age; 
	private Laptop laptop;
	

	
	
	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	

	public Laptop getLaptop() {
		return laptop;
	}


	public void setLaptop(Laptop laptop) {
		this.laptop = laptop;
	}
	
	public void code() {
		System.out.println("coding....");
		laptop.compiler();
	}
	

}


//Laptop.java
package com.velox;

public class Laptop implements Computer {

    public void compiler() {
        
        System.out.println("Compiler logic implemented in Laptop");
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

