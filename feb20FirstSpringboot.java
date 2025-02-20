// pom.xml
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.velox</groupId>
    <artifactId>Spring1</artifactId>
    <packaging>war</packaging>
    <version>0.0.1-SNAPSHOT</version>
    <name>Spring1 Maven Webapp</name>
    <url>http://maven.apache.org</url>

    <dependencies>
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>3.8.1</version>
            <scope>test</scope>
        </dependency>

        <!-- Spring Core -->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-core</artifactId>
            <version>5.3.23</version>
        </dependency>

        <!-- Spring Context -->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-context</artifactId>
            <version>5.3.23</version>
        </dependency>

        <!-- Spring Beans -->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-beans</artifactId>
            <version>5.3.23</version>
        </dependency>

        <!-- Spring Web MVC (important for controllers and view handling) -->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-webmvc</artifactId>
            <version>5.3.23</version>
        </dependency>

        <!-- Servlet API (provided by the servlet container at runtime) -->
        <dependency>
            <groupId>javax.servlet</groupId>
            <artifactId>javax.servlet-api</artifactId>
            <version>4.0.1</version>
            <scope>provided</scope>
        </dependency>

    </dependencies>

    <build>
        <finalName>Spring1</finalName>
    </build>
</project>











  // Laptop.java
  package com.velox;

public class Laptop {
	 public void Compile() {
		 System.out.println("compiling");
	 }

}



//Alien.java
package com.velox;

import org.springframework.stereotype.Component;


public class Alien {
	

	int age;
	Alien()
	{
		System.out.println("Cons calling");
	}
	
	public void code() {
		System.out.println("coding");
	}

}


//main.java
package com.velox;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        // Use ClassPathXmlApplicationContext for XML-based configuration
        ApplicationContext context = new ClassPathXmlApplicationContext("NewFile.xml");

        // Retrieve the bean by its ID defined in XML
        Alien obj = (Alien) context.getBean("alien");
        System.out.println(obj.age=20);  // Prints the value of 'age' field

        Alien obj1 = (Alien) context.getBean("alien");
        System.out.println(obj1.age);  // Should be the same as obj, since default scope is singleton
        obj.code();  // Calls the 'code' method
    }
}






//Newfile.xml

<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:context="http://www.springframework.org/schema/context"
	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context-3.0.xsd">
	
	<bean id="alien" class="com.velox.Alien" scope="prototype"></bean>
</beans>
