import java.util.*;
public class Armstrong {
    public static void main(String[]args) 
    {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int temp = num , sum = 0 , digit = 0;

        //Count the digits

        while (temp>0)
        {
            digit++;
            temp/=10;

        }
        temp = num;
        while (temp>0)
        {
            int rem = temp % 10;
            sum += Math.pow(rem,digit);
            temp/=10;

        }
        
        if (sum==num)
        {
            System.out.println(num + "is an armstrong number");
            
        }
        else 
        {
            System.out.println(num + "It is not an armstrong number");

        }
        sc.close();
    
    }

    
}
