package studentdriver;
import java.util.*;
import java.io.*;
/**
 *
 * @author dianar
 */

public class StudentDriver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        StudentFees [] students = new StudentFees[12];
        File inputFile = new File("input.csv");
        Scanner studentFile = new Scanner(inputFile);
        
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the no of UG students: ");
        int num = input.nextInt();
        Scanner input2 = new Scanner(System.in);
        System.out.print("Enter the no of Graduate students: ");
        int num2 = input2.nextInt();
        Scanner input3 = new Scanner(System.in);
        System.out.print("Enter the no of online students: ");
        int num3 = input3.nextInt();
        
        BufferedReader reader;
        reader = new BufferedReader(new FileReader("input.csv"));
        String file = reader.readLine();
        int count = 0;
        
        while(file != null){
            String[] a;
            if(count < num){
                a = file.split(",");
                StudentFees student = new UGStudent(a[1], Integer.parseInt(a[0]),Boolean.parseBoolean(a[2]),Boolean.parseBoolean(a[4]),Double.parseDouble(a[5]),Integer.parseInt(a[3])); 
                //String studentName, int studentID, boolean isEnrolled,  boolean hasScholarship, 
                //double scholarshipAmount, int coursesEnrolled
                students[count] = student;
            }else if(count < num2 + num){
                a = file.split(",");
                StudentFees student = new GraduateStudent(a[1], Integer.parseInt(a[0]), Boolean.parseBoolean(a[2]), Boolean.parseBoolean(a[4]), a[5], Integer.parseInt(a[3]));
                //String studentName, int studentID, boolean isEnrolled, boolean isGraduateAssistant,
                //String GraduateAssistantType, int coursesEnrolled
                students[count] = student;
            }else if (count < num3 + num2 + num){
                a = file.split(",");
                StudentFees student = new OnlineStudent(a[1], Integer.parseInt(a[0]), Boolean.parseBoolean(a[2]), Integer.parseInt(a[4]));
                //tring studentName, int studentID, boolean isEnrolled, int noOfMonths) {
                //super(studentName, studentID, isEnrolled
                students[count] = student;
            }
            count += 1;
            
            file = reader.readLine();
        }
        
        count = 0;
        
        System.out.println("");
        
        for (StudentFees x : students) {
            if(count < num){
                if(count < num - num + 1){
                    System.out.println("**********Undergraduate students list**********");
                }
                System.out.println(x);                
            }else if(count < num2 + num){
                if(count == num){
                    System.out.println("**********Graduate students list**********");
                }
                System.out.println(x);
            }else if (count < num3 + num2 + num){
                if(count == num2 + num){
                    System.out.println("**********online students list**********");
                }
                System.out.println(x);
            }
            count += 1;
        }
    }
    

}
