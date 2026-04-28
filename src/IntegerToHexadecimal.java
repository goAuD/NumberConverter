import java.util.Scanner;

class IntegerToHexadecimal {
    public static void main(String[] args) {
        int dezimalZahl;
        int restWert;
        String hexadezimalZeichen;
        String hexadezimalErgebnis = "";
        Scanner eingabeScanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter a decimal number: ");
            String eingabe = eingabeScanner.nextLine().trim();

            try {
                dezimalZahl = Integer.parseInt(eingabe);
            } catch (NumberFormatException exception) {
                System.out.println("Invalid decimal number. Please enter a valid non-negative integer.");
                continue;
            }

            if (dezimalZahl < 0) {
                System.out.println("Negative numbers are not supported. Please enter a non-negative integer.");
                continue;
            }

            break;
        }

        if (dezimalZahl == 0) {
            System.out.println("0");
            eingabeScanner.close();
            return;
        }

        while (dezimalZahl > 0) {
            restWert = dezimalZahl % 16; // 15 / 15
            dezimalZahl = dezimalZahl / 16; // 15 / 0

            if (restWert < 10) {
                hexadezimalZeichen = "" + restWert;
            } else if (restWert == 10) {
                hexadezimalZeichen = "A";
            } else if (restWert == 11) {
                hexadezimalZeichen = "B";
            } else if (restWert == 12) {
                hexadezimalZeichen = "C";
            } else if (restWert == 13) {
                hexadezimalZeichen = "D";
            } else if (restWert == 14) {
                hexadezimalZeichen = "E";
            } else {
                hexadezimalZeichen = "F";
            }

            hexadezimalErgebnis = hexadezimalZeichen + hexadezimalErgebnis; // F / FF
        }

        System.out.println(hexadezimalErgebnis); // FF
        eingabeScanner.close();
    }
}
