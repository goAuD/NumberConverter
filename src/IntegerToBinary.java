import java.util.Scanner;

class IntegerToBinary {
    public static void main(String[] args) {
        int dezimalNum;
        int restwert;
        int antwort = 0;
        int hoch = 1;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a decimal number: ");
        dezimalNum = scanner.nextInt();  // 5 / 2 / 1
        while (dezimalNum > 0) {
            restwert = dezimalNum % 2; // 1 / 0 / 1
            dezimalNum = dezimalNum / 2; // 2 / 1 / 0
            antwort += hoch * restwert; // 1 / 0 / 100
            hoch *= 10; // 10 / 100 / 1000
        }
        System.out.println(antwort); // 1 + 0 + 100 = 101
        scanner.close();
    }
}