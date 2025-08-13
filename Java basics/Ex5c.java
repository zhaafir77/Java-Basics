import java.util.Scanner;
public class Ex5c {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //for (int i = 0; i<11; i++)
        for(int i =1; i<=10; i++){
            System.out.printf("%d X %d = %d\n",n,i, n*i);
            
        }
        sc.close();

    }
    
}
