import java.util.Scanner;

class BinaryToInteger {
    public static void main(String[] args) {
        int binareNum;
        int restwert;
        int antwort = 0;
        int hoch = 1;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a binary number: ");
        binareNum = scanner.nextInt();
        while (binareNum != 0) {
            restwert = binareNum % 2;
            binareNum = binareNum / 10;
            antwort += hoch * restwert;
            hoch *= 2;
        }
        System.out.println(antwort);
        scanner.close();
    }
}