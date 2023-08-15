public class MagicHealing extends Spell {
    private int heal;
    public MagicHealing() {
        super("Magic Healing","Harness magical energies to restore your health", 10);
        this.heal = 15;
    }
    @Override
    protected void executeSpellEffect(Player playerCaster,Player playerTarget){
        playerCaster.heal(this.heal+playerCaster.getWisdom()*2);
    }
}