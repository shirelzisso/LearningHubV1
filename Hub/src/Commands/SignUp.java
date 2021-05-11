package Commands;

import Handlers.DBHandler;
import java.io.IOException;
import java.util.Scanner;

public class SignUp extends Command{
    public SignUp(DBHandler dbHandler, Scanner input) {
        super(dbHandler, input);
    }

    @Override
    public Command execute() throws IOException {
        String username = getStringInput("username");
        String password = getStringInput("password");
        success = dbHandler.addUser(username, password);
        if(success) {
            System.out.println(nextOptions());
            int choice = getIntInput();
            return generateNextCommand(choice);
        }
        System.out.println("Sign up failed - username already exists, returning to main menu");
        return new Menu(dbHandler, input);
    }


    @Override
    protected String nextOptions() {
        return "Sign up successful!\n[1] Login\n[2] Quit";
    }

    @Override
    protected Command generateNextCommand(int choice) {
        switch (choice){
            case 1:
                return new Login(dbHandler, input);
            case 2:
                return new Quit(dbHandler, input);
            default:
                return new InvalidCommand(dbHandler, input);
        }
    }
}
