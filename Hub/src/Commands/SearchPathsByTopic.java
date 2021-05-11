package Commands;

import Classes.LearningPath;
import Handlers.DBHandler;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SearchPathsByTopic extends LoggedInCommand{

    public SearchPathsByTopic(DBHandler dbHandler, Scanner input, String username) {
        super(dbHandler, input, username);
    }

    @Override
    public Command execute() throws IOException {
        List<LearningPath> learningPaths = dbHandler.getUser(username).getLearningPaths();
        String topic = getStringInput("topic name");
        List<LearningPath> tmp = new ArrayList<>();
        for(LearningPath path : learningPaths){
            if(path.containsTopic(topic)){
                tmp.add(path);
            }
        }
        printPaths(tmp);
        System.out.println(nextOptions());
        int choice = getIntInput();
        return generateNextCommand(choice);
    }

    @Override
    protected String nextOptions() {
        return loggedInMenu;
    }
}
