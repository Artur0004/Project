public class FireBall extends Spell {
    private int damage;
    public FireBall() {
        super("Fireball","Unleash a fiery ball of destruction upon your enemy", 10);
        this.damage = 15;
    }
    @Override
    protected void executeSpellEffect(Player playerCaster, Player playerTarget){
            playerTarget.takeDamage(this.damage+playerCaster.getWisdom());

    }
}