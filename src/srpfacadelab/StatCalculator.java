package srpfacadelab;

public class StatCalculator {
    private RpgPlayer player;
    
    public StatCalculator(RpgPlayer player) {
        this.player = player;
    }
    
    public void calculateStats() {
        int armour = 0;
        for (Item i: player.getInventory()) {
            armour += i.getArmour();
        }
        return armour;
    }
}