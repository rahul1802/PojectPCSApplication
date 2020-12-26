package dao;

import java.util.List;

import model.EmpSkill;
public interface IEmpSkill {
	List<EmpSkill>getAllEmpSkill();
	void addEmployee(EmpSkill es);
	EmpSkill getEmployeeByID(int id);
	void updteEmployee(EmpSkill es);
	void deactivateEmployee(int id);
	void deleteEmployee(int id);

}
