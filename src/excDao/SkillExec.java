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
public void updateSkill() {
	try {
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		int id;
		String SkillName, SkillDescription, confirmName;
		System.out.println("Enter SkillId whose record you want to update:");
		id=Integer.parseInt(reader.readLine());
		Skill s=skillController.getSkillByID(id);
		System.out.println("Enter your new Skill:");
		SkillName=reader.readLine();
		System.out.println("Enter Skill Description:");
		SkillDescription=reader.readLine();
		System.out.println("Re-enter same Skill to confirm:");
		confirmName=reader.readLine();
		if(SkillName.equals(confirmName)) {
			s.setSkillName(SkillName);
			s.setSkillDescription(SkillDescription);
			s.setSkillId(id);
		skillController.updateSkill(s);
		}
		else {
			System.out.println("Sorry! you have entered different SkillName!");
		}
	}
	catch(IOException ex) {
		System.out.println(ex.getMessage());
	}
}
public void deactiveSkill() {
	try {
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		int id;
		System.out.println("Enter SkillId whose record you want to deactivate:");
		id=Integer.parseInt(reader.readLine());
		Skill s=skillController.getSkillByID(id);
		skillController.deactivateSkill(s);
	}
	catch(IOException ex) {
		System.out.println(ex.getMessage());
	}
}
public void activeSkill() {
	try {
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		int id;
		System.out.println("Enter SkillId whose record you want to activate:");
		id=Integer.parseInt(reader.readLine());
		Skill s=skillController.getSkillByID(id);
		skillController.activateSkill(s);
	}
	catch(IOException ex) {
		System.out.println(ex.getMessage());
	}
}
public void deleteSkill() {
	try {
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		int id;
		System.out.println("Enter SkillId whose record you want to delete:");
		id=Integer.parseInt(reader.readLine());
	skillController.deleteSkill(id);
	}
	catch(IOException ex) {
		System.out.println(ex.getMessage());
	}
}

}
