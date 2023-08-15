import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//facilitate casting spells and adding ready spells to the player's spell books
public class SpellsManager {
    public static List<Spell> getAllSpells() {
        return Arrays.asList(
                new FireBall(), new Tornado(), new LifeDrain(), new ChaosManifestation(), new Concentration(), new RockSolid(), new MagicHealing(), new MagicalRecovery(), new energyFeast());
    }//ready and balanced spells ready to be introduced into gameplay come here

    public static Spell choosingSpellToCast(Scanner scanner) {
        while (true) {
            System.out.println("Choose a spell by entering its number:");
            int spellIndex = 1;
            for (Spell spell : SpellsManager.getAllSpells()) {
                System.out.println(spellIndex + ". " + spell.getName() + " - " + spell.getDescription() + ". Mana cost of this spell is: " + spell.getManaCost());
                spellIndex++;
            }
            if (scanner.hasNextInt()) {
                int spellNumber = scanner.nextInt();
                if (spellNumber >= 1 && spellNumber <= SpellsManager.getAllSpells().size()) {
                    return SpellsManager.getAllSpells().get(spellNumber - 1);
                } else {
                    System.out.println("Invalid spell number. Try again.");
                }
            } else {
                System.out.println("Invalid input. Enter a valid spell number.");
                scanner.next();
            }
        }
    }
}
