package Commands;

import Handlers.DBHandler;
import java.io.IOException;
import java.util.Scanner;

public abstract class Command {
    protected DBHandler dbHandler;
    protected Scanner input;
    protected final String loggedInMenu = "[1] Create new learning path\n[2] Add a learning block to existing learning path\n[3] Fetch all learning paths\n[4] Rate topic\n[5] Search paths by topic\n[6] Logout\n[7]Quit";

    public Command(DBHandler dbHandler, Scanner input) {
        this.dbHandler = dbHandler;
        this.input = input;
    }

    protected boolean success = false;
    public abstract Command execute() throws IOException;
    protected abstract String nextOptions();
    protected abstract Command generateNextCommand(int choice);
    protected int getIntInput(){
        return input.nextInt();
    }
    protected int getIntInput(String inputName){
        System.out.println("Please enter [" + inputName + "]");
        return input.nextInt();
    }
    protected String getStringInput(String inputName){
        System.out.println("Please enter [" + inputName + "]");
        return input.next();
    }


}
