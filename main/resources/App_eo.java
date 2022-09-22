package animals;

import java.util.function.UnaryOperator;
import java.util.ListResourceBundle;

public class App_eo extends ListResourceBundle {

    @Override
    protected Object[][] getContents() {
        return new Object[][]{
                {"menu", """
                
                Kion vi volas fari:

                1. Ludi la divenludon
                2. Listo de ĉiuj bestoj
                3. Serĉi beston
                4. Kalkuli statistikon
                5. Presu la Scion-Arbon
                0. Eliri!"""},
                {"greetings", new String[]{
                        "Bonan matenon!",
                        "Bonan posttagmezon!",
                        "Bonan vesperon!"
                }},
                {"iWantToLearn", "Mi volas lerni pri bestoj.\n" +
                        "Kiun beston vi plej ŝatas?"},
                {"iGotIt", "Mi gajnis!"},
                {"thinkOfAnAnimal", "Vi pensu pri besto, kaj mi divenos ĝin.\n" +
                        "Premu enen kiam vi pretas."},
                {"iGiveUp", "Mi rezignas. Kiun beston vi havas en la kapo?"},
                {"specifyFact", "Indiku fakton, kiu distingas %s de %s.\n"},
                {"sentenceShouldSatisfy", """
                La frazo devas kontentigi unu el la jenaj ŝablonoj:
                - Ĝi povas ...
                - Ĝi havas ...
                - Ĝi estas ..."""},
                {"isTheStatementCorrectFor", "Ĉu la aserto ĝustas por la %s?\n"},
                {"iLearnedFollowingFacts", """
                        Mi lernis la jenajn faktojn pri bestoj:
                        - La %s %s.
                        - La %s %s.
                        Mi povas distingi ĉi tiujn bestojn farante la demandon:
                        - %s
                        """},
                {"wouldYouLikeToPlayAgain", "Ĉu vi ŝatus ludi denove?"},
                {"niceIveLearnedSoMuch", "Bela! Mi multe lernis pri bestoj!"},
                {"welcomeToExpert", "\nBonvenon al la sperta sistemo de la besto!"},
                {"farewells", new String[]{
                        "Ĝis baldaŭ!",
                        "Ĝis revido!"
                }},
                {"hereTheAnimals", "Jen la bestoj, kiujn mi konas:"},
                {"yourChoice", "Via elekto:\n%d\n"},
                {"enterTheAnimal", "Enigu la beston:"},
                {"noFactAbout", "Neniuj faktoj pri la %s.\n"},
                {"factsAbout", "Faktoj pri la %s:\n"},
                {"itFact", " - Ĝi %s\n"},
                {"theKnowledgeTreeStats", """
                        La statistiko

                        - radika nodo            %s
                        - nombro de nodoj        %d
                        - nombro de bestoj       %d
                        - nombro de deklaroj     %d
                        - alteco de la arbo      %d
                        - minimuma profundo      %d
                        - averaĝa profundo       %.1f
                        """},
                {"clarifications", new String[]{
                        "Mi ne certas, ke mi kaptis vin: ĉu jes aŭ ne?",
                        "Amuze, mi ankoraŭ ne komprenas, ĉu jes aŭ ne?",
                        "Ho, ĝi estas tro komplika por mi: nur diru al mi jes aŭ ne.",
                        "Ĉu vi povus simple diri jes aŭ ne?",
                        "Ho, ne, ne provu konfuzi min: diru jes aŭ ne.",
                }},
                {"animal.nameWithArticle", (UnaryOperator<String>) name -> name},
                {"animal.nameWithoutArticle", (UnaryOperator<String>) name -> name},
                {"isItAnimal", (UnaryOperator<String>) animal -> "IĈu ĝi estas " + animal + "?"},
                {"yesArray", new String[]{
                        "j",
                        "jes",
                        "certe",
                        "ĝuste",
                        "jesa",
                        "ĝusta",
                        "fakte",
                        "vi vetas",
                        "ĝuste",
                        "vi diris ĝin"
                }},
                {"noArray", new String[]{
                        "n",
                        "ne",
                        "neniel",
                        "negativa",
                        "mi ne pensas tiel",
                        "jes ne"
                }},
                {"question", (UnaryOperator<String>) fact -> "Ĉu ĝi " + fact + "?"},
                {"fact", (UnaryOperator<String>) input -> {
//                    if (!input.trim().toLowerCase().matches("^ĝi\\s+(povas|havas|estas).+"))
                    if (!input.trim().toLowerCase().matches("^ĝi.*"))
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
                    if (words[0].equals("povas"))
                        return "ne povas " + secondPart;
                    if (words[0].equals("havas"))
                        return "ne havas " + secondPart;
                    if (words[0].equals("estas"))
                        return "ne estas " + secondPart;
                    return fact;
                }},
                {"rootFact", (UnaryOperator<String>) input -> "Ĝi " + input}

        };
    }
}