package Commands;

import Handlers.DBHandler;
import java.io.IOException;
import java.util.Scanner;

public class Menu extends Command{
    public Menu(DBHandler dbHandler, Scanner input) {
        super(dbHandler, input);
    }

    @Override
    public Command execute() throws IOException {
        System.out.println(nextOptions());
        int choice = getIntInput();
        return generateNextCommand(choice);
    }

    @Override
    protected String nextOptions() {
        return "[1] Login\n[2] Sign up\n[3] Quit";
    }

    @Override
    protected Command generateNextCommand(int choice) {
        switch (choice){
            case 1:
                return new Login(dbHandler, input);
            case 2:
                return new SignUp(dbHandler, input);
            case 3:
                return new Quit(dbHandler, input);
            default:
                return new InvalidCommand(dbHandler, input);
        }
    }
}
