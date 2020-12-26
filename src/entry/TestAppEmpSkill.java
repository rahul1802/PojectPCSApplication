package entry;

import java.sql.SQLException;
import java.util.Scanner;

import config.JDBCConnection;
import excDao.EmpSkillExec;

public class TestAppEmpSkill {
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
		EmpSkillExec obj=new EmpSkillExec();
		Scanner sc=new Scanner(System.in);
		int option=0;
		char ch='y';
		do {
			System.out.println("----------CRUD Operation-----------");
			System.out.println("1. View all EmpSkill Details");
			System.out.println("2. View single EmpSkill Details");
			System.out.println("3. Add EmpSkill");
			System.out.println("4. Update EmpSkill");
			System.out.println("5. Delete EmpSkill");
			System.out.println("6. Quit");
			System.out.println("___________________");
			System.out.println("Enter your choice:");
			option=sc.nextInt();
			switch(option) {
				case 1:
					obj.getAllEmpSkill();
					break;
				case 2:
					obj.getEmpSkillById();
					break;
				case 3:
					obj.addEmpSkill();
					break;
				case 4:
					obj.updateEmpSkill();;
					break;
				case 5:
					obj.deleteEmpSkill();
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
		TestAppEmpSkill test=new TestAppEmpSkill();
		test.TestConnection();
		test.processMenu();

	}

}
