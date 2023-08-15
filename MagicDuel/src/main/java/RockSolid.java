public class RockSolid extends Spell {
    private int resistanceBoost;
    public RockSolid() {
        super("Rock Solid","Harden your defenses, increasing your resistance against attacks", 15);
        this.resistanceBoost = 3;
    }
    @Override
    protected void executeSpellEffect(Player playerCaster,Player playerTarget){
         playerCaster.increaseResistance(this.resistanceBoost);
    }
}