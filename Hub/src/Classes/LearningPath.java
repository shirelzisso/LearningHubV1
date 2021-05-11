package Classes;

import java.util.ArrayList;

public class LearningPath {
    private final String name;
    private final ArrayList<LearningBlock> learningPath;

    public LearningPath(String name){
        this.name = name;
        learningPath = new ArrayList<>();
    }

    public void addToLearningPath(LearningBlock block){
        learningPath.add(block);
    }

    public void addToLearningPath(int index, LearningBlock block){
        if (isValidIndex(index)) {
            learningPath.add(index, block);
        }
    }

    private boolean isValidIndex(int index) {
        return index >= 0 && index < learningPath.size();
    }

    public LearningBlock getBlockByTopic(String topic){
        for(LearningBlock block : learningPath){
            if(topic.equals(block.getTopic())){
                return block;
            }
        }
        return null;
    }

    public boolean containsTopic(String topic){
        LearningBlock tempBlock = new LearningBlock(topic, "");
        return learningPath.stream().anyMatch(block->block.equalByTopic(tempBlock));
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder(getName()).append(": ");
        for(LearningBlock block : learningPath){
            sb.append("<").append(block.getTopic()).append(", ")
                .append(block.getUrl()).append(", rating=")
                .append(block.getRating())
                .append(">, ");
        }
        if (learningPath.isEmpty()){
            sb.append("path is empty, add some blocks!");
        }
        return sb.toString().substring(0, sb.length() - 2);
    }
}
