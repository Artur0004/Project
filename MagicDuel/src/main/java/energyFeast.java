public class energyFeast extends Spell {
    private final int manaSteal;

    public energyFeast() {
        super("Energy Feast", "Feast upon your opponent's energy, burning their mana and restoring some for yourself", 10);
        this.manaSteal = 15;
    }
    @Override
    protected void executeSpellEffect(Player playerCaster, Player playerTarget) {
        playerTarget.loseMana(this.manaSteal + playerCaster.getWisdom());
        playerCaster.manaRegen(this.manaSteal + playerCaster.getWisdom());
    }
}