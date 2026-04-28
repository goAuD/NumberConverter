import java.util.Scanner;

class BinaryToHexadecimal {
    public static void main(String[] args) {
        String binaerZahl;
        int binaerZiffer;
        int dezimalWert;
        int stellenWert;
        int anzahlBits;
        int index;
        String hexadezimalZeichen;
        String hexadezimalErgebnis = "";
        Scanner eingabeScanner = new Scanner(System.in);

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

            binaerZahl = eingabe;
            break;
        }

        index = binaerZahl.length() - 1;

        while (index >= 0) {
            dezimalWert = 0;
            stellenWert = 1;
            anzahlBits = 0;

            while (index >= 0 && anzahlBits < 4) {
                binaerZiffer = binaerZahl.charAt(index) - '0'; // 0 / 1 / 0 / 1
                dezimalWert += stellenWert * binaerZiffer; // 0 / 2 / 2 / 10
                stellenWert *= 2; // 2 / 4 / 8 / 16
                index--;
                anzahlBits++;
            }

            hexadezimalZeichen = switch (dezimalWert) {
                case 10 -> "A";
                case 11 -> "B";
                case 12 -> "C";
                case 13 -> "D";
                case 14 -> "E";
                case 15 -> "F";
                default -> "" + dezimalWert;
            };

            hexadezimalErgebnis = hexadezimalZeichen + hexadezimalErgebnis; // A
        }

        while (hexadezimalErgebnis.length() > 1 && hexadezimalErgebnis.startsWith("0")) {
            hexadezimalErgebnis = hexadezimalErgebnis.substring(1);
        }

        System.out.println(hexadezimalErgebnis); // A
        eingabeScanner.close();
    }
}
