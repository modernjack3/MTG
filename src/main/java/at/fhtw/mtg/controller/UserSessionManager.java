package at.fhtw.mtg.controller;

import at.fhtw.mtg.model.User;

import java.util.HashMap;
import java.util.HashSet;
import java.util.UUID;

public class UserSessionManager {
    private HashMap<String, User> tokenUser;
    private HashMap<String,User> users;

    public UserSessionManager(){
        tokenUser = new HashMap<>();
        users = new HashMap<>();
    }

    public String attemptLogin(String username, String password){
        if(!users.containsKey(username)) return null;
        if(!users.get(username).getPassword().equals(password)) return null;

        // User authenticated
        String token = username + "-mtgcToken";
        tokenUser.put(token, users.get(username));
        return token;
    }

    public User getUserFromToken(String token){
        return tokenUser.get(token);
    }

    public boolean registerUser(String username, String password){
        if(users.containsKey(username)){
            return false;
        }
        User newUser = new User(username, password);
        users.put(username,newUser);
        return true;
    }

}
