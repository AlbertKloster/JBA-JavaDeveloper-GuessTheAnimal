package animals.controllers;

import animals.model.Repository;
import animals.view.Output;
import animals.view.StatisticsDto;

public class StatisticsController {
    public static void run() {
        Repository repository = Repository.getInstance();
        StatisticsDto statisticsDto = new StatisticsDto();
        String rootNode = Output.getRootFact(repository.getRoot().getValue());
        int totalNumberOfAnimals = repository.getLeafList().size();
        int totalNumberOfStatements = repository.getFullNodeList().size();
        int heightOfTheTree = repository.getBinaryTreeHeight(repository.getRoot());
        int minimumAnimalDepth = repository.getMinLeafDepth();
        double averageAnimalDept = repository.getAverageLeafDepth();

        statisticsDto.setRootNode(rootNode);
        statisticsDto.setTotalNumberOfNodes(totalNumberOfAnimals + totalNumberOfStatements);
        statisticsDto.setTotalNumberOfAnimals(totalNumberOfAnimals);
        statisticsDto.setTotalNumberOfStatements(totalNumberOfStatements);
        statisticsDto.setHeightOfTheTree(heightOfTheTree);
        statisticsDto.setMinimumAnimalDepth(minimumAnimalDepth);
        statisticsDto.setAverageAnimalDepth(averageAnimalDept);

        Output.printTheKnowledgeTreeStats(statisticsDto);

    }
}
