import java.util.Scanner;

class binaryToInteger {
    public static void main(String[] args) {

        int binNum;
        int rest;
        int ans = 0;
        int hoch = 1;

        Scanner a = new Scanner(System.in);
        System.out.print("Enter a binary number: ");

        binNum = a.nextInt();

        while (binNum != 0) {
            rest = binNum % 2;
            binNum = binNum / 10;

            ans += hoch * rest;
            hoch *= 2;
        }
        System.out.println(ans);
    }
}