import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class PangramChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String input = scanner.nextLine();

        boolean isPangram = checkIfPangram(input);

        if (isPangram) {
            System.out.println("The input is a pangram.");
        } else {
            System.out.println("The input is not a pangram.");
        }

        scanner.close();
    }

    public static boolean checkIfPangram(String input) {
        
        input = input.toLowerCase();

        
        Set<Character> letters = new HashSet<>();

       
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);

            
            if (Character.isLetter(currentChar)) {
                letters.add(currentChar);
            }
        }

        
        return letters.size() == 26;
    }
}
