import java.util.Random;

public class Drops extends Loot {

    //Random number generated drops from the enemies
    public int getExp() {
        Random r = new Random();
        return r.nextInt(17) + 35;
    }

    public int getRadianite() {
        Random r = new Random();
        return r.nextInt(65) + 78;
    }

    public void initializeLoot() {
        System.out.println("Scanning the corpse...\n");
    }

}