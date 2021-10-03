package hibernate.jfsd_skill6;

import java.io.Serializable;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

public class Emp_Ops {

	Scanner sc = new Scanner(System.in);
	public void insert(EmpPojo emp) {
		
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
		System.out.println("1.Retrieve details of Employee whose id is 1001");
		System.out.println("2.Update salary of employee whose id is 1004 with average of all employee salaries");
		System.out.println("3.Delete employee record whose salary is minimum");
		int ch = sc.nextInt();
		if(ch==1) {
			EmpPojo  e = session.get(EmpPojo.class, 1001);
			System.out.println("Employee Id : "+e.getEmp_id());
			System.out.println("Name : "+e.getEmp_name());
			System.out.println("Department : "+e.getEmp_dept());
			System.out.println("Age : "+e.getEmp_age());
			System.out.println("Salary : "+e.getSalary());
			System.out.println("---------------------");
		}
		else if(ch==2) {
			Query q1 = session.createQuery("select avg(salary) from Employee");
			double b = (Double) q1.uniqueResult();	
			EmpPojo emp = session.load(EmpPojo.class, 1004);
			emp.setSalary((int)b);
			session.saveOrUpdate(emp);
			System.out.println("Updatation Succesfull");
			System.out.println("---------------------");
		}
		else if(ch==3) {
			Query q2 = session.createQuery("select emp_id from Employee where salary = (SELECT min(salary) FROM Employee)");
			EmpPojo student = (EmpPojo)session.load(EmpPojo.class, (Serializable) q2.uniqueResult());
			session.delete(student);
			System.out.println("Deleted Successfully");
		}
		else {
			System.out.println("Select an appropriate Query");
		}
		t.commit();
		factory.close();
		session.close();
		
	}
}
