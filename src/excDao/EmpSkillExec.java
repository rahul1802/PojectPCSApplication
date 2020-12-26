package excDao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import controller.EmpSkillController;
import model.EmpSkill;
import model.Skill;

public class EmpSkillExec {
	EmpSkillController skillController=null;
	public EmpSkillExec()
	{
		skillController=new EmpSkillController();
	}
	public void getAllEmpSkill()
	{
		List<EmpSkill> skillList=skillController.getAllEmpSkill();
		for(EmpSkill s:skillList)
		{
			System.out.println(s);
		}
	}
	public void getEmpSkillById()
	{
		int id=0;
		try
		{
			BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter the EmpSkill Id whose record you want to view");
			id=Integer.parseInt(reader.readLine());
		}
		catch(IOException ex)
		{
			System.out.println(ex);
		}
		EmpSkill s=skillController.getEmpSkillByID(id);
		System.out.println(s);
	}

public void addEmpSkill()
{
	EmpSkill s=new EmpSkill();
	try
	{
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter EmpSkill Details:");
		System.out.println("EmployeeId:");
		s.setEmployeeId(Integer.parseInt(reader.readLine()));
		System.out.println("SkillID:");
		s.setSkillId(Integer.parseInt(reader.readLine()));
		System.out.println("Experience:");
		s.setExperience(Integer.parseInt(reader.readLine()));
	}
	catch(IOException ex)
	{
		System.out.println(ex);
	}
	skillController.addEmpSkill(s);
}
public void updateEmpSkill() {
	try {
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		int id;
		int skillid, exp,confirmexp;
		System.out.println("Enter EmployeeSkillId whose record you want to update:");
		id=Integer.parseInt(reader.readLine());
		EmpSkill skill=skillController.getEmpSkillByID(id);
		System.out.println("Enter new SkillId:");
		skillid=Integer.parseInt(reader.readLine());
		System.out.println("Enter new Experience:");
		exp=Integer.parseInt(reader.readLine());
		System.out.println("Re-enter same Experience to confirm:");
		confirmexp=Integer.parseInt(reader.readLine());
		if(exp==(confirmexp)) {
			skill.setSkillId(skillid);
			skill.setExperience(exp);
			skill.setEsId(id);
			skillController.updateEmpSkill(skill);
			
		}
		else {
			System.out.println("Sorry! you have entered different Name!");
		}
	}
	catch(IOException ex) {
		System.out.println(ex.getMessage());
	}
}
public void deleteEmpSkill() {
	try {
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		int id;
		System.out.println("Enter EmpSkillId whose record you want to delete:");
		id=Integer.parseInt(reader.readLine());
		skillController.deleteEmpSkill(id);
	}
	catch(IOException ex) {
		System.out.println(ex.getMessage());
	}
}
}
