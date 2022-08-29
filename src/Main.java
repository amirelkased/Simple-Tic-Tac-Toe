import java.util.Scanner;

import static java.lang.Math.abs;


public class Main {
    static Scanner scanner = new Scanner(System.in);
    static String input = "         ";

    static int player = 0;

    public static void main(String[] args) {
        // write your code here
        PrintSchema();

        // Play
        while (true) {
            if (FirstMove()) {
                PrintSchema();
                if (XWin()) {
                    System.out.println("X wins");
                    break;
                }
                if (OWin()) {
                    System.out.println("O wins");
                    break;
                }
                if (player == 9) {
                    System.out.println("Draw");
                    break;
                }
            }
        }
    }

    public static void Formatted() {
        input = input.replaceAll("_", " ");
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
        return input.equals("_");
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

    public static boolean FirstMove() {
        int x;
        int y;
        try {
            x = scanner.nextInt();
            y = scanner.nextInt();
        } catch (Exception ex) {
            System.out.println("You should enter numbers!");
            return false;
        }
        if ((x >= 1 && x <= 3) && (y >= 1 && y <= 3)) {
            if (x == 1) {
                if (input.charAt(y - x) != ' ') {
                    System.out.println("This cell is occupied! Choose another one!");
                    return false;
                } else {
                    Update(1, x, y);
                }
            } else if (x == 2) {
                if (input.charAt(x + y) != ' ') {
                    System.out.println("This cell is occupied! Choose another one!");
                    return false;
                } else {
                    Update(2, x, y);
                }
            } else {
                if (input.charAt(x + y + 2) != ' ') {
                    System.out.println("This cell is occupied! Choose another one!");
                    return false;
                } else {
                    Update(3, x, y);
                }
            }
        } else {
            System.out.println("Coordinates should be from 1 to 3!");
            return false;
        }
        return true;
    }

    public static void Update(int cases, int x, int y) {
        StringBuilder str = new StringBuilder(input);
        switch (cases) {
            case 1 -> str.setCharAt((y - x), (player % 2 == 0) ? 'X' : 'O');
            case 2 -> str.setCharAt((x + y), (player % 2 == 0) ? 'X' : 'O');
            case 3 -> str.setCharAt((x + y + 2), (player % 2 == 0) ? 'X' : 'O');
        }
        input = String.valueOf(str);
        ++player;
    }
}








