package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import config.JDBCConnection;
import dao.ISkillDao;
import model.Skill;

public class SkillDaoImpl implements ISkillDao {

	Connection conn=null;
	public SkillDaoImpl()
	{
		conn=JDBCConnection.getDBConnection();
	}
	public List<Skill> getAllSkill() {
		
		List<Skill> skillList =new ArrayList<Skill>();
		try
		{
			String query="select *from Skill";
			Statement stmt=conn.createStatement();
			ResultSet rst=stmt.executeQuery(query);
			if(rst!=null) 
			{
				
				while(rst.next())
				{	Skill s=new Skill();
					s.setSkillId(rst.getInt(1));
					s.setSkillName(rst.getString(2));
					s.setSkillDescription(rst.getString(3));
					s.setActive(rst.getString(4));
					skillList.add(s);
				}
			}
			
		}
		catch(SQLException ex)
		{
			System.out.println(ex);
		}
		return skillList;
	}

	@Override
	public void addSkill(Skill s) {
		try {
			String query="insert into Skill(SkillName,SkillDescription,Active) values(?,?,?)";
			PreparedStatement pst=conn.prepareStatement(query);
			pst.setString(1,s.getSkillName());
			pst.setString(2,s.getSkillDescription());
			pst.setString(3,s.getActive());
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
	public Skill getSkillByID(int id) {
		Skill s=new Skill();
		
		try
		{
			String query="select *from Skill where SkillID=?";
			PreparedStatement pst=conn.prepareStatement(query);
			pst.setInt(1,id);
			ResultSet rst=pst.executeQuery();
			if(rst!=null) 
			{
				while(rst.next())
				{
					s.setSkillId(rst.getInt(1));
					s.setSkillName(rst.getString(2));
					s.setSkillDescription(rst.getString(3));
					s.setActive(rst.getString(4));
				
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
	public void updateSkill(Skill s) {
		try {
			String query = "UPDATE Skill SET SkillName=?, SkillDescription=? WHERE SkillId=?";
		
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, s.getSkillName());
			statement.setString(2, s.getSkillDescription());
			statement.setInt(3,s.getSkillId());		 
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
	public void deactivateSkill(Skill s) {
		try {
		PreparedStatement pst=conn.prepareStatement("update Skill set Active=? where SkillId=?");
		pst.setString(1, "Deactive");
		pst.setInt(2, s.getSkillId());
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
	public void activateSkill(Skill s)
	{
		try
		{PreparedStatement pst=conn.prepareStatement("update Skill set Active=? where SkillId=?");
		pst.setString(1, "Active");
		pst.setInt(2, s.getSkillId());
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
	public void deleteSkill(int id) {
		try {
			//creating PreparedStatement object by passing query string
			PreparedStatement pst=conn.prepareStatement("delete from Skill where SkillId=?");
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
