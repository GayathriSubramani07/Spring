//Main.java

package com.tap.Main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.tap.config.ConfigFIle;
import com.tap.pojo.Employee;
import com.tap.pojo.Family;
import com.tap.pojo2.Student;


public class Main {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext a=new  AnnotationConfigApplicationContext(ConfigFIle.class);
		Employee e=(Employee)a.getBean(Employee.class);
		Student s=(Student)a.getBean(Student.class);
		Family f=(Family)a.getBean(Family.class);
		System.out.println(e);
		System.out.println(s);
		System.out.println(f);
		
	}

}

//ConfigFIle.java

package com.tap.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.tap.pojo.Employee;
@Configuration
@ComponentScan({"com.tap.pojo","com.tap.pojo2"})
public class ConfigFIle {
	
	

}




//Employee.java

package com.tap.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Employee {
	@Value("1")
	private int id;
	@Value("Gayathri")
	private String name;
	@Value("gayu@gmail.com")
	private String email;
	@Value("50000")
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



//Family.java

package com.tap.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Family {
	@Value("gayu")
	private String name;
	@Value("22")
	private int age;
	public Family() {
		super();
	}
	public Family(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Family [name=" + name + ", age=" + age + "]";
	}
	
	

}


//Student.java
package com.tap.pojo2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Student {
	@Value("1")
	private int id;
	@Value("mehili")
	private String name;
	@Value("17")
	private int age;
	
	public Student() {
		super();
	}
	
	
	public Student(int id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}


	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
	
	

}





