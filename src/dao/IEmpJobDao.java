package dao;

import java.util.List;

import model.EmpJob;

public interface IEmpJobDao {
	List<EmpJob>getAllEmployeesJob();
	void addEmployeeJob(EmpJob ej);
	EmpJob getEmployeeJobByID(int id);
	void updateEmployeeJob(EmpJob ej);
	void deleteEmployeeJob(int id);
}
