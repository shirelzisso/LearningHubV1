package Commands;

import Classes.User;
import Handlers.DBHandler;
import java.util.Scanner;

public class Login extends Command {

    private String username;

    public Login(DBHandler dbHandler, Scanner input) {
        super(dbHandler, input);
    }

    @Override
    public Command execute() {
        success = doLogin();
        if (success) {
            return getNextCommand();
        }
        System.out.println("Invalid credentials, please try again");
        success = doLogin();
        if (success) {
            return getNextCommand();
        }
        System.out.println("Invalid credentials, returning to main menu");
        return new Menu(dbHandler, input);
    }

    private Command getNextCommand() {
        System.out.println(nextOptions());
        int choice = getIntInput();
        return generateNextCommand(choice);
    }

    private boolean doLogin() {
        username = getStringInput("username");
        String password = getStringInput("password");
        User user = dbHandler.authenticateUser(username, password);
        return user != null;
    }

    @Override
    protected String nextOptions() {
        return "Login succeeded!\n" + loggedInMenu;
    }

    @Override
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
}
