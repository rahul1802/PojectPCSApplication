package controller;

import java.util.List;

import dao.IEmployeeDao;
import daoImpl.EmployeeDaoImpl;
import model.Employee;

public class EmployeeController {
  IEmployeeDao empDao=null;
  public EmployeeController()
  {
	  empDao=new EmployeeDaoImpl();
  }
  public Employee checkLogin(String userId, String password) {
		Employee emp=empDao.checkLogin(userId, password);
		return emp;
	}
  public List<Employee> getAllEmployees()
  {
	  List<Employee> empList=empDao.getAllEmployees();
	  return empList;
  }
  public void addEmployee(Employee e)
  {
	  empDao.addEmployee(e);
  }
  public Employee getEmployeeByID(int id)
  {
	  Employee emp=empDao.getEmployeeByID(id);
	  return emp;
  } 
  public void updateEmployee(Employee e) {
		empDao.updateEmployee(e);
	}
	public void deleteEmployee(int id) {
		empDao.deleteEmployee(id);
	}
	public void deactivateEmployee(Employee e) {
		empDao.deactivateEmployee(e);
	}
	public void activateEmployee(Employee e) {
		empDao.activateEmployee(e);
	}
	
}
