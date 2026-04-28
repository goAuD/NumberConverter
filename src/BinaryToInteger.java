import java.util.Scanner;

class BinaryToInteger {
    public static void main(String[] args) {
        int binarNum;
        int restwert;
        int antwort = 0;
        int hoch = 1;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a binary number: ");
        binarNum = scanner.nextInt();
        while (binarNum != 0) {
            restwert = binarNum % 2;
            binarNum = binarNum / 10;
            antwort += hoch * restwert;
            hoch *= 2;
        }
        System.out.println(antwort);
        scanner.close();
    }
}