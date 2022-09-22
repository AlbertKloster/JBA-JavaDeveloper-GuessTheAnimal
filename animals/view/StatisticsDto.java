package animals.view;

public class StatisticsDto {
    private String rootNode;
    private int totalNumberOfNodes;
    private int totalNumberOfAnimals;
    private int totalNumberOfStatements;
    private int heightOfTheTree;
    private int minimumAnimalDepth;
    private double averageAnimalDepth;

    public String getRootNode() {
        return rootNode;
    }

    public void setRootNode(String rootNode) {
        this.rootNode = rootNode;
    }

    public int getTotalNumberOfNodes() {
        return totalNumberOfNodes;
    }

    public void setTotalNumberOfNodes(int totalNumberOfNodes) {
        this.totalNumberOfNodes = totalNumberOfNodes;
    }

    public int getTotalNumberOfAnimals() {
        return totalNumberOfAnimals;
    }

    public void setTotalNumberOfAnimals(int totalNumberOfAnimals) {
        this.totalNumberOfAnimals = totalNumberOfAnimals;
    }

    public int getTotalNumberOfStatements() {
        return totalNumberOfStatements;
    }

    public void setTotalNumberOfStatements(int totalNumberOfStatements) {
        this.totalNumberOfStatements = totalNumberOfStatements;
    }

    public int getHeightOfTheTree() {
        return heightOfTheTree;
    }

    public void setHeightOfTheTree(int heightOfTheTree) {
        this.heightOfTheTree = heightOfTheTree;
    }

    public int getMinimumAnimalDepth() {
        return minimumAnimalDepth;
    }

    public void setMinimumAnimalDepth(int minimumAnimalDepth) {
        this.minimumAnimalDepth = minimumAnimalDepth;
    }

    public double getAverageAnimalDepth() {
        return averageAnimalDepth;
    }

    public void setAverageAnimalDepth(double averageAnimalDepth) {
        this.averageAnimalDepth = averageAnimalDepth;
    }
}
