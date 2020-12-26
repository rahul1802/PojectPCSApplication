package dao;

import java.util.List;

import model.Job;

public interface IJobDao {
	List<Job>getAllJob();
	void addJob(Job j);
	Job getJobByID(int id);
	void updateJob(Job j);
	void deactivateJob(Job j);
	void activateJob(Job j);
	void deleteJob(int id);
}
