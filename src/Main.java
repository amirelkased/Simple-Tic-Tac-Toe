import java.util.Scanner;

import static java.lang.Math.abs;


public class Main {
    static Scanner scanner = new Scanner(System.in);
    static String input = "";

    public static void main(String[] args) {
        // write your code here
        input = scanner.nextLine();
        PrintSchema();
        if (Impossible()) {
            System.out.println("Impossible");
        } else if (XWin()) {
            System.out.println("X wins");
        } else if (OWin()) {
            System.out.println("O wins");
        } else if (GameNotFinished()) {
            System.out.println("Game not finished");
        } else {
            System.out.println("Draw");
        }
    }

    public static void PrintSchema() {
        System.out.println("---------");
        for (int i = 0; i < input.length(); i += 3) {
            String str = String.format("| %c %c %c |", input.charAt(i), input.charAt(i + 1)
                    , input.charAt(i + 2));
            System.out.println(str);
        }
        System.out.println("---------");
    }

    /**
     * If it has any empty cell or any of row it not have three char this Fun
     *
     * @return true
     */
    public static boolean GameNotFinished() {
        return input.contains("_");
    }

    /**
     * X is win when is place three times in one diagonal or in a row
     *
     * @return true
     */
    public static boolean XWin() {
        return input.substring(3, 6).equals("XXX") | input.startsWith("XXX") | input.endsWith("XXX")
                | (input.charAt(0) == 'X' && input.charAt(4) == 'X' && input.charAt(8) == 'X')
                | (input.charAt(0) == 'X' && input.charAt(3) == 'X' && input.charAt(6) == 'X')
                | (input.charAt(1) == 'X' && input.charAt(4) == 'X' && input.charAt(7) == 'X')
                | (input.charAt(2) == 'X' && input.charAt(5) == 'X' && input.charAt(8) == 'X')
                | (input.charAt(2) == 'X' && input.charAt(4) == 'X' && input.charAt(6) == 'X');
    }

    /**
     * O is win when is place three times in one diagonal or in a row
     *
     * @return true
     */
    public static boolean OWin() {
        return input.substring(3, 6).equals("OOO") | input.startsWith("OOO") | input.endsWith("OOO")
                | (input.charAt(0) == 'O' && input.charAt(4) == 'O' && input.charAt(8) == 'O')
                | (input.charAt(0) == 'O' && input.charAt(3) == 'O' && input.charAt(6) == 'O')
                | (input.charAt(1) == 'O' && input.charAt(4) == 'O' && input.charAt(7) == 'O')
                | (input.charAt(2) == 'O' && input.charAt(5) == 'O' && input.charAt(8) == 'O')
                | (input.charAt(2) == 'O' && input.charAt(4) == 'O' && input.charAt(6) == 'O');
    }

    /**
     * If the diff. between Xs and Os more than 1 or two players wins at the same time
     * then is wrong game
     *
     * @return true means "Impossible"
     */
    public static boolean Impossible() {
        int Xs = 0;
        int Os = 0;
        for (int i = 0; i < input.length(); ++i) {
            if (input.charAt(i) == 'X') {
                ++Xs;
            } else if (input.charAt(i) == 'O') {
                ++Os;
            }
        }
        return abs(Xs - Os) > 1 || (OWin() && XWin());
    }
}







