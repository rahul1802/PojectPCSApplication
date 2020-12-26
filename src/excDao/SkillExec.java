package excDao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import controller.EmployeeController;
import controller.SkillController;
import model.Employee;
import model.Skill;

public class SkillExec {
	SkillController skillController=null;
	public SkillExec()
	{
		skillController=new SkillController();
	}
	public void getAllSkill()
	{
		List<Skill> skillList=skillController.getAllSkill();
		for(Skill s:skillList)
		{
			System.out.println(s);
		}
	}
	public void getSkillById()
	{
		int id=0;
		try
		{
			BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter the Skill Id whose record you want to view");
			id=Integer.parseInt(reader.readLine());
		}
		catch(IOException ex)
		{
			System.out.println(ex);
		}
		Skill s=skillController.getSkillByID(id);
		System.out.println(s);
	}

public void addSkill()
{
	Skill s=new Skill();
	try
	{
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter Skill Details:");
		System.out.println("Skill Name:");
		String skillName=reader.readLine();
		s.setSkillName(skillName);
		System.out.println("Skill Description:");
		s.setSkillDescription(reader.readLine());
		
		if(skillName.equals("Coding"))
		{
			s.setActive("Active");
		}
		else
		{
			s.setActive("Deactive");
		}
	}
	catch(IOException ex)
	{
		System.out.println(ex);
	}
skillController.addSkill(s);
}

}
