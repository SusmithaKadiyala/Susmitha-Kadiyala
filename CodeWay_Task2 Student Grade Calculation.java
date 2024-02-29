import java.util.*;
import java.lang.*;
public class Grade{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter total number of subjects");
        int total_subjects = sc.nextInt();
        int total_marks= 0;
        for(int i=1;i<=total_subjects;i++)
        {
            System.out.println("Enter marks obtained in suject"+" "+i+" "+"out of 100");
            int marks = sc.nextInt();
            if(marks<0 || marks>100)
            {
                System.out.println("Enter valid input marks should be in range between 0 to 100");
                i--;
            }
            else
            {
                total_marks+=marks;
            }
        }
        double averagePercentage = (double) total_marks / total_subjects;
        System.out.println("\nResults:");
        System.out.println("Total Marks: " + total_marks + " out of " + (total_subjects* 100));
        System.out.printf("Average Percentage: %.2f%%\n", averagePercentage);
        System.out.println("Grade: " + calculateGrade(averagePercentage));

        sc.close();
    }
    private static String calculateGrade(double averagePercentage)
    {
         if (averagePercentage >= 90) {
            return "A+";
         }
         else if(averagePercentage >= 80)
        { 
            return "A";
        }
        else if(averagePercentage >= 70)
        {
            return "B";
        }
        else if(averagePercentage >=60)
        {
            return "D";
        }
        else if(averagePercentage >=50)
        {
            return "P";
        }
        else
        {
            return "F";
      }
   }
}
    