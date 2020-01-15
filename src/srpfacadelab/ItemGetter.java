package srpfacadelab;

import java.util.HashMap;

public class ItemGetter {
    private final RpgPlayer player;
    private final PlayerFacade facade;
    
    public ItemGetter(RpgPlayer player, PlayerFacade facade) {
        this.player = player;
        this.facade = facade;
    }
    
    public boolean pickUpItem(Item item) {
        int weight = facade.calculateInventoryWeight();
        if (weight + item.getWeight() > RpgPlayer.getCarryingCapacity) {
            return false;
        }

        if (item.isUnique() && facade.checkIfItemExistsInInventory(item)) {
            return false;
        }
        
        // Don't pick up items that give health, just consume them.
        if (item.getHeal() > 0) {
            player.setHealth(player.getHealth() + item.getHeal());
            
            if (player.getHealth() > player.getMaxHealth()) {
                player.setHealth(player.getMaxHealth());
            }
            
            if (item.getHeal() > 500) {
                player.gameEngine.playSpecialEffect("green_swirly");
            }

            return true;
        }

        if (item.isRare()) {
            if (item.isUnique()) {
                player.gameEngine.playSpecialEffect("blue_swirly");
            } else {
                player.gameEngine.playSpecialEffect("cool_swirly_particles");
            }
        }
        
        player.getInventory().add(item);

        player.setArmour(facade.calculateStats());

        return true;
    }

}