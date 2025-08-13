// import java.util.*;
// public class Rockgame {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         System.out.println("For Player 1 : Enter your choice (Rock,Paper,Scissor)");
//         String choice1 = sc.next();
//         Random rs = new Random();
//         System.out.println("For Player 2 : Enter your choice (Rock,Paper,Scissor)");
//         int choice2 = rs.nextInt();
//         if (choice1.equals(choice2)) {
//             System.out.println("It's a tie!");
//         }
//         else if (choice1.equals("Rock") && choice2.equals(2)) {
//             System.out.println("Paper wins");
//         }   
//         else if (choice1.equals("Rock") && choice2.equals(3)) {
//             System.out.println("Rock wins");
//         }
//         else if (choice1.equals("Scissor") && choice2.equals(2)) {
//             System.out.println("Scissor wins");
//         } 
//         else if (choice1.equals("Paper") && choice2.equals(1)) {
//             System.out.println("Paper wins");
//         }
//         else if (choice1.equals("Scissor") && choice2.equals(1)) {
//             System.out.println("Rock wins");
//         } 
//         else if (choice1.equals("Paper") && choice2.equals(3)) {
//             System.out.println("Scissor wins");
//         }
//     }
    
// }

//using Random |_
 //              |

import java.util.Scanner;
import java.util.Random;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rs = new Random();

        System.out.println("For Player 1: Enter your choice (Rock, Paper, Scissor)");
        String choice1 = sc.next().trim();  // trim removes the unwanted spaces

        // Generate random choice for Player 2
        int rand = rs.nextInt(3); // 0, 1, or 2
        String choice2 = "";
        switch (rand) {
            case 0: choice2 = "Rock"; break;
            case 1: choice2 = "Paper"; break;
            case 2: choice2 = "Scissor"; break;
        }

        System.out.println("Player 2 chooses: " + choice2);

        // Determine winner
        if (choice1.equalsIgnoreCase(choice2)) { //you can also use .equals only but this can correct problems like rock = Rock = ROCK
            System.out.println("It's a tie!");
        } else if (
            (choice1.equalsIgnoreCase("Rock") && choice2.equals("Scissor")) ||
            (choice1.equalsIgnoreCase("Paper") && choice2.equals("Rock")) ||
            (choice1.equalsIgnoreCase("Scissor") && choice2.equals("Paper"))
        ) {
            System.out.println("Player 1 wins!");
        } else {
            System.out.println("Player 2 wins!");
        }
        sc.close();
    }
}