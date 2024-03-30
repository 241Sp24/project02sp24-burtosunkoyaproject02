/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentdriver;

/**
 *
 * @author s563952
 */
public class UGStudent extends StudentFees{
    private double scholarshipAmount;
    private int coursesEnrolled;
    private boolean hasScholarship;
    private double ADDITIONAL_FEE = 820.70;
    
    public UGStudent(String studentName, int studentID, boolean isEnrolled,  boolean hasScholarship, 
            double scholarshipAmount, int coursesEnrolled) 
    {
        super(studentName, studentID, isEnrolled);
        this.scholarshipAmount = scholarshipAmount;
        this.coursesEnrolled = coursesEnrolled;
        this.hasScholarship = hasScholarship;
    }
    
    public boolean isHasScholarship()
    {
        return hasScholarship;
    }

    /**
     * @return the scholarshipAmount
     */
    public double getScholarshipAmount() {
        return scholarshipAmount;
    }

    /**
     * @return the coursesEnrolled
     */
    public int getCoursesEnrolled() {
        return coursesEnrolled;
    }
    
    @Override
    public double getPayableAmount ()
    {
        return (coursesEnrolled * getCREDITS_PER_COURSE() * getPER_CREDIT_Fee()) + ADDITIONAL_FEE 
                - scholarshipAmount;
    }
       
    public String toString ()
    {
        return "StudentName: " +getStudentName() + "\nStudentID: " + getStudentID() + "\nEnrolled: " + isIsEnrolled()
                + "\nScholarship: " + hasScholarship + "\nScholarship amount: " + scholarshipAmount 
                + "\nCourses Enrolled: " + coursesEnrolled + "\nPayable amount: " + getPayableAmount();
    }
}
