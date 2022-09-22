package animals.model;

import animals.model.tree.BinaryTree;
import animals.model.tree.Node;
import animals.view.Output;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Repository {

    private volatile static Repository instance;

    private String fileName;
    private ObjectMapper objectMapper;

    private final BinaryTree binaryTree;

    private Repository() {
        binaryTree = new BinaryTree();
    }

    public static Repository getInstance() {
        if (instance == null)
            synchronized (Repository.class) {
            if (instance == null)
                instance = new Repository();
            }
        return instance;
    }

    public Node getRoot() {

        try {
            return objectMapper.readValue(new File(fileName), Node.class);
        } catch (IOException ignored) {
            return binaryTree.getRoot();
        }
    }

    public void save() {
        try {
            objectMapper
                    .writerWithDefaultPrettyPrinter()
                    .writeValue(new File(fileName), binaryTree.getRoot());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
        String type = fileName.split("\\.")[1];
        objectMapper = ObjectMapperProvider.getObjectMapper(type);
    }

    public void setRoot(Node node) {
        binaryTree.setRoot(node);
    }

    public BinaryTree getBinaryTree() {
        return binaryTree;
    }

    public List<Node> getLeafList() {
        List<Node> leafList = new ArrayList<>();
        fillLeafList(leafList, getRoot());
        return leafList;
    }

    public List<Node> getFullNodeList() {
        List<Node> fullNodeList = new ArrayList<>();
        fillFullNodeList(fullNodeList, getRoot());
        return fullNodeList;
    }

    private void fillFullNodeList(List<Node> nodeList, Node node) {
        if (node == null)
            return;
        fillFullNodeList(nodeList, node.getYes());
        if (node.getYes() != null && node.getNo() != null)
            nodeList.add(node);
        fillFullNodeList(nodeList, node.getNo());
    }

    private void fillLeafList(List<Node> leafList, Node node) {

        if (node == null)
            return;

        if (node.getYes() == null && node.getNo() == null) {
            leafList.add(node);
            return;
        }

        if (node.getYes() != null)
            fillLeafList(leafList, node.getYes());

        if (node.getNo() != null)
            fillLeafList(leafList, node.getNo());
    }

    public Node getByValue(String value) {
        List<Node> nodeList = getLeafList();
        nodeList.addAll(getFullNodeList());
        return nodeList.stream().filter(node ->
                Output.getAnimalWithoutArticle(node.getValue())
                        .equals(Output.getAnimalWithoutArticle(value.toLowerCase().trim()))).findAny().orElse(null);
    }

    public Node getParent(Node node) {
        List<Node> nodeList = getFullNodeList();
        for (Node n : nodeList) {
            if (!n.isLeaf())
                if (n.getNo().getValue().equals(node.getValue()) || n.getYes().getValue().equals(node.getValue()))
                    return n;
        }
        return null;
    }

    public int getBinaryTreeHeight(Node node) {
        if (node == null)
            return -1;
        else {
            int yesDepth = getBinaryTreeHeight(node.getYes());
            int noDepth = getBinaryTreeHeight(node.getNo());

            if (yesDepth > noDepth)
                return (yesDepth + 1);
            else
                return (noDepth + 1);
        }
    }

    public int getMinLeafDepth() {
        List<Node> leafList = getLeafList();
        int minLeafDepth = Integer.MAX_VALUE;
        for (Node leaf : leafList) {
            int leafDepth = getDepthForNode(leaf);
            if (leafDepth < minLeafDepth)
                minLeafDepth = leafDepth;
        }
        return minLeafDepth;
    }

    public int getDepthForNode(Node node) {
        Node searchedNode = getByValue(node.getValue());
        int depth = -1;
        while (searchedNode != null) {
            depth++;
            searchedNode = getParent(searchedNode);
        }
        return depth;
    }

    public double getAverageLeafDepth() {
        List<Node> leafList = getLeafList();
        int totalDepth = 0;
        for (Node leaf : leafList) {
            int leafDepth = getDepthForNode(leaf);
            totalDepth += leafDepth;
        }
        return 1.0 * totalDepth / leafList.size();
    }

    public boolean isYesNode(Node node) {
        Node parent = getParent(node);
        if (parent == null)
            return false;
        Node yesNode = parent.getYes();
        return node.getValue().equals(yesNode.getValue());
    }


}
