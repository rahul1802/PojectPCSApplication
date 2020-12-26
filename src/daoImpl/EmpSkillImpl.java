package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import config.JDBCConnection;
import dao.IEmpSkillDao;
import model.EmpSkill;
import model.Skill;

public class EmpSkillImpl implements IEmpSkillDao {

	Connection conn=null;
	public EmpSkillImpl()
	{
		conn=JDBCConnection.getDBConnection();
	}
	public List<EmpSkill> getAllEmpSkill() {
		List<EmpSkill> skillList =new ArrayList<EmpSkill>();
		try
		{
			String query="select *from EmpSkill";
			Statement stmt=conn.createStatement();
			ResultSet rst=stmt.executeQuery(query);
			if(rst!=null) 
			{
				
				while(rst.next())
				{
					EmpSkill s=new EmpSkill();
					s.setEsId(rst.getInt(1));
					s.setEmployeeId(rst.getInt(2));
					s.setSkillId(rst.getInt(3));
					s.setExperience(rst.getInt(4));
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
	public void addEmployeeSkill(EmpSkill es) {
		try {
			String query="insert into EmpSkill(EmployeeId,SkillId,Experience) values(?,?,?)";
			PreparedStatement pst=conn.prepareStatement(query);
			pst.setInt(1,es.getEmployeeId());
			pst.setInt(2,es.getSkillId());
			pst.setInt(3,es.getExperience());
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
	public EmpSkill getEmployeeSkillByID(int id) {
		EmpSkill s=new EmpSkill();
		
		try
		{
			String query="select *from EmpSkill where ESId=?";
			PreparedStatement pst=conn.prepareStatement(query);
			pst.setInt(1,id);
			ResultSet rst=pst.executeQuery();
			if(rst!=null) 
			{
				while(rst.next())
				{
					s.setEsId(rst.getInt(1));
					s.setEmployeeId(rst.getInt(2));
					s.setSkillId(rst.getInt(3));
					s.setExperience(rst.getInt(4));
				
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
	public void updateEmployeeSkill(EmpSkill es) {
		try
		{
			String query="Update EmpSkill SET SkillId=?,Experience=? where ESId=?";
			PreparedStatement pst=conn.prepareStatement(query);
			pst.setInt(1, es.getSkillId());
			pst.setInt(2, es.getExperience());
			pst.setInt(3, es.getEsId());
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
	public void deleteEmployeeSkill(int id) {
		try {
			PreparedStatement pst=conn.prepareStatement("delete from EmpSkill where ESId=? ");
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
