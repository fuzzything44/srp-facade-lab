package srpfacadelab;

public class ItemFinder {
    private RpgPlayer player;
    
    public ItemFinder(RpgPlayer player) {
        this.player = player;
    }
    
    public boolean checkIfItemExistsInInventory(Item item) {
        for (Item i: player.getInventory()) {
            if (i.getId() == item.getId())
                return true;
        }
        return false;
    }
}