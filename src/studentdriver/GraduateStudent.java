
package studentdriver;

/**
 *
 * @author s563952
 */
public class GraduateStudent extends StudentFees {
    private int coursesEnrolled;
    private boolean isGraduateAssistant;
    private String GraduateAssistantType;
    private double ADDITIONAL_FEE = 654.45;
    
    public GraduateStudent(String studentName, int studentID, boolean isEnrolled, boolean isGraduateAssistant,
            String GraduateAssistantType, int coursesEnrolled) 
    {
        super(studentName, studentID, isEnrolled);
        this.coursesEnrolled = coursesEnrolled;
        this.isGraduateAssistant = isGraduateAssistant;
        this.GraduateAssistantType = GraduateAssistantType;
    }
    
    public GraduateStudent(String studentName, int studentID, boolean isEnrolled, boolean isGraduateAssistant,
            int coursesEnrolled) 
    {
        super(studentName, studentID, isEnrolled);
        this.coursesEnrolled = coursesEnrolled;
        this.isGraduateAssistant = isGraduateAssistant;
    }
    
    public boolean isISGraduateAssistant()
    {
        return isGraduateAssistant;
    }
    
    /**
     * @return the coursesEnrolled
     */
    public int getCoursesEnrolled() {
        return coursesEnrolled;
    }

    @Override
    public double getPayableAmount() {
        double amount = 0;
        if (GraduateAssistantType.equals("full"))
        {
           amount = 0;
        }
        else {
            amount = ((coursesEnrolled * getCREDITS_PER_COURSE() * getPER_CREDIT_Fee()) + ADDITIONAL_FEE) / 2;
        }
        return amount;
    }
    
    public String toString ()
    {
        return "StudentName: " +getStudentName() + "\nStudentID: " + getStudentID() + "\nEnrolled: " + isIsEnrolled()
                + "\nGraduate assistant: " + isGraduateAssistant + "\nGraduate assistant type: " + GraduateAssistantType
                + "\nCourses Enrolled: " + coursesEnrolled + "\nPayable amount: " + getPayableAmount();
    }  
    
}
