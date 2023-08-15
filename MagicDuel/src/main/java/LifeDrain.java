public class LifeDrain extends Spell {
    private int damage;
    private int lifeSteal;
    public LifeDrain() {
        super("Life Drain","Drain the life force of your opponent and restore your own health", 15);
        this.damage = 10;
        this.lifeSteal=50;
    }
    @Override
    protected void executeSpellEffect(Player playerCaster, Player playerTarget){
        int actualHealing;
        actualHealing=this.damage*(this.lifeSteal/100);
        playerTarget.takeTrueDamage(this.damage);
        playerCaster.heal(actualHealing);

    }
}