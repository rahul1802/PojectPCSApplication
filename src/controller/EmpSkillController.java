package controller;

import java.util.List;

import dao.IEmpSkillDao;
import daoImpl.EmpSkillImpl;
import model.EmpSkill;





public class EmpSkillController {
	IEmpSkillDao empDao=null;
	  public EmpSkillController()
	  {
		  empDao=new EmpSkillImpl();
	  }
	  public List<EmpSkill> getAllEmployeesSkill()
	  {
		  List<EmpSkill> empList=empDao.getAllEmpSkill();
		  return empList;
	  }
	  public void addEmployeeSkill(EmpSkill e)
	  {
		  empDao.addEmployeeSkill(e);
	  }
	  public EmpSkill getEmployeeSkillByID(int id)
	  {
		  EmpSkill emp=empDao.getEmployeeSkillByID(id);
		  return emp;
	  }
	  public void updateEmployeeSkill(EmpSkill e) {
			empDao.updateEmployeeSkill(e);
		}
		public void deleteEmployeeSkill(int id) {
			empDao.deleteEmployeeSkill(id);
		}
	 
}
