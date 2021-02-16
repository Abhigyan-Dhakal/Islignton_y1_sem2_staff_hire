
/**
 * Write a description of class StaffHire here.
 *
 * @author Abhigyan Dhakal
 * @version (0.1)
 */
public class StaffHire{
    //Declaring variables
    public int vacancyNo;
    public String designation;
    public String jobType;
    
    //Creating a constructor
    public StaffHire(int vacancyNo, String designation, String jobType){
        this.vacancyNo = vacancyNo;
        this.designation = designation;
        this.jobType = jobType;
    }
    //Getter and setter methods to get and return values
    public void setVacancyNo(int VacancyNo){
        this.vacancyNo = vacancyNo;
    }
    public void setDesignation(String designation){
        this.designation = designation;
    }
    public void setjobType(String jobtype){
        this.jobType = jobType;
    }
    public int getVacancyNo(){
        return vacancyNo;
    }
    public String getDesignation(){
        return designation;
    }
    public String getJobType(){
        return jobType;
    }
    //Creating display method to display record
    void display(){
        System.out.println("Vacancy Number: "+ getVacancyNo());
        System.out.println("Designation: "+ getDesignation());
        System.out.println("Job Type: "+ getJobType());
    }
}