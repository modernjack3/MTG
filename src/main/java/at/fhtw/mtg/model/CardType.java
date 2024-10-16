package at.fhtw.mtg.model;

import java.util.HashMap;

public enum CardType {

    //Required Cards with special interactions
    GOBLIN("Goblin",100,Elemental.NORMAL,false),
    DRAGON("Dragon",150,Elemental.FIRE,false),

    WIZARD("Wizard",80,Elemental.WATER,true),
    ORK("Ork",120,Elemental.NORMAL,false),

    KNIGHT("Knight",140,Elemental.NORMAL,false),
    WATERSPELL("WaterSpell",50,Elemental.WATER,true),

    KRAKEN("Kraken",110,Elemental.WATER,false),

    FIRE_ELVE("FireElve",80,Elemental.FIRE,true),

    SLIMEBLOB("Slimeblob",60,Elemental.NORMAL,true),

    //CURL REQUIRED CARDS
    WATER_GOBLIN("WaterGoblin",10,Elemental.WATER,true);

    private final String name;          //Name of the card
    private final Integer damage;       //Default damage (can be overridden at card creation)
    private final Elemental element;    //Element type
    private final Boolean isSpell;      //Spell card

    CardType(String name, Integer damage, Elemental element, Boolean isSpell) {
        this.name = name;
        this.damage = damage;
        this.element = element;
        this.isSpell = isSpell;
    }

    private static final HashMap<String,CardType> map;
    static {
        map = new HashMap<String ,CardType>();
        for (CardType c : CardType.values()) {
            map.put(c.name, c);
        }
    }

    public static CardType findByName(String name) {
        return map.get(name);
    }

}
