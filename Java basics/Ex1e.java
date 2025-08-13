import java.util.*;
public class Ex1e {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no. to check wether it is Integer or not: ");
        boolean a = sc.hasNextInt();
        if (a == true) {
            System.out.println("Yes, the given no. is Integer");
        sc.close();
          
        }
        
    }
    
}
