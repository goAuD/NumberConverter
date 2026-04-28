import java.util.Scanner;

class PrefixToClients {
    public static void main(String[] args) {
        int prefixLaenge;
        int anzahlHostBits;
        long anzahlAdressen = 1;
        long anzahlClients;
        Scanner eingabeScanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter a network prefix, for example /28 or 28: ");
            String eingabe = eingabeScanner.nextLine().trim();

            if (eingabe.startsWith("/")) {
                eingabe = eingabe.substring(1);
            }

            try {
                prefixLaenge = Integer.parseInt(eingabe);
            } catch (NumberFormatException exception) {
                System.out.println("Invalid prefix. Please enter a number from 0 to 32.");
                continue;
            }

            if (prefixLaenge < 0 || prefixLaenge > 32) {
                System.out.println("Invalid prefix. Please enter a number from 0 to 32.");
                continue;
            }

            break;
        }

        anzahlHostBits = 32 - prefixLaenge;

        for (int zaehler = 0; zaehler < anzahlHostBits; zaehler++) {
            anzahlAdressen *= 2; // 2 / 4 / 8 / 16
        }

        anzahlClients = anzahlAdressen - 2;

        if (anzahlClients < 0) {
            anzahlClients = 0;
        }

        System.out.println("Prefix: /" + prefixLaenge);
        System.out.println("Host bits: " + anzahlHostBits);
        System.out.println("Total addresses: " + anzahlAdressen);
        System.out.println("Usable clients: " + anzahlClients);

        eingabeScanner.close();
    }
}
