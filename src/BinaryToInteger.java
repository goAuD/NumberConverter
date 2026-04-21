import java.util.Scanner;

class binaryToInteger {
    public static void main(String[] args) {

        Scanner a = new Scanner(System.in);

        int binNum;
        int rest;
        int ans = 0;
        int hoch = 1;

        System.out.print("Enter a binary number: ");
        binNum = a.nextInt();  // 5 / 2 / 1

        while (binNum != 0) {
            rest = binNum % 2; // 1 / 0 / 1
            binNum = binNum / 10; // 2 / 1 / 0

            ans += hoch * rest; // 1 / 0 / 100
            hoch *= 2; // 10 / 100 / 1000
        }
        System.out.println(ans); // 1 + 0 + 100 = 101
    }
}