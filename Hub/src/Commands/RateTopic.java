package Commands;

import Classes.LearningPath;
import Handlers.DBHandler;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class RateTopic extends LoggedInCommand{
    public RateTopic(DBHandler dbHandler, Scanner input, String username) {
        super(dbHandler, input, username);
        this.username = username;
    }

    @Override
    public Command execute() throws IOException {
        String topic = getStringInput("topic name");
        int rating = getIntInput("rating <1-5>");
        List<LearningPath> learningPaths = dbHandler.getUser(username).getLearningPaths();
        for(LearningPath path : learningPaths){
            if(path.containsTopic(topic)){
                path.getBlockByTopic(topic).rate(rating);
            }
        }
        System.out.println(nextOptions());
        int choice = getIntInput();
        return generateNextCommand(choice);
    }

    @Override
    protected String nextOptions() {
        return "Topic rated!" + loggedInMenu;
    }

}
