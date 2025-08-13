public class Ex5e {
    public static void main(String[] args) {
        int number = 5;           // The number to find factorial of
        int factorial = 1;        // Variable to store the result

        // Loop from 1 to number
        for (int i = 1; i <= number; i++) {
            factorial *= i;      // Multiply factorial by current value of i
            //System.out.println(factorial);
        }

        // Display the result
        System.out.println("Factorial of " + number + " is: " + factorial);
    }

}
