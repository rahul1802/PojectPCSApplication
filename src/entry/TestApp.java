package entry;

import java.sql.SQLException;
import java.util.Scanner;

import config.JDBCConnection;
import excDao.EmployeeExec;
import excDao.SkillExec;

public class TestApp {
	public void TestConnection()
	{
		try
		{
			if(JDBCConnection.getDBConnection().isClosed())
			{
				System.out.println("Connection is closed");
			}
			else
			{
				System.out.println("Connection is opened");
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	public void processMenu() {
		EmployeeExec obj=new EmployeeExec();
		Scanner sc=new Scanner(System.in);
		int option=0;
		char ch='y';
		do {
			System.out.println("----------CRUD Operation-----------");
			System.out.println("1. View all Employees");
			System.out.println("2. View single Employee");
			System.out.println("3. Add Employee");
			System.out.println("4. Update Employee");
			System.out.println("5. Delete Employee");
			System.out.println("6. Deactivate Employee");
			System.out.println("7. Activate Employee");
			System.out.println("8. Quit");
			System.out.println("___________________");
			System.out.println("Enter your choice:");
			option=sc.nextInt();
			switch(option) {
				case 1:
					obj.getAllEmployees();
					break;
				case 2:
					obj.getEmployeesById();
					break;
				case 3:
					obj.addEmployee();
					break;
				case 4:
					obj.updateEmployee();
					break;
				case 5:
					obj.deleteEmployee();
					break;
				case 6:
					obj.deactiveEmployee();
					break;
				case 7:
					obj.activeEmployee();
					break;
				case 8:
					System.exit(0);
					break;
				default:
					System.out.println("Wrong input!");
					break;
			}
			System.out.println("Do you want to continue(y/n)?");	
			ch=sc.next().charAt(0);
		}while(ch=='y' || ch=='Y');
		
	}

	public static void main(String[] args) {
		
		TestApp test=new TestApp();
		test.TestConnection();
		test.processMenu();
		//EmployeeExec obj= new EmployeeExec();
		//obj.addEmployee();
		//obj.getAllEmployees();
		//obj.getEmployeesById();
		//SkillExec obj =new SkillExec();
		//obj.addSkill();
		//obj.getAllSkill();
		//obj.getSkillById();
		
		
		

	}

}
