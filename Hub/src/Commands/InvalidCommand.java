package Commands;

import Handlers.DBHandler;
import java.io.IOException;
import java.util.Scanner;

public class InvalidCommand extends Command{

    public InvalidCommand(DBHandler dbHandler, Scanner input) {
        super(dbHandler, input);
    }

    @Override
    public Command execute() throws IOException {
        dbHandler.updateDB();
        System.out.println(nextOptions());
        return null;
    }

    @Override
    protected String nextOptions() {
        return "Invalid command received, quitting gracefully";
    }

    @Override
    protected Command generateNextCommand(int choice) {
        return null;
    }
}
