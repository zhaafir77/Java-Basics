import java.util.Scanner;

public class Ex4b {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Write maximum marks");
        float m = sc.nextFloat();
        System.out.println("Write Marks");
        float a = sc.nextFloat();
        a = (a/m)*100;
        System.out.println("Write Marks");
        float b = sc.nextFloat();
        b = (b/m)*100;
        System.out.println("Write Marks");
        float c = sc.nextFloat();
        c = (c/m)*100;
        float d = ((a+b+c)*100)/m;
        if (a==33 && b==33 && c==33 && d<=40){
            System.out.println("You are pass");
        }
        else{
            System.out.println("You are fail");
        }
        System.out.println(d);
        sc.close();

    }
    
}
