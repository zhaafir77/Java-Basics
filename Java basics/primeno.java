import java.util.*; 
public class primeno {
    public static void main(String[]args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean b = true;

        if (n <= 1) b = false;
        for (int i = 2; i<=Math.sqrt(n);i++)
        {
            if(n%i==0);
            b = false;
            break;
        }
        if (b)
        {
            System.out.println(n + "It is a prime no.");

        }
        else{
            System.out.println(n + "It is not a prime no.");
        }
        sc.close();
    }
    
}
