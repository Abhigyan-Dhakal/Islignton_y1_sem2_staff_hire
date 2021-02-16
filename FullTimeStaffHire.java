
/**
 * Write a description of class FullTimeStaffHire here.
 *
 * @author Abhigyan Dhakal
 * @version (0.1)
 */
public class FullTimeStaffHire extends StaffHire{
    //declaring variables
    private int salary;
    private int workingHours;
    private String staffName;
    private String joiningDate;
    private String qualification;
    private String appointedBy;
    private boolean joined;

    //Creating a constructor
    public FullTimeStaffHire(int vacancyNo, String designation, String jobType, int workingHours, int salary){
        //Calling vacancyNo, designation, jobType from the super class 'StaffHire'
        super(vacancyNo,designation, jobType);
        
        //Assigning values to instance variables using this keyword 
        this.salary = salary;
        this.workingHours = workingHours;
        
        staffName = "";
        joiningDate = "";
        qualification = "";
        appointedBy = "";
        joined = false;
    }
    //Creating getter and setter methods
    public String getStaffName(){
        return staffName;
    }
    public String getQualification(){
        return qualification;
    }
    public String getJoiningDate(){
        return joiningDate;
    }
    public String getAppointedBy(){
        return appointedBy;
    }
    public int getWorkingHours(){
        return workingHours;
    }
    public int getSalary(){
        return salary;
    }
    public void setWorkingHours(int workingHours){
        this.workingHours = workingHours;
    }
    public Boolean getJoined(){
        return joined;
    }
    public void setSalary(int salary){
        //Salary could be changed only if staff isn't hired
        if(joined == false){
            this.salary = salary;
        }else{
            System.out.println("Staff is already hired. Salary can't be changed!");
        }
    }
    //Method for hiring staff
    public void hireStaff(String staffName,String joiningDate, String qualification, String appointedBy){
        if(joined == true){
            System.out.println(this.staffName+" has already been hired on "+this.joiningDate);
        }
        else{
            this.staffName = staffName;
            this.joiningDate = joiningDate;
            this.qualification = qualification;
            this.appointedBy = appointedBy;
            joined = true;
            System.out.println("The staff has been hired");
        }
    }
    //Display method to display records
    void display(){
        //Calling display method from the super class
        super.display();
        if(joined == true){
            //displaying following message if joined equals true
            System.out.println("Staff Name: "+getStaffName());
            System.out.println("Joined Date: "+getJoiningDate());
            System.out.println("Qualification: "+getQualification());
            System.out.println("Appointed By: "+getAppointedBy());
        }else{
            System.out.println("The staff has not been hired");
        }
    }
}

