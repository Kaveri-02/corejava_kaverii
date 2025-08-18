package org.tnsif.sf.c2tc.keyword;

class Person5{
	
}

class Employee extends Person5{
	
}

class Manager extends Employee{
	
}


public class InstanceOf_Demo1 {
	
	public static void main(String[] args) {
		Person5 person = new Person5();
		Employee emp =new Employee();
		Manager manager= new Manager();
		System.out.println(emp instanceof Employee);
		System.out.println(emp instanceof Person5);
		System.out.println(emp instanceof Manager);
		System.out.println(manager instanceof Manager);
		System.out.println(manager instanceof Employee);
		System.out.println(manager instanceof Person5);
		System.out.println(person  instanceof Employee);
		System.out.println(person instanceof Manager);

	}

}
