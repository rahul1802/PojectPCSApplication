package entry;

import java.sql.SQLException;
import java.util.Scanner;

import config.JDBCConnection;

import excDao.JobExec;

public class TestAppJob {
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
		JobExec obj=new JobExec();
		Scanner sc=new Scanner(System.in);
		int option=0;
		char ch='y';
		do {
			System.out.println("----------CRUD Operation-----------");
			System.out.println("1. View all Jobs");
			System.out.println("2. View single Job");
			System.out.println("3. Add Job");
			System.out.println("4. Update Job");
			System.out.println("5. Delete Job");
			System.out.println("6. Deactivate Job");
			System.out.println("7. Activate Job");
			System.out.println("8. Quit");
			System.out.println("___________________");
			System.out.println("Enter your choice:");
			option=sc.nextInt();
			switch(option) {
				case 1:
					obj.getAllJob();
					break;
				case 2:
					obj.getJobById();
					break;
				case 3:
					obj.addJob();
					break;
				case 4:
					obj.updateJob();
					break;
				case 5:
					obj.deleteJob();
					break;
				case 6:
					obj.deactiveJob();
					break;
				case 7:
					obj.activeJob();
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
		TestAppJob job=new TestAppJob();
		job.TestConnection();
		job.processMenu();

	}

}
