package animals.controllers;

import animals.model.Repository;
import animals.model.tree.Node;
import animals.view.Input;
import animals.view.Output;

public class GameController {

    public static void run() {
        Repository repository = Repository.getInstance();
        Node currentNode = repository.getRoot();

        Output.printThinkOfAnAnimal();
        Input.waitForEnter();

        boolean quit = false;
        while(!quit) {
            if (currentNode.isLeaf()) {

                String animal = currentNode.getValue();
                Output.printIsItAnimal(animal);

                if (Input.getYes()) {
                    Output.printIGotIt();
                    Output.printWouldYouLikeToPlayAgain();
                    if (Input.getNo())
                        quit = true;
                    else {
                        currentNode = repository.getBinaryTree().getRoot();
                        Output.printThinkOfAnAnimal();
                        Input.waitForEnter();
                    }
                } else {
                    Output.printIGiveUp();
                    String thoughtAnimal = Input.getAnimal();
                    Output.printSpecifyFact(currentNode.getValue(), thoughtAnimal);
                    String fact = Input.getFact();

                    Output.printIsTheStatementCorrectFor(thoughtAnimal);
                    Node node;
                    if (Input.getYes()) {
                        node = new Node(fact, new Node(thoughtAnimal), new Node(animal));
                        repository.getBinaryTree().updateNode(currentNode, node);
                    } else {
                        node = new Node(fact, new Node(animal), new Node(thoughtAnimal));
                        repository.getBinaryTree().updateNode(currentNode, node);
                    }

                    Output.printILearnedFollowingFacts(node);
                    Output.printNiceIveLearnedSoMuch();
                    Output.printWouldYouLikeToPlayAgain();

                    if (Input.getNo())
                        quit = true;
                    else {
                        currentNode = repository.getBinaryTree().getRoot();
                        Output.printThinkOfAnAnimal();
                        Input.waitForEnter();
                    }
                }

            } else {
                Output.printQuestionAboutFact(currentNode);
                if (Input.getYes())
                    currentNode = repository.getBinaryTree().getNext(currentNode, true);
                else
                    currentNode = repository.getBinaryTree().getNext(currentNode, false);
            }

        }
    }
}
