import java.util.Scanner;

public class dowhileloops {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number in form (n--1)");
        int num = sc.nextInt();
        int i = 1;
        do{
            System.out.println(i);
            i++;
        }while(i<num);
        sc.close();
    }
}
