package Commands;

import Handlers.DBHandler;
import java.io.IOException;
import java.util.Scanner;

public class Quit extends Command{

    public Quit(DBHandler dbHandler, Scanner input) {
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
        return "Quitting, thanks for using Learning Hub!";
    }

    @Override
    protected Command generateNextCommand(int choice) {
        return null;
    }

}
