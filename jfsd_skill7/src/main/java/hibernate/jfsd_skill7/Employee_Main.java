package hibernate.jfsd_skill7;

import java.util.Scanner;

public class Employee_Main {

	private static Scanner sc;

	public static void main(String args[]) {
		sc = new Scanner(System.in);
		String choice = null;
		Employee emp = new Employee();
		Employee_DAO dao = new Employee_DAO();
		do {	
			System.out.println("1. Insert Employee Details");
			System.out.println("2. Execute Queries");
			int ch = sc.nextInt();
			if(ch == 1) {
				System.out.println("Employee Details");
				System.out.println("----------------");
				System.out.println("Enter Employee Name: ");
				String name = sc.next();
				System.out.println("Enter Employee Age: ");
				int age = sc.nextInt();
				System.out.println("Enter Employee Department: ");
				String dept =  sc.next();
				System.out.println("Enter Employee Salary: ");
				int salary =  sc.nextInt();
				
				emp.setEmp_age(age);
				emp.setEmp_dept(dept);
				emp.setEmp_name(name);
				emp.setSalary(salary);
				dao.insert(emp);	
			}
			else if(ch == 2) {
				dao.query();
			}
			else
				System.out.println("Enter an appropriate number");
			System.out.println("Do you want to continue Insertion of new Employee: [Yes/No] ");
			choice = sc.next();
		}
		while(choice .equals("Yes"));
	}
}
