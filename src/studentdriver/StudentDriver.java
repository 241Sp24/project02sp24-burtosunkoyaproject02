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
        Scanner file = new Scanner(inputFile);
        
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the no of UG students: ");
        int num = input.nextInt();
        Scanner input2 = new Scanner(System.in);
        System.out.print("Enter the no of Graduate students: ");
        int num2 = input2.nextInt();
        Scanner input3 = new Scanner(System.in);
        System.out.print("Enter the no of online students: ");
        int num3 = input3.nextInt();
  
        int count = 0;
        
        while(file.hasNext() == true){
            String[] a;
            if(count < num){
                a = file.nextLine().split(",");
                UGStudent student = new UGStudent(a[1],Integer.parseInt(a[0]),Boolean.parseBoolean(a[2]),Boolean.parseBoolean(a[4]),Double.parseDouble(a[5]),Integer.parseInt(a[3])); 
                students[count] = student;                
            }else if(count < num2 + num){
                a = file.nextLine().split(",");
                if(a.length == 6){
                    GraduateStudent student = new GraduateStudent(a[1], Integer.parseInt(a[0]), Boolean.parseBoolean(a[2]), Boolean.parseBoolean(a[4]), a[5], Integer.parseInt(a[3]));
                    students[count] = student;
                }else if(a[4].equals("false")){
                    GraduateStudent student = new GraduateStudent(a[1], Integer.parseInt(a[0]), Boolean.parseBoolean(a[2]), Boolean.parseBoolean(a[4]), "", Integer.parseInt(a[3]));
                    students[count] = student;
                }
            }else if (count < num3 + num2 + num){
                a = file.nextLine().split(",");
                OnlineStudent student = new OnlineStudent(a[1],Integer.parseInt(a[0]),Boolean.parseBoolean(a[2]),Integer.parseInt(a[3]));
                
                students[count] = student;
            }
            count += 1;
        }
        count = 0;
        
        System.out.println("");
        
        for (StudentFees x : students) {
            if(count < num){
                if(count < num - num + 1){
                    System.out.println("**********Undergraduate students list**********");
                }
                System.out.println(x + "\n");                
            }else if(count < num2 + num){
                if(count == num){
                    System.out.println("**********Graduate students list**********");
                }
                System.out.println(x + "\n");
            }else if (count < num3 + num2 + num){
                if(count == num2 + num){
                    System.out.println("**********online students list**********");
                }
                System.out.println(x + "\n");
            }
            count += 1;
        }
        
        //UG Student Details
        System.out.println("**********Undergraduate Students details**********");
        
        double total = 0;
        double UGaverage;
        int repeat = 0;
        int scholarshipCount = 0;
        int coursesCount = 0;
        
        for (StudentFees u: students)
        {
            if(u instanceof UGStudent){
                if (((UGStudent) u).isHasScholarship())
                {
                    scholarshipCount ++;
                }
            }
            if (u instanceof UGStudent){
                if (((UGStudent) u).isIsEnrolled() == true)
                {
                    coursesCount += ((UGStudent) u).getCoursesEnrolled();
                    total += u.getPayableAmount();
                    repeat ++;
                }
            }
        }
        UGaverage = total/repeat; 
        System.out.printf("\nAverage Students fee %.2f\n", UGaverage);
        System.out.println("Scholarship count: " + scholarshipCount);
        System.out.println("Total number of courses: " + coursesCount);
        
        //Grad Student Details
        System.out.println("\n**********Graduate Students details**********");
        
        total = 0;
        double Gaverage;
        repeat = 0;
        scholarshipCount = 0;
        coursesCount = 0;
        
        for (StudentFees g: students)
        {
            if(g instanceof GraduateStudent){
                if (((GraduateStudent) g).isISGraduateAssistant())
                {
                    scholarshipCount ++;
                }
            }
            if (g instanceof GraduateStudent){
                if (((GraduateStudent) g).isIsEnrolled() == true)
                {
                    coursesCount += ((GraduateStudent) g).getCoursesEnrolled();
                    total += g.getPayableAmount();
                    repeat ++;
                }
            }
        }
        Gaverage = total/repeat;
        System.out.printf("Average Students fee %.2f\n", Gaverage);
        System.out.println("Graduate Assistantship count: " + scholarshipCount);
        System.out.println("Total number of courses: " + coursesCount);
        
        //Online Student Details
        System.out.println("\n**********Online Students details**********");
        
        total = 0;
        double Oaverage;
        repeat = 0;
        
        for (StudentFees o: students)
        {
            if (o instanceof OnlineStudent){
                if (((OnlineStudent) o).isIsEnrolled() == true)
                {
                    coursesCount += ((OnlineStudent) o).getPayableAmount();
                    total += o.getPayableAmount();
                    repeat ++;
                }
            }
        }
        Oaverage = total/repeat; 
        System.out.printf("Average Students fee %.2f\n", Oaverage);      
    }
}

