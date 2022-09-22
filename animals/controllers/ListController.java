package animals.controllers;

import animals.model.Repository;
import animals.model.tree.Node;
import animals.view.Output;

import java.util.List;

public class ListController {
    public static void run() {
        Repository repository = Repository.getInstance();
        List<Node> leafList = repository.getLeafList();

        Output.printHereTheAnimals();
        leafList.stream().map(Node::getValue).sorted().forEach(animal -> System.out.printf(" - %s\n", animal));
    }

}
