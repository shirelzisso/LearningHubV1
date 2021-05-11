package Commands;

import Classes.LearningPath;
import Handlers.DBHandler;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class FetchPaths extends LoggedInCommand{
    public FetchPaths(DBHandler dbHandler, Scanner input, String username) {
        super(dbHandler, input, username);
    }

    @Override
    public Command execute() throws IOException {
        List<LearningPath> learningPaths = dbHandler.getUser(username).getLearningPaths();
        printPaths(learningPaths);
        System.out.println(nextOptions());
        int choice = getIntInput();
        return generateNextCommand(choice);
    }

    @Override
    protected String nextOptions() {
        return loggedInMenu;
    }
}
