import java.util.*;

public class Area {

    public static void main(String[] args)
     {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the radius: ");
        Double a = sc.nextDouble();
        Double b = 3.14;
        System.out.print("Here the area of circle is:");
        System.out.println(a*a*b);
        sc.close();

    }
}