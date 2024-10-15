package at.fhtw.mtg.model;

import java.util.ArrayList;

public class Stack {
    private ArrayList<Card> cards;

    public Stack(){
        cards = new ArrayList<Card>();
    }

    public boolean addCard(Card c){
        cards.add(c);
        return true;
    }

    public ArrayList<Card> getCards(){
        return cards;
    }

    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append("-------------------------------- Stack ---------------------------------\n");
        for (Card c : cards) str.append(cards.indexOf(c) + "  " + c.toString() + "\n");
        str.append("-----------------------------------------------------------------------");
        return str.toString();
    }
}
