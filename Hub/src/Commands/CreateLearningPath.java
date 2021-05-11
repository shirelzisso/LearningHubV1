package Commands;

import Handlers.DBHandler;
import java.io.IOException;
import java.util.Scanner;

public class CreateLearningPath extends LoggedInCommand{
    public CreateLearningPath(DBHandler dbHandler, Scanner input, String username) {
        super(dbHandler, input, username);
    }

    @Override
    public Command execute() throws IOException {
        Command nextCmd;
        nextCmd = doAction();
        if(nextCmd == null) {
            System.out.println("Learning path name already exists");
            nextCmd = doAction();
        }else if(nextCmd == null) {
            System.out.println("Learning path name already exists");
            nextCmd = doAction();
        }
        return nextCmd;
    }

    private Command doAction(){
        String pathName = getStringInput("learning path name");
        success = dbHandler.getUser(username).addNewLearningPath(pathName);
        if (success) {
            System.out.println(nextOptions());
            int choice = getIntInput();
            return generateNextCommand(choice);
        }
        return null;
    }

    @Override
    protected String nextOptions() {
        return "New learning path created successfully!\n" + loggedInMenu;
    }
}
