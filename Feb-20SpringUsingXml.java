//Employee.java

package com.pojo;

public class Employee {
	private int id;
	private String name;
	private String email;
	private int salary;
	
	
	
	public Employee() {
		super();
	}



	public Employee(int id, String name, String email, int salary) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.salary = salary;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public int getSalary() {
		return salary;
	}



	public void setSalary(int salary) {
		this.salary = salary;
	}



	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", email=" + email + ", salary=" + salary + "]";
	}
	

}



//Main.java

package com.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.pojo.Employee;
public class Main {
	public static void main(String[] args) {
		String configLoc ="/com/config/applicationContext.xml";
		
		ApplicationContext context=new ClassPathXmlApplicationContext(configLoc);
		
		Employee e = (Employee)context.getBean("empId1");
		
		System.out.println(e);
		
	}

}


//applicationContext.xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="
        http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">
	<bean class="com.pojo.Employee" id="empId1">
	<property name="id" value="1"></property>
	<property name="name" value="Gayathri"></property>
	<property name="email" value="gayathri@gmail.com"></property>
	<property name="salary" value="500000"></property>
	
    <!-- bean definitions here -->
</bean>
</beans>
