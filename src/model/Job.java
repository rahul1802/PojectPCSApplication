package model;

public class Job {
	private int jobId;
	private String jobTitle;
	private String jobDescription;
	private String companyName;
	private String location;
	private String keySkill;
	private int salary;
	private int experience;
	private String active;
	//default constructor
	public Job() {
		super();
		// TODO Auto-generated constructor stub
	}
	//parameterized constructor using fields
	public Job(int jobId, String jobTitle, String jobDescription, String companyName, String location, String keySkill,
			int salary, int experience, String active) {
		super();
		this.jobId = jobId;
		this.jobTitle = jobTitle;
		this.jobDescription = jobDescription;
		this.companyName = companyName;
		this.location = location;
		this.keySkill = keySkill;
		this.salary = salary;
		this.experience = experience;
		this.active = active;
	}
	//parameterized constructor without jobId and active
	public Job(String jobTitle, String jobDescription, String companyName, String location, String keySkill, int salary,
			int experience) {
		super();
		this.jobTitle = jobTitle;
		this.jobDescription = jobDescription;
		this.companyName = companyName;
		this.location = location;
		this.keySkill = keySkill;
		this.salary = salary;
		this.experience = experience;
	}
	public int getJobId() {
		return jobId;
	}
	public void setJobId(int jobId) {
		this.jobId = jobId;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public String getJobDescription() {
		return jobDescription;
	}
	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getKeySkill() {
		return keySkill;
	}
	public void setKeySkill(String keySkill) {
		this.keySkill = keySkill;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	@Override
	public String toString() {
		return "Job [jobId=" + jobId + ", jobTitle=" + jobTitle + ", jobDescription=" + jobDescription
				+ ", companyName=" + companyName + ", location=" + location + ", keySkill=" + keySkill + ", salary="
				+ salary + ", experience=" + experience + ", active=" + active + "]";
	}
	
	

}
