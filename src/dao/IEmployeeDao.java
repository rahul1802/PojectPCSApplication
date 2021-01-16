package dao;

import java.util.List;

import model.Employee;

public interface IEmployeeDao
{
	List<Employee>getAllEmployees();
	void addEmployee(Employee e);
	Employee getEmployeeByID(int id);
	void updateEmployee(Employee e);
	void deactivateEmployee(Employee e);
	void activateEmployee(Employee e);
	void deleteEmployee(int id);
	Employee checkLogin(String userId, String password);
}