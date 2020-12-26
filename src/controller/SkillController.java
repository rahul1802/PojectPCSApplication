package controller;

import java.util.List;

import dao.ISkillDao;
import daoImpl.SkillDaoImpl;
import model.Employee;
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
	  public void updateSkill(Skill s) {
		  skillDao.updateSkill(s);
	  }
	  public void deleteSkill(int id) {
			skillDao.deleteSkill(id);
		}
	  public void deactivateSkill(Skill s) {
			skillDao.deactivateSkill(s);
		}
		public void activateSkill(Skill s) {
		skillDao.activateSkill(s);
		}
}
