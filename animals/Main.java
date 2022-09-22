package animals;

import animals.controllers.*;
import animals.model.Repository;
import animals.model.tree.Node;
import animals.view.Input;
import animals.view.Output;

import java.util.Locale;

public class Main {

    public static void main(String[] args) {

//        Locale.setDefault(new Locale("eo"));

        String language = Locale.getDefault().getLanguage();

        System.out.println(language);

        String type = getType(args);
        String fileName = (language.equals("en") ? "animals." : "animals_" + language + ".") + type;
        Repository repository = Repository.getInstance();
        repository.setFileName(fileName);

        Output.printGreeting();

        Node currentNode = repository.getRoot();
        if (currentNode == null) {
            Output.printIWantToLearn();
            currentNode = new Node(Input.getAnimal());
        }
        repository.setRoot(currentNode);

        Output.printWelcomeToExpert();

        boolean quit = false;
        while (!quit) {
            Output.printMenu();

            int menuItem = Input.getMenuItem();
            switch (menuItem) {
                case 0: {
                    repository.save();
                    Output.printFarewell();
                    quit = true;
                    break;
                }
                case 1: {
                    GameController.run();
                    break;
                }
                case 2: {
                    Output.printYourChoice(menuItem);
                    ListController.run();
                    break;
                }
                case 3: {
                    Output.printYourChoice(menuItem);
                    SearchController.run();
                    break;
                }
                case 4: {
                    StatisticsController.run();
                    break;
                }
                case 5: {
                    KnowledgeTreeController.run();
                    break;
                }
            }
        }
    }

    public static String getType(String[] args) {
        if (args.length > 1) {
            if (args[0].equals("-type")) {
                switch (args[1]) {
                    case "xml": return  "xml";
                    case "yaml": return "yaml";
                }
            }
        }
        return "json";
    }

}