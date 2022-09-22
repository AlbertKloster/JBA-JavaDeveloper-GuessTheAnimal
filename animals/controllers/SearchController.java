package animals.controllers;

import animals.model.Repository;
import animals.model.tree.Node;
import animals.view.Input;
import animals.view.Output;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SearchController {
    public static void run() {
        Repository repository = Repository.getInstance();

        Output.printEnterTheAnimal();
        String animal = Output.getAnimalWithoutArticle(Input.getAnimal());
        Node node = repository.getByValue(animal);
        if (node == null) {
            Output.printNoFactAbout(animal);
            return;
        }

        Output.printFactsAbout(animal);
        List<String> factList = new ArrayList<>();
        while (true) {
            Node parent = repository.getParent(node);
            if (parent == null)
                break;
            String fact;
            if (parent.getYes().getValue().equals(node.getValue()))
                fact = parent.getValue();
            else
                fact = Output.getNegatedFact(parent.getValue());
            factList.add(fact);
            node = parent;
        }

        Collections.reverse(factList);
        factList.forEach(Output::printFact);

    }

}
