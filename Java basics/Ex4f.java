import java.util.*;
public class Ex4f {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        if (a.endsWith(".org"))
        {
            System.out.println("It is an organisation website");
        }
        else if (a.endsWith(".in"))
        {
            System.out.println("It is an Indian website");
        }
        if (a.endsWith(".com"))
        {
            System.out.println("It is a commercial website");
        }
        sc.close();

    }
    
}
