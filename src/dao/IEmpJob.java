package dao;

import java.util.List;

import model.EmpJob;
public interface IEmpJob {
	List<EmpJob>getAllEmployees();
	void addEmployee(EmpJob ej);
	EmpJob getEmployeeByID(int id);
	void updteEmployee(EmpJob ej);
	void deactivateEmployee(int id);
	void deleteEmployee(int id);

}
