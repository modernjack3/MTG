package at.fhtw.mtg.model;

import java.util.UUID;

public class User {

    // User Data Section    -------------------------------------------------------------------------
    //Identification
    private String userId;      // 64 Character UID
    private String username;    // Login name
    private String password;    // Login password

    //User Profile
    private String name;        // User real name
    private String bio;         // User Biography
    private String image;       // Base64 encoded Profile Picture

    //User Statistics
    private Integer wins;       // Total number of won games
    private Integer losses;     // Total number of lost games
    private Integer totalGames; // To account for draws in the elo system
    private Double elo;         // Current elo score

    //Card handling
    private Stack stack;        // All of the users card
    private Deck deck;          // The users Deck
    private Integer money;      // How much money the user has to buy booster packs
    //----------------------------------------------------------------------------------------------

    public User(String username, String password){
        this.username = username;
        this.password = password;

        this.userId = UUID.randomUUID().toString();

        this.elo = 100.0;

        this.totalGames = 0;
        this.wins = 0;
        this.losses = 0;

        this.stack = new Stack();
        this.deck = new Deck();
        this.money = 5;
    }

    public String getPassword(){
        return password;
    }




}
