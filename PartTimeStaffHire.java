
/**
 * Write a description of class PartTimeStaffHire here.
 *
 * @author Abhigyan Dhakal
 * @version (0.1)
 */
import javax.swing.*;

public class PartTimeStaffHire extends StaffHire{
    private int workingHours;
    private int wagesPerHour;
    private String staffName;
    private String joiningDate;
    private String qualification;
    private String appointedBy;
    private String shifts;
    private boolean joined;
    private boolean terminated;
    INGNepal accObj = new INGNepal();
    
    //Creating a constructor
    public PartTimeStaffHire(int vacancyNo, String designation, String jobType, int workingHours, int wagesPerHour, String shifts)
    {
        //Calling vacancyNo, designation, jobType from the super class 'StaffHire'
        super(vacancyNo,designation,jobType);
        
        //Assigning values to instance variables using this keyword 
        this.workingHours = workingHours;
        this.wagesPerHour = wagesPerHour;
        this.shifts = shifts;
        
        staffName = "";
        joiningDate = "";
        qualification = "";
        appointedBy = "";
        joined = false;
        terminated = true;
    }
    //Accessor methods
    public String getStaffName()
    {
        return staffName;
    }
    public String getJoiningDate()
    {
        return joiningDate;
    }
    public String getQualification()
    {
        return qualification;
    }
    public String getAppointedBy()
    {
        return appointedBy;
    }
    public int getWorkingHours()
    {
        return workingHours;
    }
    public int getWagesPerHour()
    {
         return wagesPerHour;
    }
    public String getShifts()
    {
         return shifts;
    }
    public Boolean getJoined()
    {
        return joined;
    }
    //Setter methods
    public void setShifts(String shifts)
    {
        if(joined == false){
            this.shifts = shifts;
        }else{
            System.out.println("The staff is already hired. Cannot change the shift!");
        }
    }
    //Method for hiring staff
    public void hirePartTimeStaff(String staffName, String joiningDate, String qualification, String appointedBy)
    {
        if(joined == true){
            //Displaying message with staffname and joining date if staff is already hired for specified designation
            System.out.println(getStaffName()+" is already hired on "+ getJoiningDate());
        }
        else{
            //Assigning values to instance variables using this keyword 
            this.staffName = staffName;
            this.joiningDate = joiningDate;
            this.qualification = qualification;
            this.appointedBy = appointedBy;
            joined = true;
            terminated = false;
        }
    }
    //Method for terminating staff
    public void terminate()
    {
        if(terminated == true){
            //Displaying message if the staff is already terminated
            JOptionPane.showMessageDialog(accObj.mainFrame,"Staff has already been terminated");
        }
        else{
            //Displaying the name of the staff who got terminated
            JOptionPane.showMessageDialog(accObj.mainFrame, getStaffName() + " has been terminated.");
            //Setting values of the variables to empty after termination
            staffName = "";
            joiningDate = "";
            qualification = "";
            appointedBy = "";
            joined = false;
            terminated = true;
        }
    }
    //Method to display records
    void display()
    {
        //Calling display method from the super class
        super.display();
        if(joined == true){
            System.out.println("Staff name : "+ getStaffName());
            System.out.println("Wages Per Hour: "+ getWagesPerHour());
            System.out.println("Working Hours: "+ getWorkingHours());
            System.out.println("Joining Date : "+ getJoiningDate());
            System.out.println("Qualification : "+ getQualification());
            System.out.println("AppointedBy : "+ getAppointedBy());
            System.out.println("Income Per Day : "+(getWagesPerHour()* getWorkingHours()));
        }else{
            System.out.println("Part time staff for the post of "+getDesignation()+ " hasn't been hired.");
        }
    }
}