package daoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import config.JDBCConnection;
import dao.IJobDao;
import model.Employee;
import model.Job;

//public class JobDaoImpl implements IJobDao{

	/*Connection conn=null;
	public JobDaoImpl()
	{
		conn=JDBCConnection.getDBConnection();
	}
	public List<Job> getAllJob() {
		List<Job> jobList =new ArrayList<Job>();
		try
		{
			String query="select *from Job";
			Statement stmt=conn.createStatement();
			ResultSet rst=stmt.executeQuery(query);
			if(rst!=null) 
			{
				Employee emp=new Employee();
				while(rst.next())
				{
					emp.setEmployeeId(rst.getInt(1));
					emp.setFirstName(rst.getString(2));
					emp.setLastName(rst.getString(3));
					emp.setEmail(rst.getString(4));
					emp.setUserId(rst.getString(5));
					emp.setPassword(rst.getString(6));
					emp.setGender(rst.getString(7));
					emp.setRole(rst.getString(8));
					emp.setActive(rst.getString(9));
					empList.add(emp);
				}
			}
			
		}
		catch(SQLException ex)
		{
			System.out.println(ex);
		}
		return empList;
	}

	@Override
	public void addEmployee(Job j) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Job getEmployeeByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updteEmployee(Job j) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deactivateEmployee(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteEmployee(int id) {
		// TODO Auto-generated method stub
		
	}
*/
//}
