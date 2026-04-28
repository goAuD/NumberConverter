import java.util.Scanner;

class HexadecimalToInteger {
    public static void main(String[] args) {
        String hexadezimalZahl;
        char hexadezimalZeichen;
        int restWert;
        int dezimalErgebnis = 0;
        int stellenWert = 1;
        int index;
        Scanner eingabeScanner = new Scanner(System.in);

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

            try {
                Integer.parseInt(eingabe, 16);
            } catch (NumberFormatException exception) {
                System.out.println("Invalid hexadecimal number. Please enter a smaller hexadecimal integer.");
                continue;
            }

            hexadezimalZahl = eingabe;
            break;
        }

        index = hexadezimalZahl.length() - 1;

        while (index >= 0) {
            hexadezimalZeichen = hexadezimalZahl.charAt(index); // F / F

            restWert = switch (hexadezimalZeichen) {
                case 'A' -> 10;
                case 'B' -> 11;
                case 'C' -> 12;
                case 'D' -> 13;
                case 'E' -> 14;
                case 'F' -> 15;
                default -> hexadezimalZeichen - '0';
            };

            dezimalErgebnis += stellenWert * restWert; // 15 / 255
            stellenWert *= 16; // 16 / 256
            index--;
        }

        System.out.println(dezimalErgebnis); // 255
        eingabeScanner.close();
    }
}
