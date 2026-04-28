import java.util.Scanner;

class BinaryToInteger {
    public static void main(String[] args) {
        int binaerZahl;
        int restWert;
        int dezimalErgebnis = 0;
        int stellenWert = 1;
        Scanner eingabeScanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter a binary number: ");
            String eingabe = eingabeScanner.nextLine().trim();

            try {
                binaerZahl = Integer.parseInt(eingabe);
            } catch (NumberFormatException exception) {
                System.out.println("Invalid binary number. Please enter a valid binary number consisting of 0s and 1s.");
                continue;
            }

            if (binaerZahl < 0) {
                System.out.println("Negative numbers are not supported. Please enter a non-negative binary number.");
                continue;
            }

            if (!eingabe.matches("[01]+")) {
                System.out.println("Invalid binary number. Please enter a valid binary number consisting of 0s and 1s.");
                continue;
            }

            break;
        }

        while (binaerZahl != 0) {
            restWert = binaerZahl % 10; // 0 / 1 / 0 / 1
            binaerZahl = binaerZahl / 10; // 101 / 10 / 1 / 0
            dezimalErgebnis += stellenWert * restWert; // 0 / 2 / 2 / 10
            stellenWert *= 2; // 2 / 4 / 8 / 16
        }

        System.out.println(dezimalErgebnis); // 10
        eingabeScanner.close();
    }
}
