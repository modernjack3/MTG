package at.fhtw.mtg.model;

public class Package {
    Card[] cards;

    public Package(Card c1, Card c2, Card c3, Card c4, Card c5){
        cards = new Card[5];
        cards[0] = c1;
        cards[1] = c2;
        cards[2] = c3;
        cards[3] = c4;
        cards[4] = c5;
    }

}
