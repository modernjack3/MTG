package at.fhtw.mtg.controller;

import java.util.HashMap;

public class GameManager {

    private static final GameManager instance = new GameManager();
    private final UserSessionManager uManager = new UserSessionManager();

    private GameManager(){

    }

    public static GameManager getInstance(){
        return instance;
    }

    public synchronized boolean registerUser(String user, String password){
        return uManager.registerUser(user,password);
    }

    public synchronized String loginUser(String user, String password){
        return uManager.attemptLogin(user,password);
    }

    // Synchronised console print
    public static synchronized void sPrint(String text){
        System.out.println(text);
    }
}
