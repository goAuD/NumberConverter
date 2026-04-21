import java.math.BigInteger;
import java.util.Scanner;

public class BinaryDecimalConverterApp {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Binary Decimal Converter");
            System.out.println("1. Decimal to binary");
            System.out.println("2. Binary to decimal");
            System.out.print("Choose an option (1 or 2): ");

            String selectedOption = scanner.nextLine().trim();

            switch (selectedOption) {
                case "1" -> handleDecimalToBinary(scanner);
                case "2" -> handleBinaryToDecimal(scanner);
                default -> System.out.println("Invalid option. Please restart the app and choose 1 or 2.");
            }
        }
    }

    private static void handleDecimalToBinary(Scanner scanner) {
        System.out.print("Enter a non-negative decimal number: ");
        String decimalInput = scanner.nextLine().trim();

        try {
            BigInteger decimalNumber = new BigInteger(decimalInput);

            if (decimalNumber.signum() < 0) {
                System.out.println("Only non-negative decimal numbers are supported.");
                return;
            }

            System.out.println("Binary result: " + decimalNumber.toString(2));
        } catch (NumberFormatException exception) {
            System.out.println("Invalid decimal number.");
        }
    }

    private static void handleBinaryToDecimal(Scanner scanner) {
        System.out.print("Enter a binary number: ");
        String binaryInput = scanner.nextLine().trim();

        if (!binaryInput.matches("[01]+")) {
            System.out.println("Invalid binary number. Use only 0 and 1.");
            return;
        }

        BigInteger decimalNumber = new BigInteger(binaryInput, 2);
        System.out.println("Decimal result: " + decimalNumber);
    }
}
