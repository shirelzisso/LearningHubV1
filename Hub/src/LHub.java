import Classes.User;
import Commands.Command;
import Commands.Menu;
import Handlers.DBHandler;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class LHub {
    private static String welcomeMessage = "Welcome to the Learning Hub!";

    public static void main(String... args) throws IOException {
        DBHandler dbHandler = new DBHandler(Paths.get("").toAbsolutePath() + "/resources/db.json");
        Scanner input = new Scanner(System.in);
        Command cmd = new Menu(dbHandler, input);

        System.out.println(welcomeMessage);
        try {
            while (cmd != null) {
                cmd = cmd.execute();
            }
        } catch (IOException e) {
            System.out.println("Caught exception [" + e.getMessage() + "]");
            System.out.println("Exiting gracefully, db update will happen");
            dbHandler.updateDB();
            return;
        }
        System.out.println("Thank you!");
        input.close();
    }


}
