package srpfacadelab;

import java.util.HashMap;

public class ItemUser {
    private final RpgPlayer player;
    private HashMap<String, Consumer<RpgPlayer>> itemMap;
    
    public ItemUser(RpgPlayer player) {
        this.player = player;
        itemMap = new HashMap<String, Consumer<RpgPlayer>>();
        
        itemMap.put("Stink Bomb", new StinkBomb());
    }
    
    public void useItem(Item i) {
        if (itemMap.containsKey(i.getName())) {
            itemMap.get(i.getName()).accept(player);
        }
    }
}