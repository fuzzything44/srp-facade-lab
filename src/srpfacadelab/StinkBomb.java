package srpfacadelab;

public class StinkBomb implements Consumer<RpgPlayer> {
    public StinkBomb() {}
    
    public void accept(RpgPlayer player) {
        List<IEnemy> enemies = gameEngine.getEnemiesNear(player);

        for (IEnemy enemy: enemies){
            enemy.takeDamage(100);
        }
    }
}