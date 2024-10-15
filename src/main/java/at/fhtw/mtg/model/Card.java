package at.fhtw.mtg.model;

public final class Card {
    private String cardID;          // Unique Card ID for trading and tracking
    private Boolean isSpell;        // True if the card is a spell

    private String name;            // Card name
    private Elemental element;       // Element of the card
    private Integer damage;         // The cards damage


    //TODO: PROPER CONSTRUCTOR
    public Card(){
        this.cardID = "0f823b6s7x8yyz";
        this.isSpell = false;

        this.name = "Test";
        this.element = Elemental.FIRE;
        this.damage = 100;
    }

    public Card(int damage, String name, Elemental element, boolean isSpell, String uuid){
        this.cardID = uuid;
        this.isSpell = isSpell;

        this.name = name;
        this.element = element;
        this.damage = damage;
    }


    public Elemental getElement(){
        return this.element;
    }

    public Integer getDamage(){
        return this.damage;
    }

    public String getName(){
        return this.name;
    }

    public String getCardID(){
        return this.cardID;
    }

    public boolean getIsSpell(){
        return this.isSpell;
    }


    public Double attack(Card enemy){
        //Check if either card is a spell card or normal monster card
        if (this.isSpell || enemy.getIsSpell()){
            // Damage Calculation with Elemental Multiplication
            return (this.getMult(enemy) * this.damage);
        }
        //Monster Card
        else{
            return Double.valueOf((this.damage));
        }
    }

    // IMPORTANT: IF AT LEAST ONE CARD IS A SPELL USE THIS FOR BOTH
    private Double getMult(Card enemy){
        Elemental eElement = enemy.getElement();

        // We are normal
        if (this.element == Elemental.NORMAL){
            // Normal not effective against Fire
            if (eElement == Elemental.FIRE){
                return 0.5;
            }   // Normal effective against Water
            else if(eElement == Elemental.WATER){
                return 2.0;
            }
            // Normal Damage
            return 1.0;
        }

        // We are Fire
        if (this.element == Elemental.FIRE){
            // Fire not effective against Water
            if (eElement == Elemental.WATER){
                return 0.5;
            }   // Fire effective against Normal
            else if(eElement == Elemental.NORMAL){
                return 2.0;
            }
            // Normal Damage
            return 1.0;
        }

        // We are Water
        if (this.element == Elemental.WATER){
            // Water not effective against Normal
            if (eElement == Elemental.NORMAL){
                return 0.5;
            }   // Water effective against Fire
            else if(eElement == Elemental.FIRE){
                return 2.0;
            }
            // Normal Damage
            return 1.0;
        }
        return null;
    }

    @Override
    public String toString(){
        return "[" + cardID + "] " + element + (isSpell ? " Spell":" Monster") + " | " + name + " (" + damage + ")";
    }
}
