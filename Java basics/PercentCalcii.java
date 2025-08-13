import java.util.*;
public class PercentCalcii {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your English Marks");
        int a = sc.nextInt();
        System.out.println("Enter your Maths Marks");
        int b = sc.nextInt();
        System.out.println("Enter your Science Marks");
        int c = sc.nextInt();
        System.out.println("Enter your Hindi Marks");
        int d = sc.nextInt();
        System.out.println("Enter your SST Marks");
        int e = sc.nextInt();

        System.out.println("Total Percentage: " + (a + b + c + d + e)/2.00 + "%");
        sc.close();

    } 
    
}
