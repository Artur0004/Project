public class Concentration extends Spell {
    private int wisdomBoost;
    public Concentration() {
        super("Concentration","Focus your mind, increasing your wisdom for strategic advantage", 15);
        this.wisdomBoost = 3;
    }
    @Override
    protected void executeSpellEffect(Player playerCaster,Player playerTarget){
        playerCaster.increaseWisdom(this.wisdomBoost);
    }
}