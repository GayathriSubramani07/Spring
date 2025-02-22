//Main.java
package com.tap.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.tap.config.ConfigFile;
import com.tap.pojo.Employee;

public class Main {


	public static void main(String[] args) {
		//			AnnotationConfigApplicationContext return type is Applicaton context so,here we triggering the spring
		AnnotationConfigApplicationContext a=new AnnotationConfigApplicationContext(ConfigFile.class);
		Employee e=(Employee)a.getBean("empId1");
		
		System.out.println(e);
		
		Employee e1=(Employee)a.getBean("empId2");
		System.out.println(e1);

	}

}




//ConfigFile.java


package com.tap.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.tap.pojo.Employee;

@Configuration
public class ConfigFile {
	@Bean("empId1")
	public Employee CreateObject() {
		Employee e=new Employee();
		e.setId(1);
		e.setName("Gayathri");
		e.setEmail("gayu@gmail.com");
		e.setSalary(20000);
		return e;
	}
	
	@Bean("empId2")
	public Employee CreateObject2() {
		Employee e=new Employee();
		e.setId(2);
		e.setName("janani");
		e.setEmail("janani@gmail.com");
		e.setSalary(50000);
		return e;
	}

}


//Employee.java

package com.tap.pojo;

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

