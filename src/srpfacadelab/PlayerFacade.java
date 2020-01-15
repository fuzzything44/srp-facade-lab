package srpfacadelab;

public class PlayerFacade {
    private final RpgPlayer player;
    private final ItemUser itemUser;
    private final ItemGetter itemGetter;
    private final WeightCalculator weightCalc;
    private final ItemFinder itemFinder;
    private final StatCalculator statCalculator;
    private final DamageCalculator damageCalculator;
    
    public PlayerFacade(RpgPlayer player) {
        this.player = player;
        this.itemUser = new ItemUser(player);
        this.itemGetter = new ItemGetter(player, this);
        this.weightCalc = new WeightCalculator(player);
        this.itemFinder = new ItemFinder(player);
        this.statCalculator = new StatCalculator(player);
        this.damageCalculator = new DamageCalculator(player, this.weightCalc);
    }
    
    public void useItem(Item item) {
        itemUser.useItem(item);
    }
    
    public boolean pickUpItem(Item item) {
        return itemGetter.pickUpItem(item);
    }
    
    public int calculateInventoryWeight() {
        return weightCalc.calculateInventoryWeight();
    }
    
    public boolean checkIfItemExistsInInventory(Item item) {
        return itemFinder.checkIfItemExistsInInventory(item);
    }
    
    public int calculateStats() {
        return statCalculator.calculateStats();
    }
    
    public void takeDamage(int damage) {
        damageCalculator.takeDamage(damage, totalWeight);
    }
}