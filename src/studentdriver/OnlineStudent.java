package studentdriver;

/**
 *
 * @author s563952
 */
public class OnlineStudent extends StudentFees {
    int noOfMonths;
    double MONTHLY_FEE = 1245.25;
    
    public OnlineStudent(String studentName, int studentID, boolean isEnrolled, int noOfMonths) {
        super(studentName, studentID, isEnrolled);
        this.noOfMonths = noOfMonths;
    }

    @Override
    public double getPayableAmount() {
        return MONTHLY_FEE * noOfMonths;
    }
    
    public String toString ()
    {
         return "StudentName: " +getStudentName() + "\nStudentID: " + getStudentID() + "\nEnrolled: " + isIsEnrolled() 
                 + "\nNo of Months: " + noOfMonths + "\nPayable amount: " + getPayableAmount();
    }  
    
}
