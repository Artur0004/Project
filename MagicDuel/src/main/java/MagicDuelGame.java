import java.util.Scanner;

public class MagicDuelGame {
    private Player player1;
    private Player player2;
    private int turn = 1;

    public static void main(String[] args) {
        boolean AIMode=false;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Magic Duel!");


        System.out.println("Choose an option:");
        System.out.println("1. PvP (Play versus another human)");
        System.out.println("2. PvAI (Play versus AI)");

        int choice = scanner.nextInt();
        scanner.nextLine();
        Player player1 = null;
        Player player2 = null;

        if (choice == 1) {
            CharacterCreation characterCreation = new CharacterCreation();
            player1 = characterCreation.createCharacter(scanner);
            System.out.println("Player 1 created their character!");
            System.out.println(" ");
            System.out.println("Player 2 creates their character!");
            player2 = characterCreation.createCharacter(scanner);
            System.out.println("Player 2 created their character!");
            System.out.println("--------------------------");

        } else if (choice == 2) {

            CharacterCreation characterCreation = new CharacterCreation();
            System.out.println("Player 1 creates their character!");
            player1 = characterCreation.createCharacter(scanner);
            System.out.println("Player 1 created their character!");
            System.out.println("--------------------------");

            System.out.println("AI creates their character!");
            player2 = AI.createRandomAI();
            System.out.println("AI character created!");
            AIMode=true;
            System.out.println("Welcome to this game, " + player2.getName() + ". Your stats are:");
            System.out.println("Wisdom: " + player2.getWisdom());
            System.out.println("Resistance: " + player2.getResistance());
            System.out.println("Luck: " + player2.getLuck());

        } else {
            System.out.println("It wasn't an option!");
        }

        if (player1 != null && player2 != null) {
            MagicDuelGame game = new MagicDuelGame(player1, player2);
            game.playGame(AIMode);

        }
    }

    public MagicDuelGame(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void playGame(boolean isAiModeOn) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Starting the game...");

        Player startingPlayer = (player1.getLuck() >= player2.getLuck()) ? player1 : player2;
        Player secondPlayer = (startingPlayer == player1) ? player2 : player1;

        System.out.println(startingPlayer.getName() + " starts first!");

        while (!player1.isDead() && !player2.isDead()) {
            Player currentPlayer = (turn % 2 == 1) ? startingPlayer : secondPlayer;
            Player opponentPlayer = (turn % 2 == 1) ? secondPlayer : startingPlayer;

            if (currentPlayer.isStunned() == false) {

                Spell chosenSpell = null;

                    System.out.println("Turn " + turn);
                    System.out.println(currentPlayer.getName() + ", it's your turn!");
                    if (isAiModeOn && currentPlayer instanceof AI) {
                        chosenSpell = AI.spelling(currentPlayer, opponentPlayer);

                    } else  {
                        chosenSpell = SpellsManager.choosingSpellToCast(scanner);

                    }
                    chosenSpell.cast(currentPlayer, opponentPlayer);


            } else {
                System.out.println("You are stunned " + currentPlayer.getName() + " and you cannot cast a spell on your turn!");
                currentPlayer.setStunned(false);
            }

            currentPlayer.getInfoHpMana();
            opponentPlayer.getInfoHpMana();
            System.out.println("--------------------------");


            turn++;
        }
        System.out.println("Game over!");
        if (player1.isDead() == true && player2.isDead() == true) {
            System.out.println(player1.getName() + " draws " + player2.getName() + "!");
        } else if (player1.isDead() == true) {
            System.out.println(player2.getName() + " wins!");
        } else {
            System.out.println(player1.getName() + "wins!");
        }
    }
}
