package animals.view;

import animals.model.tree.Node;

import java.time.LocalTime;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.function.UnaryOperator;

public class Output {

    private static final ResourceBundle appResource = ResourceBundle.getBundle("animals.App");
    private static final String menu = appResource.getString("menu");
    private static final String[] greetings = appResource.getStringArray("greetings");
    private static final String iWantToLearn = appResource.getString("iWantToLearn");
    private static final UnaryOperator isItAnimal = (UnaryOperator) appResource.getObject("isItAnimal");
    private static final String iGotIt = appResource.getString("iGotIt");
    private static final String thinkOfAnAnimal = appResource.getString("thinkOfAnAnimal");
    private static final String iGiveUp = appResource.getString("iGiveUp");
    private static final String specifyFact = appResource.getString("specifyFact");
    private static final String sentenceShouldSatisfy = appResource.getString("sentenceShouldSatisfy");
    private static final String isTheStatementCorrectFor = appResource.getString("isTheStatementCorrectFor");
    private static final String iLearnedFollowingFacts = appResource.getString("iLearnedFollowingFacts");
    private static final String wouldYouLikeToPlayAgain = appResource.getString("wouldYouLikeToPlayAgain");
    private static final String niceIveLearnedSoMuch = appResource.getString("niceIveLearnedSoMuch");
    private static final String theKnowledgeTreeStats = appResource.getString("theKnowledgeTreeStats");
    private static final String welcomeToExpert = appResource.getString("welcomeToExpert");
    private static final String[] farewells = appResource.getStringArray("farewells");
    private static final String hereTheAnimals = appResource.getString("hereTheAnimals");
    private static final String yourChoice = appResource.getString("yourChoice");
    private static final String enterTheAnimal = appResource.getString("enterTheAnimal");
    private static final String noFactAbout = appResource.getString("noFactAbout");
    private static final String factsAbout = appResource.getString("factsAbout");
    private static final String itFact = appResource.getString("itFact");
    private static final String[] clarifications = appResource.getStringArray("clarifications");
    private static final UnaryOperator animalWithArticle = (UnaryOperator) appResource.getObject("animal.nameWithArticle");
    private static final UnaryOperator animalWithoutArticle = (UnaryOperator) appResource.getObject("animal.nameWithoutArticle");
    private static final UnaryOperator fact = (UnaryOperator) appResource.getObject("fact");
    private static final UnaryOperator negatedFact = (UnaryOperator) appResource.getObject("negatedFact");
    private static final UnaryOperator rootFact = (UnaryOperator) appResource.getObject("rootFact");
    private static final UnaryOperator question = (UnaryOperator) appResource.getObject("question");
    private static final String[] yesArray = appResource.getStringArray("yesArray");
    private static final String[] noArray = appResource.getStringArray("noArray");



    public static void printGreeting() {
        LocalTime time = LocalTime.now();
        LocalTime morning = LocalTime.MIDNIGHT.plusHours(5);
        LocalTime noon = LocalTime.NOON;
        LocalTime evening = LocalTime.NOON.plusHours(6);

        if (time.isAfter(morning) && time.isBefore(noon))
            System.out.println(greetings[0]);
        else if (time.isAfter(noon) && time.isBefore(evening))
            System.out.println(greetings[1]);
        else
            System.out.println(greetings[2]);
    }

    public static void printIWantToLearn() {
        System.out.println(iWantToLearn);
    }

    public static void printIsItAnimal(String animal) {
        System.out.println((String) isItAnimal.apply(animal));
    }

    public static void printIGotIt() {
        System.out.println(iGotIt);
    }

    public static void printThinkOfAnAnimal() {
        System.out.println(thinkOfAnAnimal);
    }

    public static void printIGiveUp() {
        System.out.println(iGiveUp);
    }

    public static void printSpecifyFact(String askedAnimal, String thoughtAnimal) {
        System.out.printf(specifyFact, askedAnimal, thoughtAnimal);
    }

    public static void printSentenceShouldSatisfy() {
        System.out.println(sentenceShouldSatisfy);
    }

    public static void printIsTheStatementCorrectFor(String thoughtAnimal) {
        System.out.printf(isTheStatementCorrectFor, thoughtAnimal);
    }

    public static void printILearnedFollowingFacts(Node node) {
        System.out.printf(iLearnedFollowingFacts, animalWithoutArticle.apply(node.getYes().getValue()), node.getValue(),
                animalWithoutArticle.apply(node.getNo().getValue()), Input.getNegatedFact(node.getValue()),
                Output.generate(node.getValue())
        );

    }

    public static void printWouldYouLikeToPlayAgain() {
        System.out.println(wouldYouLikeToPlayAgain);
    }

    public static void printNiceIveLearnedSoMuch() {
        System.out.println(niceIveLearnedSoMuch);
    }

    public static void printQuestionAboutFact(Node currentNode) {
        System.out.println(Output.generate(currentNode.getValue()));
    }

    public static void printWelcomeToExpert() {
        System.out.println(welcomeToExpert);
    }

    public static void printMenu() {
        System.out.println(menu);
    }

    public static void printFarewell() {
        Random random = new Random();
        System.out.println(farewells[random.nextInt(farewells.length)]);
    }

    public static void printHereTheAnimals() {
        System.out.println(hereTheAnimals);
    }

    public static void printYourChoice(int menuItem) {
        System.out.printf(yourChoice, menuItem);
    }

    public static void printEnterTheAnimal() {
        System.out.println(enterTheAnimal);
    }

    public static void printNoFactAbout(String animal) {
        System.out.printf(noFactAbout, animal);
    }

    public static void printFactsAbout(String animal) {
        System.out.printf(factsAbout, animal);
    }

    public static void printFact(String fact) {
        System.out.printf(itFact, fact);
    }

    public static void printTheKnowledgeTreeStats(StatisticsDto statisticsDto) {
        System.out.printf(theKnowledgeTreeStats,
                statisticsDto.getRootNode(),
                statisticsDto.getTotalNumberOfNodes(),
                statisticsDto.getTotalNumberOfAnimals(),
                statisticsDto.getTotalNumberOfStatements(),
                statisticsDto.getHeightOfTheTree(),
                statisticsDto.getMinimumAnimalDepth(),
                statisticsDto.getAverageAnimalDepth()
        );

    }

    public static void printClarification() {
        Random random = new Random();
        System.out.println(clarifications[random.nextInt(clarifications.length)]);
    }

    public static String getAnimalWithArticle(String input) {
        return (String) animalWithArticle.apply(getAnimalWithoutArticle(input));
    }

    public static String getAnimalWithoutArticle(String input) {
        String[] words = input.split("\\s+", 2);
        return words.length == 2 ? words[1] : input;
    }

    public static String getFact(String input) {
        return (String) fact.apply(input);
    }

    public static String getNegatedFact(String fact) {
        return (String) negatedFact.apply(fact);
    }

    public static String getRootFact(String input) {
        return (String) rootFact.apply(input);
    }

    public static String generate(String fact) {
        return (String) question.apply(fact);
    }

    public static boolean isYes(String answer) {
        for (String yes : yesArray) {
            if (answer.trim().toLowerCase().matches(yes)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isNo(String answer) {
        for (String no : noArray) {
            if (answer.trim().toLowerCase().matches(no)) {
                return true;
            }
        }
        return false;
    }

}
