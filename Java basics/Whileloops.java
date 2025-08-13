import java.util.*;
public class Whileloops {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number");
        int num = sc.nextInt();
        int i = 1;
        while (i<=num){
            System.out.println(i);
            i++;
        }
        System.out.println("Finished! ");
        // Infinite loop
        // while (true) {
        //     System.out.println(i);
        //     i++;
        //     //use ctrl + c to  stop the loop

        // }
        sc.close();
    }
    
}
