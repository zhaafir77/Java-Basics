public class Ex5f {
    public static void main(String[] args) {
        int n = 5;
        int i = 1;
        int factorial = 1;
        while (i<=n){
            factorial *= i;
            i++;
        }
        System.out.println(factorial);
    }
    
}
