package dao;

import java.util.List;

import model.Job;

public interface IJobDao {
	List<Job>getAllJob();
	void addEmployee(Job j);
	Job getEmployeeByID(int id);
	void updteEmployee(Job j);
	void deactivateEmployee(int id);
	void deleteEmployee(int id);
}
