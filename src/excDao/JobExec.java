package excDao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import controller.JobController;
import model.Job;

public class JobExec {
	JobController jobController=null;
	public JobExec()
	{
		jobController=new JobController();
	}
	
	public void getAllJob()
	{
		List<Job> jobList=jobController.getAllJob();
		for(Job j:jobList)
		{
			System.out.println(j);
		}
	}
	public void getJobById()
	{
		int id=0;
		try
		{
			BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter the Job Id whose record you want to view");
			id=Integer.parseInt(reader.readLine());
			Job j=jobController.getJobByID(id);
			System.out.println(j);
		}
		catch(IOException ex)
		{
			System.out.println(ex);
		}
		
		
	}
	public void addJob()
	{
		Job j=new Job();
		try
		{
			BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter Job Details:");
			System.out.println("Job Title");
			j.setJobTitle(reader.readLine());
			System.out.println("Job Description:");
			j.setJobDescription(reader.readLine());
			System.out.println("Company Name:");
			j.setCompanyName(reader.readLine());
			System.out.println("Location:");
			j.setLocation(reader.readLine());
			System.out.println("KeySkill:");
			String keySkill=reader.readLine();
			j.setKeySkill(keySkill);
			System.out.println("Salary:");
			int sal=Integer.parseInt(reader.readLine());
			j.setSalary(sal);
			System.out.println("Experience:");
			int exp=Integer.parseInt(reader.readLine());
			j.setExperience(exp);
			if(keySkill.equals("Coding"))
			{
				j.setActive("Active");
			}
			else
			{
				j.setActive("Deactive");
			}
		}
		catch(IOException ex)
		{
			System.out.println(ex);
		}
		jobController.addJob(j);
	}
	public void updateJob() {
		try {
			BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
			int id;
			String jobTitle,jobDes, location, confirmLocation;
			System.out.println("Enter JobId whose record you want to update:");
			id=Integer.parseInt(reader.readLine());
			Job j=jobController.getJobByID(id);
			System.out.println("Enter your new JobTitle:");
			jobTitle=reader.readLine();
			System.out.println("Enter your new JobDescription:");
			jobDes=reader.readLine();
			System.out.println("Enter your new  Location:");
			location=reader.readLine();
			System.out.println("Re-enter same Location to confirm:");
			confirmLocation=reader.readLine();
			if(location.equals(confirmLocation)) {
				j.setJobTitle(jobTitle);
				j.setJobDescription(jobDes);
				j.setLocation(location);
				j.setJobId(id);
				jobController.updateJob(j);
			}
			else {
				System.out.println("Sorry! you have entered different password!");
			}
		}
		catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
	public void deactiveJob() {
		try {
			BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
			int id;
			System.out.println("Enter JobId whose record you want to deactivate:");
			id=Integer.parseInt(reader.readLine());
			Job j=jobController.getJobByID(id);
			jobController.deactivateJob(j);
		}
		catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
	public void activeJob() {
		try {
			BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
			int id;
			System.out.println("Enter JobId whose record you want to activate:");
			id=Integer.parseInt(reader.readLine());
			Job j=jobController.getJobByID(id);
			jobController.activateJob(j);
		}
		catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
	public void deleteJob() {
		try {
			BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
			int id;
			System.out.println("Enter JobId whose record you want to delete:");
			id=Integer.parseInt(reader.readLine());
			jobController.deleteJob(id);
		}
		catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
}
