package Commands;

import Handlers.DBHandler;
import java.io.IOException;
import java.util.Scanner;

public class Logout extends Command{

    public Logout(DBHandler dbHandler, Scanner input) {
        super(dbHandler, input);
    }

    @Override
    public Command execute() throws IOException {
        System.out.println(nextOptions());
        return new Menu(dbHandler, input);
    }

    @Override
    protected String nextOptions() {
        return "performing log out";
    }

    @Override
    protected Command generateNextCommand(int choice) {
        return null;
    }
}
