package srpfacadelab;

public class DamageCalculator {
    private RpgPlayer player;
    private WeightCalculator weightCalculator;
    
    public DamageCalculator(RpgPlayer player, WeightCalculator weightCalc) {
        this.player = player;
        this.weightCalculator = weightCalc;
    }
    
    private int calcDamageTaken(int damage) {
        int damageToDeal = damage - armour;
        
        if (weightCalculator.calculateInventoryWeight() * 2 < player.getCarryingCapacity()) {
            damageToDeal *= 0.75;
        }
        return damageToDeal;
    }
    
    public void takeDamage(int damage) {
        if (damage < player.getArmour()) {
            gameEngine.playSpecialEffect("parry");
            return;
        }

        player.setHealth(player.getHealth() -= calcDamageTaken(damage));

        gameEngine.playSpecialEffect("lots_of_gore");
    }
}