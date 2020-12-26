package controller;

import java.util.List;

import dao.ISkillDao;
import daoImpl.SkillDaoImpl;
import model.Skill;


public class SkillController {
	ISkillDao skillDao=null;
	  public SkillController()
	  {
		  skillDao=new SkillDaoImpl();
	  }
	  public List<Skill> getAllSkill()
	  {
		  List<Skill> skillList=skillDao.getAllSkill();
		  return skillList;
	  }
	  public void addSkill(Skill s)
	  {
		  skillDao.addSkill(s);
	  }
	  public Skill getSkillByID(int id)
	  {
		  Skill s=skillDao.getSkillByID(id);
		  return s;
	  }

}
