public class Player {
    private String name;
    private int wisdom;
    private int resistance;
    private int luck;
    private int health;
    private int maxHealth;
    private int mana;
    private int maxMana;
    private boolean Stunned = false;

    public Player(String name, int wisdom, int resistance, int luck, int health, int mana, int maxHealth, int maxMana) {
        this.name = name;
        this.wisdom = wisdom;
        this.resistance = resistance;
        this.luck = luck;
        this.health = health;
        this.mana = mana;
        this.maxHealth = maxHealth;
        this.maxMana = maxMana;

    }

    public String getName() {
        return name;
    }

    public int getWisdom() {
        return wisdom;
    }

    public int getResistance() {
        return resistance;
    }

    public int getLuck() {
        return luck;
    }

    public int getHealth() {
        return health;
    }

    public int getMana() {
        return mana;
    }

    public boolean isStunned() {
        return Stunned;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getMaxMana() {
        return maxMana;
    }

    //public void decreaseResistance(int resistanceDec){this.resistance-=resistanceDec;System.out.println("Your resistance decreased by " + resistanceDec + "!");}
    //functionality to be expanded later
    public void setStunned(boolean StunnedBoolean) {
        Stunned = StunnedBoolean;
    }

    public void increaseWisdom(int wisdomInc) {
        this.wisdom += wisdomInc;
        System.out.println("Your wisdom increased by " + wisdomInc + "!");
    }

    //public void decreaseWisdom(int wisdomDec){this.wisdom-=wisdomDec;System.out.println("Your wisdom decreased by " + wisdomDec + "!");}
    //functionality to be expanded later
    public void increaseResistance(int resistanceInc) {
        this.resistance += resistanceInc;
        System.out.println("Your resistance increased by " + resistanceInc + "!");
    }

    public void getInfoHpMana() {
        System.out.println(this.name + " has " + this.health + " health points and " + this.mana + " mana points");
    }

    public boolean isDead() {
        if (this.health <= 0) {
            return true;
        } else {
            return false;
        }
    }

    public void takeDamage(int damage) {
        //with resistance
        int actualDamage = Math.max(damage - this.resistance, 0);
        this.health -= actualDamage;
        System.out.println(this.name + " takes " + actualDamage + " damage.");
    }

    public void takeTrueDamage(int damage) {
        //no resistance
        int actualDamage = Math.max(damage, 0);
        this.health -= actualDamage;
        System.out.println(this.name + " takes " + actualDamage + " damage.");
    }

    public void loseMana(int manaLost) {
        this.mana = Math.max(this.mana -= manaLost, 0);
    }

    public boolean isEnoughMana(int manaCost) {
        if (this.mana < manaCost) {
            return false;
        } else {
            return true;
        }
    }

    public void heal(int heal) {
        this.health = Math.min(this.health + heal, this.maxHealth);
        System.out.println(getName() + " healed " + heal + " points of health!");
    }

    public void manaRegen(int manaReg) {
        this.mana = Math.min(this.mana + manaReg, this.maxMana);
        System.out.println(getName() + " restored  " + manaReg + " points of mana!");
    }

}

