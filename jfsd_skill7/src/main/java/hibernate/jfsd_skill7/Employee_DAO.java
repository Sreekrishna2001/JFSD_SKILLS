package hibernate.jfsd_skill7;

import java.util.List;
import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.internal.build.AllowSysOut;
import org.hibernate.query.Query;

public class Employee_DAO {

	Scanner sc = new Scanner(System.in);
	public static void display_all() {
		
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory factory = meta.getSessionFactoryBuilder().build();
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		Query q = session.createQuery("from Employee");
		List<Employee> emp = (List<Employee>) q.list();
		for(Employee list: emp) {
			System.out.print("Employee Id : "+list.getEmp_id()+" ");
			System.out.print("Employee Name : "+list.getEmp_name()+" ");
			System.out.print("Employee Age : "+list.getEmp_age()+" ");
			System.out.print("Department : "+list.getEmp_dept()+" ");
			System.out.print("Salary : "+list.getSalary()+" ");
			System.out.println();
		}		
		t.commit();
		factory.close();
		session.close();
	}
	
	public void insert(Employee emp) {
		
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory factory = meta.getSessionFactoryBuilder().build();
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		session.save(emp);
		t.commit();
		factory.close();
		session.close();
		System.out.println("Insertion Succesfull");
	}
	
	public void query() {
		
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory factory = meta.getSessionFactoryBuilder().build();
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		System.out.println("Executing Queries : ");
		System.out.println("--------------------");
		System.out.println("1.Display all employee details in the organization.");
		System.out.println("2.Display all the employees whose age is greater than 40.");
		System.out.println("3.Delete an employee whose employee id is 1005.");
		System.out.println("4.Update the name of an employee with ****** whose employee id is 1003");
		int ch = sc.nextInt();
		if(ch==1) {
			display_all();
		}
		if(ch==2) {
			Query q = session.createQuery("from Employee where emp_age > 40");
			List<Employee> emp = (List<Employee>) q.list();
			for(Employee list: emp) {
				System.out.print("Employee Id : "+list.getEmp_id()+" ");
				System.out.print("Name : "+list.getEmp_name()+" ");
				System.out.print("Age : "+list.getEmp_age()+" ");
				System.out.print("Department : "+list.getEmp_dept()+" ");
				System.out.print("Salary : "+list.getSalary()+" ");
				System.out.println();
			}
		}
		else if(ch==3) {
			Query q = session.createQuery("delete from Employee where emp_id=:empid"); 
			q.setParameter("empid", 1005);
			q.executeUpdate();
			System.out.println("Deletion Succesfull");
		}
		else if(ch==4) {
			System.out.print("Enter a name to update: ");
			String change_name = sc.next();
			Query q = session.createQuery("update Employee set emp_name=:name where emp_id=:empid");
			q.setParameter("name", change_name);
			q.setParameter("empid", 1003);
			q.executeUpdate();
			System.out.println("Updation Succesfull");
		}
		else {
			System.out.println("Select an appropriate Query");
		}
		t.commit();
		factory.close();
		session.close();	
	}
}
