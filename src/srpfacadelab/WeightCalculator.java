package srpfacadelab;

public class WeightCalculator {
    private RpgPlayer player;
    
    public WeightCalculator(RpgPlayer player) {
        this.player = player;
    }
    
    public int calculateInventoryWeight() {
        int sum = 0;
        for (Item i: player.getInventory()) {
            sum += i.getWeight();
        }
        return sum;
    }
}