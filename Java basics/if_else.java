import java.util.*;
public class if_else {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        System.out.println("Enter the age");
        int a = sc.nextInt();
        if(a>=18)
        {
            System.out.println("You can drive");
        }
        else if(a>60)
        {
            System.out.println("You are overaged to drive");
        }
        else
        {
            System.out.println("You can't drive");
        }
        sc.close();
    }

    
    
}
//else is not necessary only single if can be enough