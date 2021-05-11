package Commands;

import Classes.LearningPath;
import Handlers.DBHandler;
import java.util.List;
import java.util.Scanner;

public abstract class LoggedInCommand extends Command{
    protected String username;

    public LoggedInCommand(DBHandler dbHandler, Scanner input, String username) {
        super(dbHandler, input);
        this.username = username;
    }


    protected Command generateNextCommand(int choice) {
        switch (choice) {
            case 1:
                return new CreateLearningPath(dbHandler, input, username);
            case 2:
                return new AddToLearningPath(dbHandler, input, username);
            case 3:
                return new FetchPaths(dbHandler, input, username);
            case 4:
                return new RateTopic(dbHandler, input, username);
            case 5:
                return new SearchPathsByTopic(dbHandler, input, username);
            case 6:
                return new Logout(dbHandler, input);
            case 7:
                return new Quit(dbHandler, input);
            default:
                return new InvalidCommand(dbHandler, input);
        }
    }

    protected void printPaths(List<LearningPath> learningPaths) {
        if(learningPaths.isEmpty()){
            System.out.println(username+" does not have any learning paths yet, why not try adding some :)?");
        } else {
            System.out.println("Printing " + username + " learning paths!");
            for (LearningPath path : learningPaths) {
                System.out.println(path);
            }
        }
    }
}
