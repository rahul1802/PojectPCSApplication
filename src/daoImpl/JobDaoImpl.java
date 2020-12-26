package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import config.JDBCConnection;
import dao.IJobDao;
import model.Job;

public class JobDaoImpl implements IJobDao{

	Connection conn=null;
	public JobDaoImpl()
	{
		conn=JDBCConnection.getDBConnection();
	}
	@Override
	public List<Job> getAllJob() {
		List<Job> jobList =new ArrayList<Job>();
		try
		{
			String query="select *from Job";
			Statement stmt=conn.createStatement();
			ResultSet rst=stmt.executeQuery(query);
			if(rst!=null) 
			{
				
				while(rst.next())
				{
					Job job=new Job();
					job.setJobId(rst.getInt(1));
					job.setJobTitle(rst.getString(2));
					job.setJobDescription(rst.getString(3));
					job.setCompanyName(rst.getString(4));
					job.setLocation(rst.getString(5));
					job.setKeySkill(rst.getString(6));
					job.setSalary(rst.getInt(7));
					job.setExperience(rst.getInt(8));
					job.setActive(rst.getString(9));
					jobList.add(job);
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
	public void addJob(Job j) {
		try {
			String query="insert into Job(JobTitle,JobDescription,CompanyName,Location,KeySkill,Salary,Experience,Active) values(?,?,?,?,?,?,?,?)";
			PreparedStatement pst=conn.prepareStatement(query);
			pst.setString(1,j.getJobTitle());
			pst.setString(2,j.getJobDescription());
			pst.setString(3,j.getCompanyName());
			pst.setString(4,j.getLocation());
			pst.setString(5,j.getKeySkill());
			pst.setInt(6,j.getSalary());
			pst.setInt(7,j.getExperience());
			pst.setString(8,j.getActive());
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
	public Job getJobByID(int id) {
		Job job=new Job();
		try
		{
			String query="select *from Job where JobID=?";
			PreparedStatement pst=conn.prepareStatement(query);
			pst.setInt(1,id);
			ResultSet rst=pst.executeQuery();
			if(rst!=null) 
			{
				
				while(rst.next())
				{
					job.setJobId(rst.getInt(1));
					job.setJobTitle(rst.getString(2));
					job.setJobDescription(rst.getString(3));
					job.setCompanyName(rst.getString(4));
					job.setLocation(rst.getString(5));
					job.setKeySkill(rst.getString(6));
					job.setSalary(rst.getInt(7));
					job.setExperience(rst.getInt(8));
					job.setActive(rst.getString(9));
				}
			}
			
		}
		catch(SQLException ex)
		{
			System.out.println(ex);
		}
		return job;
	}
	@Override
	public void updateJob(Job j) {
		try {
			String query = "UPDATE Job SET JobTitle=?,JobDescription=?, Location=? WHERE JobId=?";
		
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, j.getJobTitle());
			statement.setString(2, j.getJobDescription());
			statement.setString(3, j.getLocation());
			statement.setInt(4,j.getJobId());		 
			int rowsUpdated = statement.executeUpdate();
			if (rowsUpdated > 0) {
				System.out.println("An existing user was updated successfully!");
			}
			else {
				System.out.println("updation failed...");
			}
		}catch(SQLException ex) {
			System.out.println(ex);
		}
		
	}
	@Override
	public void deactivateJob(Job j) {
		try {
			//creating PreparedStatement object by passing query string
			PreparedStatement pst=conn.prepareStatement("update Job set Active=? where JobId=?");
			pst.setString(1, "Deactive");
			pst.setInt(2, j.getJobId());
			int i=pst.executeUpdate();
			if(i==1){
				System.out.println("Employee deactivated...");
			}
			else {
				System.out.println("updation failed...");
			}
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
	}
	@Override
	public void activateJob(Job j) {
		try {
			//creating PreparedStatement object by passing query string
			PreparedStatement pst=conn.prepareStatement("update Job set Active=? where JobId=?");
			pst.setString(1, "Active");
			pst.setInt(2, j.getJobId());
			int i=pst.executeUpdate();
			if(i==1){
				System.out.println("Employee Activated...");
			}
			else {
				System.out.println("updation failed...");
			}
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}	
		
	}
	@Override
	public void deleteJob(int id) {
		try {
			//creating PreparedStatement object by passing query string
			PreparedStatement pst=conn.prepareStatement("delete from Job where JobId=?");
			pst.setInt(1, id);
			int i=pst.executeUpdate();
			if(i==1){
				System.out.println("Employee deleted...");
			}
			else {
				System.out.println("deletion failed...");
			}
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}	
		
	}
	
}
