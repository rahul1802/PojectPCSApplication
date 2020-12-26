package entry;

import java.sql.SQLException;
import java.util.Scanner;

import config.JDBCConnection;
import excDao.EmpJobExec;

public class TestAppEmpJob {
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
		EmpJobExec obj=new EmpJobExec();
		Scanner sc=new Scanner(System.in);
		int option=0;
		char ch='y';
		do {
			System.out.println("----------CRUD Operation-----------");
			System.out.println("1. View all EmpJob Details");
			System.out.println("2. View single EmpJobDetails");
			System.out.println("3. Add EmpJob");
			System.out.println("4. Update EmpJob");
			System.out.println("5. Delete EmpJob");
			System.out.println("6. Quit");
			System.out.println("___________________");
			System.out.println("Enter your choice:");
			option=sc.nextInt();
			switch(option) {
				case 1:
					obj.getAllEmpJob();
					break;
				case 2:
					obj.getEmpJobById();
					break;
				case 3:
					obj.addEmpJob();
					break;
				case 4:
					obj.updateEmpJob();;
					break;
				case 5:
					obj.deleteEmpJob();
					break;
				case 6:
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

		TestAppEmpJob test=new TestAppEmpJob();
		test.TestConnection();
		test.processMenu();

	}

}
