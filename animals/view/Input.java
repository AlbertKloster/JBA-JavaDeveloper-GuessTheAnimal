package animals.view;

import java.util.Locale;
import java.util.Scanner;

public class Input {
    private static final Scanner SC = new Scanner(System.in);

    public static String getAnimal() {
        String input = SC.nextLine();
        return Output.getAnimalWithArticle(input);
    }

    public static void waitForEnter() {
        SC.nextLine();
    }

    public static boolean getYes() {
        while (true) {
            String response = SC.nextLine().toLowerCase(Locale.ROOT).trim();
            if (Output.isYes(response))
                return true;
            if (Output.isNo(response))
                return false;
            Output.printClarification();
        }

    }

    public static boolean getNo() {
        return !getYes();
    }

    public static String getFact() {
        while (true) {
            String fact = Output.getFact(SC.nextLine());
            if (fact != null)
                return fact;
            Output.printSentenceShouldSatisfy();
        }
    }

    public static String getNegatedFact(String fact) {
        return Output.getNegatedFact(fact);
    }

    public static int getMenuItem() {
        while (true) {
            String input = SC.nextLine();
            if (input.matches("[0-5]"))
                return Integer.parseInt(input);
        }
    }
}
