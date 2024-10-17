package at.fhtw.mtg.controller;

import java.util.HashMap;

public class GameManager {

    private HashMap<String, String> users = new HashMap<>();
    private static final GameManager instance = new GameManager();

    private GameManager(){

    }

    public static GameManager getInstance(){
        return instance;
    }

    public synchronized boolean registerUser(String user, String password){
        if(users.containsKey(user)){
            return false;
        }
        users.put(user, password);
        return true;
    }

    // Synchronised console print
    public static synchronized void sPrint(String text){
        System.out.println(text);
    }
}
