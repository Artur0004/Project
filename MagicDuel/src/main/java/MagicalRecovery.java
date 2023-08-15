public class MagicalRecovery extends Spell {
    private int mana;
    public MagicalRecovery() {
        super("Magical Recovery","Tap into the wellspring of magic to replenish your mana", 0);
        this.mana = 15;
    }
    @Override
    protected void executeSpellEffect(Player playerCaster,Player playerTarget){
        playerCaster.manaRegen(this.mana+playerCaster.getWisdom()*2);
    }
}