public class Tornado extends Spell {
    private int damage;
    private int stunChance;

    public Tornado() {
        super("Tornado", "Summon a powerful tornado that damages and stuns your opponent", 10);
        this.damage = 10;
        this.stunChance = 25;
    }

    @Override
    protected void executeSpellEffect(Player playerCaster, Player playerTarget) {
        playerTarget.takeDamage(this.damage);
        stunning(playerCaster, playerTarget, this.stunChance);
    }
}