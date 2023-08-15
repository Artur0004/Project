import java.util.List;
import java.util.Random;

public class AI extends Player {
    private static final String[] AI_NAMES = {
            "Harry Potter", "Albus Dumbledore", "Gellert Grindelwald", "Tom Riddle", "Severus Snape",
            "Remus Lupin", "Sirius Black", "Rubeus Hagrid", "Minerva McGonagall",
            "Horace Slughorn", "Pomona Sprout", "Sybill Trelawney", "Filius Flitwick",
            "Bellatrix Lestrange", "Nymphadora Tonks", "Lucius Malfoy", "Draco Malfoy",
            "Voldemort", "Kingsley Shacklebolt", "Dolores Umbridge", "Arthur Weasley"
    };

    public AI(String name, int wisdom, int resistance, int luck, int health, int mana, int maxHealth, int maxMana) {
        super(name, wisdom, resistance, luck, health, mana, maxHealth, maxMana);
    }

    // creating AI character with random name and random stats
    public static AI createRandomAI() {
        Random random = new Random();
        String randomName = AI_NAMES[random.nextInt(AI_NAMES.length)];
        int wisdom = random.nextInt(11);
        int resistance = random.nextInt(11);
        int luck = random.nextInt(11);
        int health = 100;
        int mana = 100;
        int maxHealth = 100;
        int maxMana = 100;

        return new AI(randomName, wisdom, resistance, luck, health, mana, maxHealth, maxMana);
    }

    //AI is choosing which spell it would be the best to cast
    public static Spell spelling(Player playerAI, Player playerHuman) {
        Random random = new Random();
        int randomNumber;
        List<Spell> allSpells = SpellsManager.getAllSpells();
        randomNumber = random.nextInt(allSpells.size());
        Spell chosenSpell = allSpells.get(randomNumber);
        if (randomNumber == 6 && (playerAI.getHealth() + 15 + playerAI.getWisdom() * 2) > playerAI.getMaxHealth()) {
            chosenSpell = allSpells.get(0);//to avoid needless healing
        }
        if (randomNumber == 7 && (playerAI.getMana() + 15 + playerAI.getWisdom() * 2) > playerAI.getMaxMana()) {
            chosenSpell = allSpells.get(0);//to avoid needless mana restoration
        }
        if (playerAI.getMana() < 20 || (randomNumber == 3 && playerAI.getHealth() < (playerAI.getWisdom() * 2 + 20 + playerHuman.getWisdom()))) {
            chosenSpell = allSpells.get(0);//for AI to avoid self-destruction via chaotic spell
        }
        if (playerAI.getLuck() > (playerHuman.getLuck() + 6)) {
            chosenSpell = allSpells.get(1);//if AI has advantage of luck
        }
        if (playerHuman.getWisdom() > playerAI.getResistance() + 7) {
            chosenSpell = allSpells.get(5);//if player has too much wisdom for AI
        }
        if (playerHuman.getResistance() > playerAI.getWisdom() + 7) {
            chosenSpell = allSpells.get(4);//if player has too much resistance for AI
        }
        if (playerHuman.getHealth() > (playerAI.getHealth() + 20)) {
            chosenSpell = allSpells.get(2);//AI wants to regenerate health points
        }
        if (playerHuman.getMana() > (playerAI.getMana() + 20)) {
            chosenSpell = allSpells.get(8);//AI wants to regenerate mana points
        }
        if (playerAI.getHealth() < (20 + playerHuman.getWisdom() - playerAI.getResistance())) {
            chosenSpell = allSpells.get(6);//if AI is low on health
        }
        if (playerAI.getMana() < 15) {
            chosenSpell = allSpells.get(7);// if AI is too low on mana
        } else if (((playerHuman.getHealth() + playerHuman.getResistance()) < (playerAI.getWisdom() + 15)) && playerAI.getMana() >= 10) {
            chosenSpell = allSpells.get(0);//if human player is low and AI is able to kill this turn
        }
        return chosenSpell;
    }
}
