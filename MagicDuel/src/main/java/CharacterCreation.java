import java.util.InputMismatchException;
import java.util.Scanner;

public class CharacterCreation {

    public static void main(String[] args) {
        CharacterCreation characterCreation = new CharacterCreation();
        Scanner scanner = new Scanner(System.in);
        Player player = characterCreation.createCharacter(scanner);
    }

    public Player createCharacter(Scanner scanner) {
        System.out.println();
        System.out.println("Welcome to Character creation!");
        System.out.println("You have to invest your points into attributes");
        System.out.println("Wisdom is how much you deal damage!");
        System.out.println("Resistance is how much you block damage");
        System.out.println("Luck is how often you stun with your spell, how often you are stunned and who starts duel first!");
        System.out.println("Health is your health points");
        System.out.println("Mana is your mana points");
        System.out.println("Each player has 10 points to distribute between Wisdom, Resistance and Luck");
        System.out.println("Enter your character's name:");
        String name = scanner.nextLine();

        int availablePoints = 10;
        int wisdom = 0;
        int resistance = 0;
        int luck = 0;

        while (availablePoints > 0) {
            try {
                System.out.println("Available attribute points: " + availablePoints);
                System.out.println("Enter points for Wisdom attribute:");
                int wisdomPoints = scanner.nextInt();
                System.out.println("You have " + (availablePoints - wisdomPoints) + " points left to distribute");
                System.out.println("Enter points for Resistance attribute:");
                int resistancePoints = scanner.nextInt();
                System.out.println("You have " + (availablePoints - (wisdomPoints + resistancePoints)) + " points left to distribute");
                System.out.println("Enter points for Luck attribute:");
                int luckPoints = scanner.nextInt();

                if (wisdomPoints >= 0 && resistancePoints >= 0 && luckPoints >= 0
                        && wisdomPoints + resistancePoints + luckPoints <= availablePoints) {
                    wisdom += wisdomPoints;
                    resistance += resistancePoints;
                    luck += luckPoints;
                    availablePoints -= wisdomPoints + resistancePoints + luckPoints;
                } else {
                    System.out.println("Invalid attribute points. Try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next();
            }
        }        System.out.println("Welcome to this game, " + name + ". Your stats are:");
        System.out.println("Wisdom: " + wisdom);
        System.out.println("Resistance: " + resistance);
        System.out.println("Luck: " + luck);
        System.out.println("--------------------------");


        return new Player(name, wisdom, resistance, luck, 100, 100, 100, 100);
    }

}
