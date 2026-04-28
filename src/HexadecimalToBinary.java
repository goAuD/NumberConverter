import java.util.Scanner;

class HexadecimalToBinary {
    public static void main(String[] args) {
        String hexadezimalZahl;
        char hexadezimalZeichen;
        String binaerGruppe;
        String binaerErgebnis = "";
        int index = 0;
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

            hexadezimalZahl = eingabe;
            break;
        }

        while (index < hexadezimalZahl.length()) {
            hexadezimalZeichen = hexadezimalZahl.charAt(index); // F / F

            binaerGruppe = switch (hexadezimalZeichen) {
                case '0' -> "0000";
                case '1' -> "0001";
                case '2' -> "0010";
                case '3' -> "0011";
                case '4' -> "0100";
                case '5' -> "0101";
                case '6' -> "0110";
                case '7' -> "0111";
                case '8' -> "1000";
                case '9' -> "1001";
                case 'A' -> "1010";
                case 'B' -> "1011";
                case 'C' -> "1100";
                case 'D' -> "1101";
                case 'E' -> "1110";
                default -> "1111";
            };

            binaerErgebnis = binaerErgebnis + binaerGruppe; // 1111 / 11111111
            index++;
        }

        while (binaerErgebnis.length() > 1 && binaerErgebnis.startsWith("0")) {
            binaerErgebnis = binaerErgebnis.substring(1);
        }

        System.out.println(binaerErgebnis); // 11111111
        eingabeScanner.close();
    }
}
