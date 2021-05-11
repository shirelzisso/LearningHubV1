package Classes;

import java.util.ArrayList;

public class User {
    private final String username;
    private final String password;
    private final ArrayList<LearningPath> learningPaths;

    public User(String username, String password){
        this.username = username;
        this.password = password;
        learningPaths = new ArrayList<>();
    }


    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public ArrayList<LearningPath> getLearningPaths() {
        return learningPaths;
    }

    public boolean addToLearningPath(String learningPathName, String topic, String url) {
        for(LearningPath path : learningPaths){
            if(path.getName().equals(learningPathName)){
                path.addToLearningPath(new LearningBlock(topic, url));
                return true;
            }
        }
        return false;
    }

    public boolean addNewLearningPath(String learningPathName) {
        if(learningPaths.stream().noneMatch(path-> path.getName().equals(learningPathName))){
            return learningPaths.add(new LearningPath(learningPathName));
        }
        return false;
    }
}
