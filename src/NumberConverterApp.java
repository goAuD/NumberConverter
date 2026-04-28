import java.math.BigInteger;
import java.util.Scanner;

public class NumberConverterApp {
    public static void main(String[] args) {
        Scanner eingabeScanner = new Scanner(System.in);
        boolean appLaeuft = true;

        while (appLaeuft) {
            printMenu();
            String ausgewaehlteOption = eingabeScanner.nextLine().trim();

            switch (ausgewaehlteOption) {
                case "1" -> handleDecimalToBinary(eingabeScanner);
                case "2" -> handleBinaryToDecimal(eingabeScanner);
                case "3" -> handleDecimalToHexadecimal(eingabeScanner);
                case "4" -> handleHexadecimalToDecimal(eingabeScanner);
                case "5" -> handleHexadecimalToBinary(eingabeScanner);
                case "6" -> handleBinaryToHexadecimal(eingabeScanner);
                case "7" -> handlePrefixToClients(eingabeScanner);
                case "0" -> appLaeuft = false;
                default -> System.out.println("Invalid option. Please choose a number from 0 to 7.");
            }

            if (appLaeuft) {
                System.out.println();
            }
        }

        System.out.println("Goodbye.");
        eingabeScanner.close();
    }

    private static void printMenu() {
        System.out.println("Number Converter");
        System.out.println("1. Decimal to binary");
        System.out.println("2. Binary to decimal");
        System.out.println("3. Decimal to hexadecimal");
        System.out.println("4. Hexadecimal to decimal");
        System.out.println("5. Hexadecimal to binary");
        System.out.println("6. Binary to hexadecimal");
        System.out.println("7. Network prefix to clients");
        System.out.println("0. Exit");
        System.out.print("Choose an option: ");
    }

    private static void handleDecimalToBinary(Scanner eingabeScanner) {
        BigInteger dezimalZahl = readDecimalNumber(eingabeScanner);
        System.out.println("Binary result: " + dezimalZahl.toString(2));
    }

    private static void handleBinaryToDecimal(Scanner eingabeScanner) {
        String binaerZahl = readBinaryNumber(eingabeScanner);
        BigInteger dezimalZahl = new BigInteger(binaerZahl, 2);
        System.out.println("Decimal result: " + dezimalZahl);
    }

    private static void handleDecimalToHexadecimal(Scanner eingabeScanner) {
        BigInteger dezimalZahl = readDecimalNumber(eingabeScanner);
        System.out.println("Hexadecimal result: " + dezimalZahl.toString(16).toUpperCase());
    }

    private static void handleHexadecimalToDecimal(Scanner eingabeScanner) {
        String hexadezimalZahl = readHexadecimalNumber(eingabeScanner);
        BigInteger dezimalZahl = new BigInteger(hexadezimalZahl, 16);
        System.out.println("Decimal result: " + dezimalZahl);
    }

    private static void handleHexadecimalToBinary(Scanner eingabeScanner) {
        String hexadezimalZahl = readHexadecimalNumber(eingabeScanner);
        BigInteger dezimalZahl = new BigInteger(hexadezimalZahl, 16);
        System.out.println("Binary result: " + dezimalZahl.toString(2));
    }

    private static void handleBinaryToHexadecimal(Scanner eingabeScanner) {
        String binaerZahl = readBinaryNumber(eingabeScanner);
        BigInteger dezimalZahl = new BigInteger(binaerZahl, 2);
        System.out.println("Hexadecimal result: " + dezimalZahl.toString(16).toUpperCase());
    }

    private static void handlePrefixToClients(Scanner eingabeScanner) {
        int prefixLaenge = readPrefixLength(eingabeScanner);
        int anzahlHostBits = 32 - prefixLaenge;
        long anzahlAdressen = 1;

        for (int zaehler = 0; zaehler < anzahlHostBits; zaehler++) {
            anzahlAdressen *= 2;
        }

        long anzahlClients = anzahlAdressen - 2;

        if (anzahlClients < 0) {
            anzahlClients = 0;
        }

        System.out.println("Prefix: /" + prefixLaenge);
        System.out.println("Host bits: " + anzahlHostBits);
        System.out.println("Total addresses: " + anzahlAdressen);
        System.out.println("Usable clients: " + anzahlClients);
    }

    private static BigInteger readDecimalNumber(Scanner eingabeScanner) {
        while (true) {
            System.out.print("Enter a decimal number: ");
            String eingabe = eingabeScanner.nextLine().trim();

            try {
                BigInteger dezimalZahl = new BigInteger(eingabe);

                if (dezimalZahl.signum() < 0) {
                    System.out.println("Negative numbers are not supported. Please enter a non-negative decimal number.");
                    continue;
                }

                return dezimalZahl;
            } catch (NumberFormatException exception) {
                System.out.println("Invalid decimal number. Please enter a valid non-negative integer.");
            }
        }
    }

    private static String readBinaryNumber(Scanner eingabeScanner) {
        while (true) {
            System.out.print("Enter a binary number: ");
            String eingabe = eingabeScanner.nextLine().trim();

            if (eingabe.startsWith("-")) {
                System.out.println("Negative numbers are not supported. Please enter a non-negative binary number.");
                continue;
            }

            if (!eingabe.matches("[01]+")) {
                System.out.println("Invalid binary number. Please enter a valid binary number consisting of 0s and 1s.");
                continue;
            }

            return eingabe;
        }
    }

    private static String readHexadecimalNumber(Scanner eingabeScanner) {
        while (true) {
            System.out.print("Enter a hexadecimal number: ");
            String eingabe = eingabeScanner.nextLine().trim().toUpperCase();

            if (eingabe.startsWith("-")) {
                System.out.println("Negative numbers are not supported. Please enter a non-negative hexadecimal number.");
                continue;
            }

            if (!eingabe.matches("[0-9A-F]+")) {
                System.out.println("Invalid hexadecimal number. Please enter digits from 0 to 9 and letters from A to F.");
                continue;
            }

            return eingabe;
        }
    }

    private static int readPrefixLength(Scanner eingabeScanner) {
        while (true) {
            System.out.print("Enter a network prefix, for example /28 or 28: ");
            String eingabe = eingabeScanner.nextLine().trim();

            if (eingabe.startsWith("/")) {
                eingabe = eingabe.substring(1);
            }

            try {
                int prefixLaenge = Integer.parseInt(eingabe);

                if (prefixLaenge < 0 || prefixLaenge > 32) {
                    System.out.println("Invalid prefix. Please enter a number from 0 to 32.");
                    continue;
                }

                return prefixLaenge;
            } catch (NumberFormatException exception) {
                System.out.println("Invalid prefix. Please enter a number from 0 to 32.");
            }
        }
    }
}
