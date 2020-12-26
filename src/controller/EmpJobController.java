package controller;

import java.util.List;

import dao.IEmpJobDao;

import daoImpl.EmpJobImpl;
import model.EmpJob;


public class EmpJobController {
	IEmpJobDao empDao=null;
	  public EmpJobController()
	  {
		  empDao=new EmpJobImpl();
	  }
	  public List<EmpJob> getAllEmployeesJob()
	  {
		  List<EmpJob> empList=empDao.getAllEmployeesJob();
		  return empList;
	  }
	  public void addEmployeeJob(EmpJob e)
	  {
		  empDao.addEmployeeJob(e);
	  }
	  public EmpJob getEmployeeJobByID(int id)
	  {
		  EmpJob emp=empDao.getEmployeeJobByID(id);
		  return emp;
	  }
	  public void updateEmployeeJob(EmpJob e) {
			empDao.updateEmployeeJob(e);
		}
		public void deleteEmployeeJob(int id) {
			empDao.deleteEmployeeJob(id);
		}
}
