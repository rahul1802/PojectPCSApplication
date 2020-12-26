package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import config.JDBCConnection;
import dao.IEmpJobDao;
import model.EmpJob;
import model.EmpSkill;

public class EmpJobImpl implements IEmpJobDao {
	Connection conn=null;
	public EmpJobImpl()
	{
		conn=JDBCConnection.getDBConnection();
	}
	@Override
	public List<EmpJob> getAllEmployeesJob() {
		List<EmpJob> jobList =new ArrayList<EmpJob>();
		try
		{
			String query="select *from EmpJob";
			Statement stmt=conn.createStatement();
			ResultSet rst=stmt.executeQuery(query);
			if(rst!=null) 
			{
				
				while(rst.next())
				{
					EmpJob s=new EmpJob();
					s.setEjId(rst.getInt(1));
					s.setEmployeeId(rst.getInt(2));
					s.setJobId(rst.getInt(3));
					s.setRecruited(rst.getString(4));
					jobList.add(s);
				}
			}
			
		}
		catch(SQLException ex)
		{
			System.out.println(ex);
		}
		return jobList;
	}
	
	@Override
	public void addEmployeeJob(EmpJob ej) {
		try {
			String query="insert into EmpJob(EmployeeId,JobId,Recruited) values(?,?,?)";
			PreparedStatement pst=conn.prepareStatement(query);
			pst.setInt(1,ej.getEmployeeId());
			pst.setInt(2,ej.getJobId());
			pst.setString(3,ej.getRecruited());
			int i=pst.executeUpdate();
			if(i==1)
			{
				System.out.println("1.Record Inserted...");
			}
			else
			{
				System.out.println("Insertion Failed...");
			}
			
		}
		catch(SQLException ex)
		{
			System.out.println(ex);
		}
		
	}
	@Override
	public EmpJob getEmployeeJobByID(int id) {
		EmpJob s=new EmpJob();
		
		try
		{
			String query="select *from EmpJob where EJId=?";
			PreparedStatement pst=conn.prepareStatement(query);
			pst.setInt(1,id);
			ResultSet rst=pst.executeQuery();
			if(rst!=null) 
			{
				while(rst.next())
				{
					s.setEjId(rst.getInt(1));
					s.setEmployeeId(rst.getInt(2));
					s.setJobId(rst.getInt(3));
					s.setRecruited(rst.getString(4));
				
				}
			}
			
		}
		catch(SQLException ex)
		{
			System.out.println(ex);
		}
		return s;
	}
	@Override
	public void updateEmployeeJob(EmpJob ej) {
		try
		{
			String query="Update EmpJob SET JobId=?,Recruited=? where EJId=?";
			PreparedStatement pst=conn.prepareStatement(query);
			pst.setInt(1, ej.getJobId());
			pst.setString(2, ej.getRecruited());
			pst.setInt(3, ej.getEjId());
			int rowsUpdated = pst.executeUpdate();
			if (rowsUpdated > 0) {
				System.out.println("An existing user was updated successfully!");
			}
			else {
				System.out.println("updation failed...");
			}
			
		}
		catch(SQLException ex)
		{
			System.out.println(ex.getMessage());
		}
		
	}
	@Override
	public void deleteEmployeeJob(int id) {
		try {
			PreparedStatement pst=conn.prepareStatement("delete from EmpJob where EJId=? ");
			pst.setInt(1, id);
			int i=pst.executeUpdate();
			if(i==1)
			{
				System.out.println("records deleted...");
			}
			else
			{
				System.out.println("deletion failed....");
			}
		}catch(SQLException ex)
			{
				System.out.println(ex.getMessage());
			}
		
	}

}
