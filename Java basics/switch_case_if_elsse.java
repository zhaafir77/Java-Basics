import java.util.Scanner;

public class switch_case_if_elsse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n Enter age: ");
        int age = sc.nextInt();
        switch(age)
        {
            case 18:
                System.out.println("You are going to become an adult");
                break;
            case 21:
                System.out.println("You are going to join a job");
                break;
            case 60:
                System.out.println("You are going to retire");
                break;
            default:
                System.out.println("enjoy your life");

            //can be done with any data types
            //also see about enhance switch case using -> this symbol
        }

        if (age>56)
        {
            System.out.println("You are experienced");
        }
        else if (age>46)
        {
            System.out.println("You are semi experienced");
        }
        else if (age>36)
        {
            System.out.println("You are semi semi experienced");
        }
        else
        {
            System.out.println("You are not experienced");
        }
        sc.close();
    }
    
}
