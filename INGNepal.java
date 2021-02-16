
/**
 * Write a description of class INGNepal here.
 *
 * @author Abhigyan Dhakal
 * @version 0.1
 */
//Importing packages for GUI

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class INGNepal implements ActionListener {
    //Declaring components for the GUI
    public JFrame mainFrame, vacancyInFrame,vacancyFrame, checkFrame, hireFrame, terminateFrame;
    private JPanel mainPanel, imgPanel, vacInPanel, vacancyPanel, terminatePanel, checkPanel, hiringPanel;
    private JButton vacancyFtBtn, vacancyPtBtn, hireFtBtn, hirePtBtn, terminateBtn, displayBtn;
    private JTextField vacancyTxt, designationTxt, workingHoursTxt, salaryTxt, wagesPerHourTxt, shiftsTxt, staffNameTxt, appointedByTxt, qualificationTxt, joiningDateTxt, terVacancyNoTxt;
    private JLabel jobTypeTxt, title1;
    private JButton addBtn, clearBtn, appointSubmitFt, appointSubmitPt, hire, clear,correctBtn, incorrectBtn, terBtn;
    private int vacNo;
    private String desig;
    private String jt;
    private String workinghr;
    private String sal;
    private String wph;
    private String shft;
    private String jobSelected;
    private boolean duplicate = true, check, flag2 = true, recAvailable;

    //Importing icon to the project
    Icon ing = new ImageIcon(getClass().getResource("ingLogo.png"));

    //Creating an arraylist
    ArrayList<StaffHire> staffVacancyli = new ArrayList<>();

    //Creating main interface for project
    private void startingGui() 
    {
        mainFrame = new JFrame("Staff Hire");
        mainFrame.setSize(410,340);

        imgPanel = new JPanel();
        //Creating empty border for the panel
        imgPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        imgPanel.setBackground(Color.gray);

        title1 = new JLabel(ing);
        imgPanel.add(title1);

        //Creating a grid-layout
        mainPanel = new JPanel(new GridLayout(6, 1, 6, 6));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        mainPanel.setBackground(Color.gray);

        vacancyFtBtn = new JButton("Add Vacancy for Full-Time staff hire");
        vacancyFtBtn.addActionListener(this);
        mainPanel.add(vacancyFtBtn);
        vacancyFtBtn.setBackground(Color.darkGray);
        vacancyFtBtn.setForeground(Color.white);

        vacancyPtBtn = new JButton("Add Vacancy for Part-Time staff hire");
        vacancyPtBtn.addActionListener(this);
        mainPanel.add(vacancyPtBtn);
        vacancyPtBtn.setBackground(Color.darkGray);
        vacancyPtBtn.setForeground(Color.white);

        hireFtBtn = new JButton("Hire Full-Time staff");
        hireFtBtn.addActionListener(this);
        mainPanel.add(hireFtBtn);
        hireFtBtn.setBackground(Color.darkGray);
        hireFtBtn.setForeground(Color.white);

        hirePtBtn = new JButton("Hire Part-Time staff");
        hirePtBtn.addActionListener(this);
        mainPanel.add(hirePtBtn);
        hirePtBtn.setBackground(Color.darkGray);
        hirePtBtn.setForeground(Color.white);

        terminateBtn = new JButton("Terminate Staff");
        terminateBtn.addActionListener(this);
        mainPanel.add(terminateBtn);
        terminateBtn.setBackground(Color.darkGray);
        terminateBtn.setForeground(Color.white);

        displayBtn = new JButton("Display Staff Details");
        displayBtn.addActionListener(this);
        mainPanel.add(displayBtn);
        displayBtn.setBackground(Color.darkGray);
        displayBtn.setForeground(Color.white);

        mainFrame.setLayout(new BorderLayout());
        mainFrame.add(imgPanel,BorderLayout.NORTH);
        mainFrame.add(mainPanel, BorderLayout.SOUTH);
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(mainFrame.EXIT_ON_CLOSE);
    }

    //Creating an interface for adding vacancy
    private void addVacancy()
    {
        vacancyFrame = new JFrame();

        vacancyPanel = new JPanel();
        vacancyPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        vacancyPanel.setBackground(Color.lightGray);

        JLabel vacancyNolbl = new JLabel("Vacancy No: ");
        JLabel designationlbl = new JLabel("Designation: ");
        JLabel jobTypelbl = new JLabel("Job Type: ");
        JLabel workingHourslbl = new JLabel("Working Hours: ");
        JLabel wagesPerHourlbl = new JLabel("Wages Per Hour: ");
        JLabel shiftslbl = new JLabel("Shift: ");
        JLabel salarylbl = new JLabel("Salary: ");
        jobTypeTxt = new JLabel("");
        JLabel emptylbl1 = new JLabel("");
        JLabel emptylbl2 = new JLabel("");

        addBtn = new JButton("Add");
        addBtn.addActionListener(this);
        addBtn.setBackground(Color.darkGray);
        addBtn.setForeground(Color.white);

        clearBtn = new JButton("Clear");
        clearBtn.addActionListener(this);
        clearBtn.setBackground(Color.darkGray);
        clearBtn.setForeground(Color.white);


        vacancyPanel.setLayout(new GridLayout(8,2));
        vacancyTxt = new JTextField();
        designationTxt = new JTextField();
        workingHoursTxt = new JTextField();
        wagesPerHourTxt = new JTextField();
        shiftsTxt = new JTextField();
        salaryTxt = new JTextField();

        vacancyPanel.add(vacancyNolbl);
        vacancyPanel.add(vacancyTxt);
        vacancyPanel.add(designationlbl);
        vacancyPanel.add(designationTxt);
        vacancyPanel.add(workingHourslbl);
        vacancyPanel.add(workingHoursTxt);
        
        //Adds following components to the interface if jobSelected is FullTime
        if(jobSelected.equals("FullTime")){
            vacancyPanel.add(jobTypelbl);
            jobTypeTxt.setText("Full-Time");
            vacancyPanel.add(jobTypeTxt);
            vacancyPanel.add(salarylbl);
            vacancyPanel.add(salaryTxt);
        }
        //Adds following components to the interface if jobSelected is PartTime
        if(jobSelected.equals("PartTime")){
            vacancyPanel.add(jobTypelbl);
            jobTypeTxt.setText("Part-Time");
            vacancyPanel.add(jobTypeTxt);
            vacancyPanel.add(wagesPerHourlbl);
            vacancyPanel.add(wagesPerHourTxt);
            vacancyPanel.add(shiftslbl);
            vacancyPanel.add(shiftsTxt);
        }
        vacancyPanel.add(emptylbl1);
        vacancyPanel.add(emptylbl2);
        vacancyPanel.add(addBtn);
        vacancyPanel.add(clearBtn);
        vacancyFrame.add(vacancyPanel);
        vacancyFrame.setSize(400,300);
        vacancyFrame.setVisible(true);
    }

    //Creating an interface for entering vacancy number for appointment
    private void appointGui()
    {
        vacancyInFrame = new JFrame();

        vacInPanel = new JPanel(new GridLayout(3,2));
        vacInPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        vacInPanel.setBackground(Color.lightGray);

        JLabel title = new JLabel("Enter Vacancy No. to appoint a staff : ");
        JLabel emptylbl1 = new JLabel("");
        JLabel vacancylbl = new JLabel("Vacancy No.: ");
        vacancyTxt = new JTextField();

        addBtn = new JButton("Submit");
        addBtn.setBackground(Color.darkGray);
        addBtn.setForeground(Color.white);

        vacInPanel.add(title);
        vacInPanel.add(emptylbl1);
        vacInPanel.add(vacancylbl);
        vacInPanel.add(vacancyTxt);

        //Creating submit button for fullTime and partTime
        if (jobSelected.equals("FullTime")){
            appointSubmitFt = new JButton("Submit");
            appointSubmitFt.addActionListener(this);
            appointSubmitFt.setBackground(Color.darkGray);
            appointSubmitFt.setForeground(Color.white);
            vacInPanel.add(appointSubmitFt);
        }
        if (jobSelected.equals("PartTime")){
            appointSubmitPt = new JButton("Submit");
            appointSubmitPt.addActionListener(this);
            appointSubmitPt.setBackground(Color.darkGray);
            appointSubmitPt.setForeground(Color.white);
            vacInPanel.add(appointSubmitPt);
        }

        vacancyInFrame.add(vacInPanel);
        vacancyInFrame.setSize(480,250);
        vacancyInFrame.setVisible(true);
    }

    //Creating an interface for hiring staff
    private void hireStaff()
    {
        hireFrame = new JFrame();
        hireFrame.setSize(350,340);

        hiringPanel = new JPanel(new GridLayout(11,2));
        hiringPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        hiringPanel.setBackground(Color.lightGray);

        JLabel vacancyNolbl = new JLabel("Vacancy No.: "+vacNo);
        JLabel designationlbl = new JLabel("Designation: "+desig);

        JLabel staffNamelbl = new JLabel("Staff Name: ");
        JLabel qualificationlbl = new JLabel("Qualification: ");
        JLabel joiningDatelbl = new JLabel("Joining Date: ");
        JLabel appointedBylbl = new JLabel("Appointed By: ");

        staffNameTxt = new JTextField();
        qualificationTxt = new JTextField();
        joiningDateTxt = new JTextField();
        appointedByTxt = new JTextField();

        hiringPanel.add(vacancyNolbl);
        hiringPanel.add(new JLabel(""));
        hiringPanel.add(designationlbl);
        hiringPanel.add(new JLabel(""));

        //Adds following components if jobSelected equals fullTime 
        if (jobSelected == "FullTime"){
            JLabel jobTypelbl = new JLabel("Job Type: "+jt);
            hiringPanel.add(jobTypelbl);
            hiringPanel.add(new JLabel(""));
            hiringPanel.add(staffNamelbl);
            hiringPanel.add(staffNameTxt);
            hiringPanel.add(qualificationlbl);
            hiringPanel.add(qualificationTxt);
            hiringPanel.add(joiningDatelbl);
            hiringPanel.add(joiningDateTxt);
            hiringPanel.add(appointedBylbl);
            hiringPanel.add(appointedByTxt);

            JLabel workingHourslbl = new JLabel("Working Hours: "+workinghr);
            JLabel salarylbl = new JLabel("Salary: "+ sal);

            hiringPanel.add(workingHourslbl);
            hiringPanel.add(new JLabel(""));
            hiringPanel.add(salarylbl);
            hiringPanel.add(new JLabel(""));
        }

        //Adds following components if jobSelected equals partTime 
        if (jobSelected == "PartTime"){
            JLabel jobTypelbl = new JLabel("Job Type: "+jt);
            hiringPanel.add(jobTypelbl);
            hiringPanel.add(new JLabel(""));

            hiringPanel.add(staffNamelbl);
            hiringPanel.add(staffNameTxt);
            hiringPanel.add(qualificationlbl);
            hiringPanel.add(qualificationTxt);
            hiringPanel.add(joiningDatelbl);
            hiringPanel.add(joiningDateTxt);
            hiringPanel.add(appointedBylbl);
            hiringPanel.add(appointedByTxt);

            JLabel workingHourslbl = new JLabel("Working Hours: "+workinghr);
            JLabel wagesPerHourlbl = new JLabel("Wages Per Hour: "+ wph);
            JLabel shiftslbl = new JLabel("Shift: "+shft);

            hiringPanel.add(workingHourslbl);
            hiringPanel.add(new JLabel(""));
            hiringPanel.add(wagesPerHourlbl);
            hiringPanel.add(new JLabel(""));
            hiringPanel.add(shiftslbl);
            hiringPanel.add(new JLabel(""));
        }

        hire = new JButton("Hire");
        hire.addActionListener(this);
        hire.setBackground(Color.darkGray);
        hire.setForeground(Color.white);

        clear = new JButton("Clear");
        clear.addActionListener(this);
        clear.setBackground(Color.darkGray);
        clear.setForeground(Color.white);

        hiringPanel.add(hire);
        hiringPanel.add(clear);

        hireFrame.add(hiringPanel);
        hireFrame.setVisible(true);
    }

    //Creating an interface for checking entered vacancy for assurance
    private void checkVacancy()
    {
        checkFrame = new JFrame();

        checkPanel = new JPanel(new GridLayout(5,2));
        checkPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        checkPanel.setBackground(Color.lightGray);

        JLabel title = new JLabel("Is this the record?");
        JLabel vacancyNolbl = new JLabel("Vacancy No: " + vacNo);
        JLabel designationlbl = new JLabel("Designation: " + desig);

        correctBtn = new JButton("Yes");
        correctBtn.addActionListener(this);
        correctBtn.setBackground(Color.darkGray);
        correctBtn.setForeground(Color.white);

        incorrectBtn = new JButton("No");
        incorrectBtn.addActionListener(this);
        incorrectBtn.setBackground(Color.darkGray);
        incorrectBtn.setForeground(Color.white);

        checkPanel.add(title);
        checkPanel.add(new JLabel(""));
        checkPanel.add(vacancyNolbl);
        checkPanel.add(new JLabel(""));
        checkPanel.add(designationlbl);
        checkPanel.add(new JLabel(""));

        if (jobSelected == "FullTime"){
            //Shows full-Time as job-Type in label if jobSelected equals full-Time
            JLabel jobTypelbl = new JLabel("Job Type: " + jt);
            checkPanel.add(jobTypelbl);
        }
        if (jobSelected == "PartTime"){
            //Shows Part-Time as job-Type in label if jobSelected equals Part-Time
            JLabel jobTypelbl = new JLabel("Job Type: " + jt);
            checkPanel.add(jobTypelbl);
        }

        checkPanel.add(new JLabel(""));
        checkPanel.add(correctBtn);
        checkPanel.add(incorrectBtn);

        checkFrame.add(checkPanel);
        checkFrame.setSize(260,250);
        checkFrame.setVisible(true);
    }

    //Method for checking if the entered vacancy number by the user is repeated or not
    private void checkDuplication() 
    {
        //This code gets executed while storing first vacancy
        if (duplicate == true) {
            storingVacancy();
            duplicate = false;
        } else {
            try{
                boolean test1 = false;
                //Iterating through arraylist using for enhanced loop
                for (StaffHire temp : staffVacancyli) {
                    if (temp.getVacancyNo() == fetchvacancy()) {
                        JOptionPane.showMessageDialog(mainFrame, "This vacancy no has already been registered!","Error", JOptionPane.INFORMATION_MESSAGE);
                        test1 = true;
                        break;
                    }
                }
                if (test1 == false){
                    storingVacancy();
                    vacancyFrame.dispose();
                }
            }catch (Exception err){
                //displays the message dialog if the value entered in the text field isn't valid (NumberFormatException)
                JOptionPane.showMessageDialog(mainFrame, err,"Error! Wrong input! ", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    //Method for storing the vacancy in the arraylist
    private void storingVacancy()
    {
        boolean flag = false;
        if(jobSelected.equals("FullTime")){
            //Checking if the text field is left empty and showing dialog box stating empty text field
            if(vacancyTxt.getText().equals("") || designationTxt.getText().equals("") || workingHoursTxt.getText().equals("")  || salaryTxt.getText().equals("") ) {
                flag = true;
                JOptionPane.showMessageDialog(mainFrame,"Error! Text field left empty");
                vacancyFrame.dispose();
            }
        } else if(jobSelected.equals("PartTime")){
            if(vacancyTxt.getText().equals("") || designationTxt.getText().equals("") || workingHoursTxt.getText().equals("") || wagesPerHourTxt.getText().equals("") || shiftsTxt.getText().equals("'")){
                flag = true;
                JOptionPane.showMessageDialog(mainFrame,"Error! Text field left empty");
                vacancyFrame.dispose();
            }
        }
        //Storing vacancy if the text fields are filled up.
        if (flag == false){
            //Try catch to show the exception in dialog box if the text field has invalid values
            try{
                if(jobSelected.equals("FullTime")){
                    FullTimeStaffHire ftobj = new FullTimeStaffHire(fetchvacancy(),fetchDesignation(),fetchjobType(),fetchWorkingHours(),fetchSalary());
                    staffVacancyli.add(ftobj);
                    JOptionPane.showMessageDialog(mainFrame, "Vacancy Added!");
                    vacancyFrame.dispose();
                }
                if(jobSelected.equals("PartTime")){
                    PartTimeStaffHire ptobj = new PartTimeStaffHire(fetchvacancy(),fetchDesignation(),fetchjobType(),fetchWorkingHours(),fetchWagesPerHour(),fetchShifts());
                    staffVacancyli.add(ptobj);
                    JOptionPane.showMessageDialog(mainFrame, "Vacancy Added!");
                    vacancyFrame.dispose();
                }
            }catch (NumberFormatException exception){
                JOptionPane.showMessageDialog(mainFrame, exception,"Error! Wrong input! ", JOptionPane.WARNING_MESSAGE);
                vacancyFrame.dispose();
            }
        }
    }
    //Method for storing appointments in the arraylist
    private void storingAppointment()
    {
        if (jobSelected == "FullTime"){
            //Iterating through arraylist using for-enhanced loop
            for (StaffHire obj : staffVacancyli){
                if (obj instanceof FullTimeStaffHire){
                    //creating an object hireObj in FullTimeStaffHire class
                    FullTimeStaffHire hireObj = (FullTimeStaffHire) obj;
                    if (hireObj.getVacancyNo()==vacNo){
                        if (hireObj.getJoined() == false){
                            hireObj.hireStaff(fetchStaffName(),fetchJoiningDate(),fetchQualification(),fetchAppointedBy());
                            JOptionPane.showMessageDialog(mainFrame, "Staff has been hired!","Successful!",JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                }
            }
        }
        if (jobSelected == "PartTime"){
            for (StaffHire obj : staffVacancyli){
                if (obj instanceof PartTimeStaffHire){
                    PartTimeStaffHire hireObj = (PartTimeStaffHire) obj;
                    if (hireObj.getVacancyNo()==vacNo){
                        if (hireObj.getJoined() == false){
                            hireObj.hirePartTimeStaff(fetchStaffName(),fetchJoiningDate(),fetchQualification(),fetchAppointedBy());
                            JOptionPane.showMessageDialog(mainFrame, "Staff has been hired!","Successful!",JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                }
            }
        }
    }
    //Creating an interface for terminating a staff
    private void terminateStaffGui()
    {
        terminateFrame = new JFrame();

        terminatePanel = new JPanel(new GridLayout(4,2));
        terminatePanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        terminatePanel.setBackground(Color.lightGray);

        JLabel title = new JLabel("Enter vacancy no for Termination");
        JLabel label1 = new JLabel("Vacancy No: ");

        terVacancyNoTxt = new JTextField();

        terBtn = new JButton("Terminate");
        terBtn.setBackground(Color.darkGray);
        terBtn.setForeground(Color.lightGray);
        terBtn.addActionListener(this);

        terminatePanel.add(title);
        terminatePanel.add(new JLabel(""));
        terminatePanel.add(label1);
        terminatePanel.add(terVacancyNoTxt);
        terminatePanel.add(new JLabel(""));
        terminatePanel.add(new JLabel(""));
        terminatePanel.add(terBtn);

        terminateFrame.add(terminatePanel);
        terminateFrame.setSize(410,200);
        terminateFrame.setVisible(true);
    }

    //Method for terminating a staff
    private void terminateStaff()
    {
        recAvailable = false;
        for (StaffHire temp : staffVacancyli) {
            if (temp instanceof PartTimeStaffHire) {
                //creating an object ptobj2 of PartTimeStaffHire class
                PartTimeStaffHire ptobj2 = (PartTimeStaffHire) temp;
                //Checking the vacancy number of arraylist with the entered number in the text field
                if (temp.getVacancyNo() == fetchTerVacancy()) {
                    if (ptobj2.getJoined() == true) {
                        recAvailable = true;
                        terminateFrame.dispose();
                        //Calling terminate method from PartTimeStaffHire method using ptobj2 object
                        ptobj2.terminate();
                    }
                }
            }
        }
        if (recAvailable == false){
            //Displays following dialog box if records not found in an arraylist
            JOptionPane.showMessageDialog(mainFrame,"No records found for termination.","Error",JOptionPane.ERROR_MESSAGE);
        }
    }

    //Method for displaying all the records in the console
    private void displayConsole()
    {
        //Iterating using for-enhanced loop
        for( StaffHire temp : staffVacancyli){
            //Using instanceOf operator to test if the object is the an instance of FullTimeStaffHireClass
            if(temp instanceof FullTimeStaffHire){
                FullTimeStaffHire test = (FullTimeStaffHire) temp;
                //Displaying records of Full-Time vacancy
                System.out.println("Vacancy no.: "+temp.getVacancyNo());
                System.out.println("Designation : " + temp.getDesignation());
                System.out.println("Job Type : "+ temp.getJobType());
                System.out.println("Salary : "+ test.getSalary());
                System.out.println("Work Hour : "+ test.getWorkingHours());
                System.out.println("Staff Name : "+ test.getStaffName());
                System.out.println("Join Date : "+ test.getJoiningDate());
                System.out.println("Qualification : "+ test.getQualification());
                System.out.println("Appointed By : "+ test.getAppointedBy());
                System.out.println("----------------------------------------------------------------------------");
            }

            //Using instanceOf operator to test if the object is the an instance of PartTimeStaffHireClass
            if(temp instanceof PartTimeStaffHire){
                PartTimeStaffHire test = (PartTimeStaffHire) temp;
                //Displaying records of Part-Time vacancy
                System.out.println("Vacancy no. "+temp.getVacancyNo());
                System.out.println("Designation : " + temp.getDesignation());
                System.out.println("Job Type : "+temp.getJobType());
                System.out.println("Work Hour : "+test.getWorkingHours());
                System.out.println("Wage per Hour : "+ test.getWagesPerHour());
                System.out.println("Shift : "+ test.getShifts());
                System.out.println("Staff Name : "+test.getStaffName());
                System.out.println("Join Date : "+test.getJoiningDate());
                System.out.println("Qualification : "+ test.getQualification());
                System.out.println("Appointed By : "+test.getAppointedBy());
                System.out.println("----------------------------------------------------------------------------");
            }
        }
    }

    //Getter methods to fetch the records and values from the text-fields
    //Fetching vacancy number from text field
    public int fetchvacancy()
    {
        //Parsing the vacancy number from string value to integer
        return Integer.parseInt(vacancyTxt.getText());
    }

    //Fetching designation from text field
    public String fetchDesignation()
    {
        return designationTxt.getText();
    }

    //Fetching jobType from text field
    public String fetchjobType()
    {
        return jobTypeTxt.getText();
    }

    //Fetching working hours from text field
    public int fetchWorkingHours()
    {
        return Integer.parseInt(workingHoursTxt.getText());
    }

    //Fetching salary from text field
    public int fetchSalary()
    {
        return Integer.parseInt(salaryTxt.getText());
    }

    //Fetching wagesPerHour from text field
    public int fetchWagesPerHour()
    {
        return Integer.parseInt(wagesPerHourTxt.getText());
    }

    //Fetching shifts from text field
    public String fetchShifts()
    {
        return shiftsTxt.getText();
    }

    //Fetching Staff Name from text field
    public String fetchStaffName()
    {
        return staffNameTxt.getText();
    }

    //Fetching joining Date from text field
    public String fetchJoiningDate()
    {
        return joiningDateTxt.getText();
    }

    //Fetching appointed by from text field
    public String fetchAppointedBy()
    {
        return appointedByTxt.getText();
    }

    //Fetching qualification from text field
    public String fetchQualification()
    {
        return qualificationTxt.getText();
    }

    //Fetching terminating vacancy from text field
    public int fetchTerVacancy()
    {
        return Integer.parseInt(terVacancyNoTxt.getText());
    }

    //Method for the function of the buttons of the application
    @Override
    public void actionPerformed(ActionEvent e)
    {
        //Executes on clicking vacancyFtBtn button
        if(e.getSource() == vacancyFtBtn){
            //Sets jobSelected to FullTime and calls addVacancy method
            jobSelected = "FullTime";
            addVacancy();
        }
        //Executes on clicking vacancyPtBtn button
        if (e.getSource() == vacancyPtBtn){
            //Sets jobSelected to PartTime and calls addVacancy method
            jobSelected = "PartTime";
            addVacancy();
        }
        //Executes on clicking hireFtBtn button
        if(e.getSource() == hireFtBtn){
            //Sets jobSelected to FullTime and calls appointGui method
            jobSelected = "FullTime";
            appointGui();
        }
        //Executes on clicking hirePtBtn button
        if(e.getSource() == hirePtBtn){
            //Sets jobSelected to FullTime and calls appointGui method
            jobSelected = "PartTime";
            appointGui();
        }
        //Executes on clicking clearBtn button
        if (e.getSource() == clearBtn){
            //Sets the values of the text field to empty
            vacancyTxt.setText("");
            designationTxt.setText("");
            workingHoursTxt.setText("");
            salaryTxt.setText("");
            wagesPerHourTxt.setText("");
            shiftsTxt.setText("");
        }
        //Executes on clicking addBtn button
        if (e.getSource() == addBtn){
            //Calls checkDuplication method
            checkDuplication();
            vacancyFrame.dispose();
        }
        //Executes on clicking appointSubmitFt button
        if (e.getSource() == appointSubmitFt){
            vacancyInFrame.dispose();
            jobSelected = "FullTime";
            //Try catch to prevent exceptions (NumebrFormatException)
            try{
                check = false;
                boolean flag = false;
                if (vacancyTxt.getText().equals("")){
                    //shows following message if text field left empty
                    JOptionPane.showMessageDialog(mainFrame,"Please fill up the text field!");
                    flag = true;
                }
                if (flag == false){
                    for (StaffHire temp : staffVacancyli){
                        if (temp.getVacancyNo() == fetchvacancy() && temp.getJobType() == "Full-Time"){
                            check = true;
                            //Assigning the values from the arraylist to variables
                            vacNo = temp.getVacancyNo();
                            desig = temp.getDesignation();
                            jt = temp.getJobType();
                            FullTimeStaffHire fullObj = (FullTimeStaffHire) temp;
                            //Converting integer values to string values
                            workinghr = String.valueOf(fullObj.getWorkingHours());
                            sal = String.valueOf(fullObj.getSalary());
                            checkVacancy();
                        }
                    }
                    if (check == false){
                        JOptionPane.showMessageDialog(null,"Error! Record not found!");
                    }
                }
            }catch (Exception exc){
                
                JOptionPane.showMessageDialog(mainFrame,exc,"Error!",JOptionPane.ERROR_MESSAGE);
            }
        }
        //Executes on clicking appointSubmitPt button
        if (e.getSource() == appointSubmitPt){
            vacancyInFrame.dispose();
            jobSelected = "PartTime";
            try {
                check = false;
                boolean flag = false;
                if (vacancyTxt.getText().equals("")){
                    JOptionPane.showMessageDialog(mainFrame,"Please fill up the text field!");
                    flag = true;
                }
                if (flag ==false){
                    for (StaffHire temp : staffVacancyli){
                        if (temp.getVacancyNo() == fetchvacancy() && temp.getJobType() == "Part-Time"){
                            check = true;
                            vacNo = temp.getVacancyNo();
                            desig = temp.getDesignation();
                            jt = temp.getJobType();
                            PartTimeStaffHire partObj = (PartTimeStaffHire) temp;
                            workinghr = String.valueOf(partObj.getWorkingHours());
                            wph = String.valueOf(partObj.getWagesPerHour());
                            shft = partObj.getShifts();
                            checkVacancy();
                        }
                    }
                    if (check == false){
                        JOptionPane.showMessageDialog(mainFrame,"Error! Record not found!");
                    }
                }
            }catch (Exception exc){
                JOptionPane.showMessageDialog(mainFrame,exc,"Error!",JOptionPane.ERROR_MESSAGE);
            }
        }
        //Executes on clicking correctBtn button
        if (e.getSource() == correctBtn){
            hireStaff();
            checkFrame.dispose();
        }
        //Executes on clicking incorrectBtn button
        if (e.getSource() == incorrectBtn){
            checkFrame.dispose();
        }
        //Executes on clicking hire button
        if (e.getSource() == hire){
            if (staffNameTxt.getText().equals("") || appointedByTxt.getText().equals("") || qualificationTxt.getText().equals("") || joiningDateTxt.getText().equals("")){
                JOptionPane.showMessageDialog(mainFrame,"Please fill up every records in the form!","Error!", JOptionPane.ERROR_MESSAGE);
            }else{
                hireFrame.dispose();
                storingAppointment();
            }
        }
        //Executes on clicking clear button
        if (e.getSource() == clear){
            staffNameTxt.setText("");
            appointedByTxt.setText("");
            joiningDateTxt.setText("");
            qualificationTxt.setText("");
        }
        //Executes on clicking terminate button
        if (e.getSource() == terminateBtn){
            terminateStaffGui();
        }
        //Executes on clicking terBtn button
        if (e.getSource() == terBtn){
            try{
                Integer.parseInt(terVacancyNoTxt.getText());
                if (terVacancyNoTxt.getText().equals("")){
                    JOptionPane.showMessageDialog(mainFrame, "Please fill up the text field!");
                }else{
                    terminateStaff();
                }
            }catch (Exception exc){
                JOptionPane.showMessageDialog(mainFrame,exc,"Error!",JOptionPane.ERROR_MESSAGE);
            }
        }
        //Executes on clicking displayBtn button
        if (e.getSource() == displayBtn){
            displayConsole();
        }
    }
    //main method
    public static void main(String[] args)
    {
        //Creating an object called object
        INGNepal object = new INGNepal();
        //Calling the method to create interface called startingGui
        object.startingGui();
    }
}
