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
				Skill s=new Skill();
				while(rst.next())
				{
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
			ResultSet rst=pst.executeQuery(query);
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
	public void updteSkill(Skill s) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deactivateSkill(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteSkill(int id) {
		// TODO Auto-generated method stub
		
	}

}
