package animals;

import java.util.function.UnaryOperator;
import java.util.ListResourceBundle;

public class App extends ListResourceBundle {

    @Override
    protected Object[][] getContents() {
        return new Object[][]{
                {"menu", """
                
                What do you want to do:

                1. Play the guessing game
                2. List of all animals
                3. Search for an animal
                4. Calculate statistics
                5. Print the Knowledge Tree
                0. Exit!"""},
                {"greetings", new String[]{
                        "Good morning!",
                        "Good afternoon!",
                        "Good evening!",
                }},
                {"iWantToLearn", "I want to learn about animals.\n" +
                        "Which animal do you like most?"},
                {"iGotIt", "I got it!"},
                {"thinkOfAnAnimal", "You think of an animal, and I guess it.\n" +
                        "Press enter when you're ready."},
                {"iGiveUp", "I give up. What animal do you have in mind?"},
                {"specifyFact", "Specify a fact that distinguishes %s from %s.\n"},
                {"sentenceShouldSatisfy", """
                The sentence should satisfy one of the following templates:
                - It can ...
                - It has ...
                - It is a/an ..."""},
                {"isTheStatementCorrectFor", "Is the statement correct for %s?\n"},
                {"iLearnedFollowingFacts", """
                        I have learned the following facts about animals:
                        - The %s %s.
                        - The %s %s.
                        I can distinguish these animals by asking the question:
                        - %s
                        """},
                {"wouldYouLikeToPlayAgain", "Would you like to play again?"},
                {"niceIveLearnedSoMuch", "Nice! I've learned so much about animals!"},
                {"welcomeToExpert", "\nWelcome to the animal expert system!"},
                {"welcomeToExpert", "\nWelcome to the animal expert system!"},
                {"farewells", new String[]{
                        "Have a nice day!",
                        "See you soon!",
                        "Bye!",
                }},
                {"hereTheAnimals", "Here are the animals I know:"},
                {"yourChoice", "Your choice:\n%d\n"},
                {"enterTheAnimal", "Enter the animal:"},
                {"noFactAbout", "No facts about the %s.\n"},
                {"factsAbout", "Facts about the %s:\n"},
                {"itFact", " - It %s\n"},
                {"theKnowledgeTreeStats", """
                        The Knowledge Tree stats

                        - root node                    %s
                        - total number of nodes        %d
                        - total number of animals      %d
                        - total number of statements   %d
                        - height of the tree           %d
                        - minimum animal's depth       %d
                        - average animal's depth       %.1f
                        """},
                {"clarifications", new String[]{
                        "I'm not sure I caught you: was it yes or no?",
                        "Funny, I still don't understand, is it yes or no?",
                        "Oh, it's too complicated for me: just tell me yes or no.",
                        "Could you please simply say yes or no?",
                        "Oh, no, don't try to confuse me: say yes or no.",
                }},
                {"animal.nameWithArticle", (UnaryOperator<String>) name -> {
                    if (name.matches("[aeiou].*")) {
                        return "an " + name;
                    } else {
                        return "a " + name;
                    }
                }},
                {"animal.nameWithoutArticle", (UnaryOperator<String>) name -> {
                    String[] words = name.split("\\s+", 2);
                    if (words.length == 2)
                        return words[1];
                    return name;
                }},
                {"isItAnimal", (UnaryOperator<String>) animal -> "Is it " + animal + "?"},
                {"yesArray", new String[]{
                        "y",
                        "yes",
                        "yeah",
                        "yep",
                        "sure",
                        "right",
                        "affirmative",
                        "correct",
                        "indeed",
                        "you bet",
                        "exactly",
                        "you said it",
                }},
                {"noArray", new String[]{
                        "n",
                        "no",
                        "no way",
                        "nah",
                        "nope",
                        "negative",
                        "i don't think so",
                        "yeah no",
                }},
                {"question", (UnaryOperator<String>) fact -> {
                    String[] words = fact.split("\\s+", 2);
                    String verb = words[0].substring(0, 1).toUpperCase() + words[0].substring(1);
                    return (verb.equals("Has") ? "Does it have " : verb + " it ") + words[1] + "?";
                }},
                {"fact", (UnaryOperator<String>) input -> {
                    if (!input.trim().toLowerCase().matches("^it\\s+(can|has|is).+"))
                        return null;
                    String[] words = input.trim().toLowerCase().split("\\s+", 2);
                    String secondPart = words[1].trim();
                    char lastCharacter = secondPart.charAt(secondPart.length() - 1);
                    if (lastCharacter == '.' || lastCharacter == '!' || lastCharacter == '?')
                        secondPart = secondPart.substring(0, secondPart.length() - 1);
                    return secondPart;
                }},
                {"negatedFact", (UnaryOperator<String>) fact -> {
                    String[] words = fact.split("\\s+", 2);
                    String secondPart = words[1];
                    if (words[0].equals("can"))
                        return "can't " + secondPart;
                    if (words[0].equals("has"))
                        return "doesn't have " + secondPart;
                    if (words[0].equals("is"))
                        return "isn't " + secondPart;
                    return fact;
                }},
                {"rootFact", (UnaryOperator<String>) input -> "It " + input}

        };
    }
}