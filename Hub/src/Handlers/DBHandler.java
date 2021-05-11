package Handlers;

import Classes.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DBHandler {
    List<User> db;
    String path;
    public DBHandler(String path) {
        this.path = path;
        try (Reader reader = Files.newBufferedReader(Paths.get(path))) {
            Gson gson = new Gson();
            db = gson.fromJson(reader, new TypeToken<List<User>>(){}.getType());
        }
        catch(IOException ignore){
        } finally {
            if(db == null){
                db = new ArrayList<>();
            }
        }
    }

    public User authenticateUser(String username, String password){
        for(User user : db){
            if(user.getUsername().equals(username) && user.getPassword().equals(password)){
                return user;
            }
        }
        return null;
    }

    public boolean addUser(String username, String password){
        return !usernameAlreadyExists(username) && db.add(new User(username, password));
    }

    public User getUser(String username){
        for (User user : db){
            if(user.getUsername().equals(username)){
                return user;
            }
        }
        return null;
    }

    private boolean usernameAlreadyExists(String username) {
        for(User user : db){
            if(user.getUsername().equals(username)){
                return true;
            }
        }
        return false;
    }

    public void updateDB() throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (Writer writer = Files.newBufferedWriter(Paths.get(path), StandardCharsets.UTF_8)) {
            gson.toJson(db, writer);
        } catch (IOException e){
            new File(path).createNewFile();
            gson.toJson(db, new FileWriter(path));
        }
    }
}
