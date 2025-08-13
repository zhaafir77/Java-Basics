import java.util.Scanner;
public class Ex4c {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        float Tax = 0f;
        System.out.println("Enter your income divided 100000");
        float income = sc.nextFloat();
        if  (income<2.5){
            System.out.println("You are tax free");
        }
        else if (income > 2.5 && income <=5 ) {
                Tax = 0.05f*(income - 2.5f);
                System.out.println("You have to pay" + Tax);
        }
        else if (income > 5 && income <= 10 ) {
                Tax = 0.05f*(income - 2.5f);
                Tax = 0.2f*(income-5);
                System.out.println("You have to pay" + Tax);
        }
        else if (income > 10) {
                Tax = 0.05f*(income - 2.5f);
                Tax = 0.2f*(income-5);
                Tax = 0.3f*(income - 10);
                System.out.println("You have to pay" + Tax);
        }
        
        sc.close();
    }

    
}