package controller;

import java.util.List;

import dao.IJobDao;
import daoImpl.JobDaoImpl;
import model.Job;
import model.Skill;

public class JobController {
	IJobDao jobDao=null;
	  public JobController()
	  {
		  jobDao=new JobDaoImpl();
	  }
	  public List<Job> getAllJob()
	  {
		  List<Job> jobList=jobDao.getAllJob();
		  return jobList;
	  }
	  public void addJob(Job s)
	  {
		  jobDao.addJob(s);
	  }
	  public Job getJobByID(int id)
	  {
		  Job s=jobDao.getJobByID(id);
		  return s;
	  }
	  public void updateJob(Job s) {
		  jobDao.updateJob(s);
	  }
	  public void deleteJob(int id) {
			jobDao.deleteJob(id);
		}
	  public void deactivateJob(Job j) {
			jobDao.deactivateJob(j);
		}
		public void activateJob(Job j) {
		jobDao.activateJob(j);
		}
}
