package animals.controllers;

import animals.model.Repository;
import animals.model.tree.Node;
import animals.view.Output;

import java.util.*;

public class KnowledgeTreeController {

    private static class NodeAndVisits {
        Node node;
        int visits; // 0: go to YES; 1: go to NO; 2: delete

        public NodeAndVisits(Node node) {
            this.node = node;
            visits = 0;
        }

        public Node getNode() {
            return node;
        }

        public int getVisits() {
            return visits;
        }

        public void increaseVisits() {
            visits++;
        }

    }

    public static void run() {
        Repository repository = Repository.getInstance();

        Node root = repository.getRoot();

        Deque<NodeAndVisits> nodeDeque = new ArrayDeque<>();
        nodeDeque.push(new NodeAndVisits(root));

        List<String> treeList = new ArrayList<>();
        while (!nodeDeque.isEmpty()) {
            NodeAndVisits nodeAndVisits = nodeDeque.pop();

            Node node = nodeAndVisits.getNode();
            String value = node.getValue();
            int visits = nodeAndVisits.getVisits();
            boolean isRoot = nodeDeque.size() == 0;
            boolean isLeaf = node.isLeaf();

            if (visits == 0) {
                StringBuilder builder = new StringBuilder();
                builder.append(isRoot ? " " : "  ");
                builder.append(isRoot ? "" : "|".repeat(nodeDeque.size() - 1));
                builder.append(repository.isYesNode(node) ? "├ " : "└ ");
                builder.append(isLeaf ? value : Output.generate(value));
                treeList.add(builder.toString());
                if (!node.isLeaf()) {
                    nodeAndVisits.increaseVisits();
                    nodeDeque.push(nodeAndVisits);
                    nodeDeque.push(new NodeAndVisits(node.getYes()));
                }
            } else if (visits == 1) {
                nodeAndVisits.increaseVisits();
                nodeDeque.push(nodeAndVisits);
                nodeDeque.push(new NodeAndVisits(node.getNo()));
            }
        }

        List<String> treeWithoutLooseTails = eraseLooseTreeTails(treeList);

        treeWithoutLooseTails.forEach(System.out::println);

    }

    private static List<String> eraseLooseTreeTails(List<String> treeList) {
        Set<Integer> noLeafs = new HashSet<>();
        List<String> reversedTreeWithoutLooseTails = new ArrayList<>();


        for (int lineNumber = treeList.size(); lineNumber > 0; lineNumber--) {
            int i = lineNumber - 1;
            String currentLine = treeList.get(i);
            int leafIndex = currentLine.indexOf('└');
            if (leafIndex != -1)
                noLeafs.add(leafIndex);
            StringBuilder builder = new StringBuilder();
            for (int charIndex = 0; charIndex < currentLine.length(); charIndex++) {
                char currentChar = currentLine.charAt(charIndex);
                if (currentChar == '|' && !noLeafs.contains(charIndex))
                    builder.append(' ');
                else
                    builder.append(currentChar);
            }
            reversedTreeWithoutLooseTails.add(builder.toString());
        }
        Collections.reverse(reversedTreeWithoutLooseTails);
        return reversedTreeWithoutLooseTails;
    }

}
