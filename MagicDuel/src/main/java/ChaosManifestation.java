public class ChaosManifestation extends Spell {
    private int damage;
    private int stunChance;
    public ChaosManifestation() {
        super("Chaos Manifestation","Invoke the chaotic forces to deal damage and possibly stun your enemy", 20);
        this.damage = 5;
        this.stunChance=25;

    }
    @Override
    protected void executeSpellEffect(Player playerCaster,Player playerTarget){
            int actualDamageToCaster;
            int actualDamageToTarget;
            actualDamageToCaster=Math.min(this.damage+(playerCaster.getWisdom())*2,playerCaster.getHealth());
            actualDamageToTarget=Math.min(this.damage+(playerCaster.getWisdom())*2,playerTarget.getHealth());
            playerCaster.takeTrueDamage(actualDamageToCaster);
            playerTarget.takeTrueDamage(actualDamageToTarget);
            stunning(playerCaster,playerTarget,this.stunChance);
            playerCaster.takeDamage(actualDamageToCaster);
            playerTarget.takeDamage(actualDamageToTarget);

    }
}