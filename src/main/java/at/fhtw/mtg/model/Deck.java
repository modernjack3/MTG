package at.fhtw.mtg.model;

import java.util.ArrayList;

public class Deck {

    private ArrayList<Card> cards;
    private int idx;

    public Deck(){
        cards = new ArrayList<Card>();
        idx = 0;
    }

    public Deck(Card c1, Card c2, Card c3, Card c4){
        cards = new ArrayList<Card>();
        cards.add(c1);
        cards.add(c2);
        cards.add(c3);
        cards.add(c4);
    }
    public boolean removeAll(){
        cards = new ArrayList<Card>();
        return true;
    }

    public boolean isValid(){
        if(cards.size() == 4) return true;
        return false;
    }

    public boolean addCard(Card c){
        //Deck is full
        if(cards.size() > 3) return false;

        if(cards.contains(c)){
            return false;
        }
        cards.add(c);
        return true;

    }

    public boolean removeCard(Card c){
        if(cards.contains(c)){
            cards.remove(c);
            return true;
        }
        return false;
    }

    public boolean removeCard(int i){
        if(i>=cards.size()) return false;
        cards.remove(i);
        return true;
    }

    public Card getNext(){
        if(idx < 3){
            Card ret = cards.get(idx);
            idx ++;
            return ret;
        }
        // No more cards
        return null;
    }

    public void prepNewGame(){
        idx = 0;
    }

    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append("-------------------------------- Deck ---------------------------------\n");
        for (Card c : cards) str.append(cards.indexOf(c) + " " + c.toString() + "\n");
        str.append("-----------------------------------------------------------------------");
        return str.toString();
    }


}
