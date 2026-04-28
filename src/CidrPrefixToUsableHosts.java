import java.util.Scanner;

class CidrPrefixToUsableHosts {
    public static void main(String[] args) {
        int prefixLaenge;
        int anzahlHostBits;
        long anzahlAdressen = 1;
        long anzahlHosts;
        Scanner eingabeScanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter a CIDR prefix, for example /28 or 28: ");
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

        anzahlHosts = anzahlAdressen - 2;

        if (anzahlHosts < 0) {
            anzahlHosts = 0;
        }

        System.out.println("Prefix: /" + prefixLaenge);
        System.out.println("Host bits: " + anzahlHostBits);
        System.out.println("Total addresses: " + anzahlAdressen);
        System.out.println("Usable hosts: " + anzahlHosts);

        eingabeScanner.close();
    }
}
