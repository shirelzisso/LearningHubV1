package Commands;

import Handlers.DBHandler;
import java.io.IOException;
import java.util.Scanner;

public class AddToLearningPath extends LoggedInCommand{
    public AddToLearningPath(DBHandler dbHandler, Scanner input, String username) {
        super(dbHandler, input, username);
    }

    @Override
    public Command execute() throws IOException {
        String pathName = getStringInput("learning path name");
        String topic = getStringInput("topic");
        String url = getStringInput("url");
        success = dbHandler.getUser(username).addToLearningPath(pathName, topic, url);
        if(!success) {
            System.out.println("Adding failed, try again please");
            pathName = getStringInput("learning path name");
            topic = getStringInput("topic");
            url = getStringInput("url");
            success = dbHandler.getUser(username).addToLearningPath(pathName, topic, url);
        }
        if (success) {
            System.out.println(nextOptions());
            int choice = getIntInput();
            return generateNextCommand(choice);
        }
        return null;
    }

    @Override
    protected String nextOptions() {
        return "Learning block added successfully!\n" + loggedInMenu;
    }
}
