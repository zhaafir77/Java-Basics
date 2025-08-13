import java.util.*;
public class Ex1b {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter marks: ");
        double a = sc.nextDouble();
        a /=  10;
        System.out.print("Enter marks: ");
        double b = sc.nextDouble();
        b /= 10;
        System.out.print("Enter marks: ");
        double c = sc.nextDouble();
        c /= 10;

        System.out.println("CGPA: " + (a+b+c)/3.0 );
        sc.close();

        
        
    }
    

    
}
