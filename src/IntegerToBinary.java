import java.util.Scanner;

class integerToBinary {
    public static void main(String[] args) {
        int dezNum;
        int rest;
        int ans = 0;
        int hoch = 1;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a decimal number: ");
        dezNum = scanner.nextInt();  // 5 / 2 / 1
        while (dezNum > 0) {
            rest = dezNum % 2; // 1 / 0 / 1
            dezNum = dezNum / 2; // 2 / 1 / 0
            ans += hoch * rest; // 1 / 0 / 100
            hoch *= 10; // 10 / 100 / 1000
        }
        System.out.println(ans); // 1 + 0 + 100 = 101
        scanner.close();
    }
}