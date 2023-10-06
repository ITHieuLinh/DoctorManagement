package common;

import java.util.Scanner;

/**
 *
 * @author Dell
 */
public class Library {

    private final Scanner sc = new Scanner(System.in);

    public int getInt(String promt, int m, int n) {
        int a = -1;
        while (true) {
            System.out.print(promt + ": ");
            try {
                String s = sc.nextLine();
                a = Integer.parseInt(s);
                if (a >= m && a <= n) {
                    break;
                } else {
                    System.out.println("Please enter a number between " + m + " and " + n);
                }
            } catch (Exception e) {
                System.out.println("Please enter a number between " + m + " and " + n);
            }
        }
        return a;
    }

    public String inputString(String mes) {
        System.out.print(mes);
        while (true) {
            String result = sc.nextLine();
            if (result.isEmpty()) {
                System.err.println("Not empty!");
                System.out.print("Enter again: ");
            } else {
                return result;
            }
        }
    }

}
