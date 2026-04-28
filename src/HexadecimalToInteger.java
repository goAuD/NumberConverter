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

            if (hexadezimalZeichen >= '0' && hexadezimalZeichen <= '9') {
                restWert = hexadezimalZeichen - '0';
            } else if (hexadezimalZeichen == 'A') {
                restWert = 10;
            } else if (hexadezimalZeichen == 'B') {
                restWert = 11;
            } else if (hexadezimalZeichen == 'C') {
                restWert = 12;
            } else if (hexadezimalZeichen == 'D') {
                restWert = 13;
            } else if (hexadezimalZeichen == 'E') {
                restWert = 14;
            } else {
                restWert = 15;
            }

            dezimalErgebnis += stellenWert * restWert; // 15 / 255
            stellenWert *= 16; // 16 / 256
            index--;
        }

        System.out.println(dezimalErgebnis); // 255
        eingabeScanner.close();
    }
}
