import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RomanToInteger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Roman Numeral: ");
        String romanNumeral = scanner.nextLine().toUpperCase();

        int result = convertToInteger(romanNumeral);
        System.out.println("Integer Value: " + result);

        scanner.close();
    }

    public static int convertToInteger(String romanNumeral) {
        Map<Character, Integer> romanNumerals = new HashMap<>();
        romanNumerals.put('I', 1);
        romanNumerals.put('V', 5);
        romanNumerals.put('X', 10);
        romanNumerals.put('L', 50);
        romanNumerals.put('C', 100);
        romanNumerals.put('D', 500);
        romanNumerals.put('M', 1000);

        int result = 0;

        for (int i = 0; i < romanNumeral.length(); i++) {
            int currentNumeral = romanNumerals.get(romanNumeral.charAt(i));

            
            if (i + 1 < romanNumeral.length() && romanNumerals.get(romanNumeral.charAt(i + 1)) > currentNumeral) {
                result += romanNumerals.get(romanNumeral.charAt(i + 1)) - currentNumeral;
                i++;
            } else {
                result += currentNumeral;
            }
        }

        return result;
    }
}
