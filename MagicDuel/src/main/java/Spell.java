import java.util.Random;

public abstract class Spell {
    private final String name;
    private final int manaCost;
    private final String description;

    public Spell(String name, String description, int manaCost) {
        this.name = name;
        this.manaCost = manaCost;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {

        return name;
    }

    public int getManaCost() {

        return manaCost;
    }

    //all spells base on it
    public void cast(Player playerCaster, Player playerTarget) {
        if (playerCaster.isEnoughMana(getManaCost())) {
            playerCaster.loseMana(getManaCost());
            System.out.println("You cast " + getName());
            executeSpellEffect(playerCaster, playerTarget);
        } else {
            System.out.println(getName() + " you don't have enough mana!");
        }
    }

    // stunning spells have it
    public void stunning(Player playerCaster, Player playerTarget, int StunChance) {
        int actualStunChance;
        actualStunChance = Math.max(StunChance + 5 * (playerCaster.getLuck() - playerTarget.getLuck()), 0);
        Random random = new Random();
        int randomNumber = random.nextInt(100) + 1;
        if (randomNumber < actualStunChance) {
            System.out.println(playerTarget.getName() + " is Stunned!");
            playerTarget.setStunned(true);
        }

    }

    //each of the spells have different spell effect
    protected abstract void executeSpellEffect(Player playerCaster, Player playerTarget);
}