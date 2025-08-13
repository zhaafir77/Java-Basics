import java.util.*;
public class TakingInputs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no. ");
        //int a = sc.nextInt();
        boolean b = sc.hasNextInt();    //To check the datat  type of input from user
        System.out.println(b);
        sc.close();


    }
    
}
