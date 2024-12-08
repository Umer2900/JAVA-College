import java.util.Scanner;

class StringManipulator 
{
    private String inputString;

    // Constructor to set the input string
    public StringManipulator(String inputString) {
        this.inputString = inputString;
    }

    // Method to reverse the string
    public String reverseString() {
        String reversed = "";
        for (int i = inputString.length() - 1; i >= 0; i--) {
            reversed += inputString.charAt(i);
        }
        return reversed;
    }

    // Method to convert the string to uppercase
    public String toUpperCase() {
        return inputString.toUpperCase();
    }

    // Method to convert the string to lowercase
    public String toLowerCase() {
        return inputString.toLowerCase();
    }

    // Method to check if the string is a palindrome
    public boolean isPalindrome() {
        String reversed = reverseString();
        return inputString.equalsIgnoreCase(reversed);
    }

    // Method to count vowels and consonants
    public void countVowelsAndConsonants() {
        int vowels = 0, consonants = 0;
        String lowerCaseString = inputString.toLowerCase();

        for (int i = 0; i < lowerCaseString.length(); i++) {
            char ch = lowerCaseString.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                if ("aeiou".indexOf(ch) != -1) {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }

        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
    }
}

class StringManipulationToolkit 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);

        while (true) 
        {
            System.out.println("\n--- String Manipulation Toolkit ---");
            System.out.println("1. Reverse a string");
            System.out.println("2. Convert to uppercase");
            System.out.println("3. Convert to lowercase");
            System.out.println("4. Check if palindrome");
            System.out.println("5. Count vowels and consonants");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            if (choice == 6) {
                System.out.println("Exiting... Thank you!");
                break;
            }

            System.out.print("Enter a string: ");
            String input = scanner.nextLine();
            StringManipulator manipulator = new StringManipulator(input);

            switch (choice) {
                case 1:
                    System.out.println("Reversed String: " + manipulator.reverseString());
                    break;
                case 2:
                    System.out.println("Uppercase String: " + manipulator.toUpperCase());
                    break;
                case 3:
                    System.out.println("Lowercase String: " + manipulator.toLowerCase());
                    break;
                case 4:
                    if (manipulator.isPalindrome()) {
                        System.out.println("The string is a palindrome.");
                    } else {
                        System.out.println("The string is not a palindrome.");
                    }
                    break;
                case 5:
                    manipulator.countVowelsAndConsonants();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}
