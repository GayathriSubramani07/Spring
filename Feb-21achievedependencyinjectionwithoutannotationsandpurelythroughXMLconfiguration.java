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



//NewFile.java
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

    <!-- Define the Laptop bean -->
    <bean id="lap" class="com.velox.Laptop"></bean>

    <!-- Define the Alien bean with autowiring by name -->
   // <bean id="alien" class="com.velox.Alien" autowire="byName"></bean>


  <bean id="alien" class="com.velox.Alien" autowire="byType"></bean>
</beans>



  //ALien.java

 package com.velox;

public class Alien {
	
	public Laptop lap;

	public Laptop getLap() {
		return lap;
	}

	public void setLap(Laptop lap) {
		this.lap = lap;
	}
	
	public void code() {
		System.out.println("Hello");
		lap.compiler();
	}
}

//Laptop.java

package com.velox;

public class Laptop implements Computer{
  
    public void compiler() {
        System.out.println("Compiler logic implemented in Laptop");
    }
}

//Desktop.java
package com.velox;

public class Desktop implements Computer{

    public void compiler() {
        
        System.out.println("Compiler logic implemented in Desktop");
    }
	

}
 
