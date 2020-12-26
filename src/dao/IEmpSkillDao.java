package dao;

import java.util.List;

import model.EmpSkill;

public interface IEmpSkillDao {
	List<EmpSkill>getAllEmpSkill();
	void addEmployeeSkill(EmpSkill es);
	EmpSkill getEmployeeSkillByID(int id);
	void updateEmployeeSkill(EmpSkill es);
	void deleteEmployeeSkill(int id);

}
