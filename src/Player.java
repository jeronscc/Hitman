import java.util.Random;
import java.util.Scanner;

public class Player {
    //Initialization
    Drops d = new Drops();
    Main m = new Main();
    private int playerStamina = 100;
    private int killCounter = 0;
    private int totalBullet = 30;
    int totalAdrenaline = 3;
    int totalExp;
    int expGained;
    int totalRadianite;
    int radianiteGained;
    int adrenalineHealAmount = 30;
    int bulletCounter = 10;
    int remainingBulletSlot = 0;
    int combatMeritTotal;
    String playerRank = "Marksman";
    String playerLevel = "Level 1";
    String arrayOfDeaths[] = new String[]{"\nAn enemy has been taken down!\n","\nThe cartridge has pierced through the enemy's head!\n",
                                                    "\nEnemy killed!\n","\nA comrade has been saved...\n","\nAn invader has been  picked off!\n"};

    //INJECT FUNCTION
    public void inject_interface() {

        if(totalAdrenaline > 0) {
            playerStamina += adrenalineHealAmount;
            totalAdrenaline--;
            System.out.println("\nInjecting Adrenaline Shot...");
            System.out.println("Stamina: " + playerStamina);
            System.out.println("You currently now have " + totalAdrenaline + " adrenaline/s left.");
        }
        else {
            System.out.println("You have no adrenalines in your inventory!" );
        }

    }

    //RELOAD FUNCTION
    public void reload_interface() {

        if(bulletCounter == 10) {
            System.out.println("You already have the maximum ammo in your capacity!");
        }
        else if(bulletCounter <= 9){
            remainingBulletSlot = 10 - bulletCounter;
            totalBullet = totalBullet - remainingBulletSlot;
            bulletCounter = 10;
            System.out.println("\nTaking some cover...");
            System.out.println("Reloading...\n");
            System.out.println("Cartridge Counter: " + bulletCounter);
            System.out.println("You currently have " + totalBullet + " Lapua Magnum cartridges left in your inventory.");
        }  

    }

    //SHOOT FUNCTION
    public void shoot_interface() {
    
        if(playerStamina > 0 && bulletCounter != 0) {
            bulletCounter--;
            playerStamina -= 7;
            killCounter += 1;
            expGained = d.getExp();
            totalExp += expGained;

                //RANKING SYSTEM
                if(totalExp >= 100 && totalExp <= 300) {
                    playerRank = "Sharpshooter";
                    playerLevel = "Level 2";
                }
                else if(totalExp >300 && totalExp <= 500) {
                    playerRank = "Ascendant";
                    playerLevel = "Level 3";
                }
                else if(totalExp >500 && totalExp <= 1000) {
                    playerRank = "Challenger";
                    playerLevel = "Level 4";
                }
                else if(totalExp >1000 && totalExp <= 3000) {
                    playerRank = "Grandmaster";
                    playerLevel = "Level 5";
                }
                else if(totalExp > 3000) {
                    playerRank = "Immortal";
                    playerLevel = "Level 6";
                }

            radianiteGained = d.getRadianite();
            totalRadianite += radianiteGained;
            System.out.println(getRandomDeaths(arrayOfDeaths));
            System.out.println("Kill Counter: " + getkillCounter());
            //attributes inherited by class Drop
            d.foundLoot();
            d.initializeLoot();
            System.out.println("Experience Gained: " + expGained);
            System.out.println("Radianite Gained: " + radianiteGained);
        }
        else if(playerStamina <= 0) {
            playerStamina = 0;
            System.out.println("\nYou currently have " + playerStamina + " stamina left");
            System.out.println("You feel exhausted...\n");
            System.out.println("Inject some adrenaline shot!");
        }
        else if(bulletCounter == 0) {
            remainingBulletSlot = 10 - bulletCounter;
            totalBullet = totalBullet - remainingBulletSlot;
            bulletCounter = 10;
            System.out.println("\nNo bullets remaining!\n");
            System.out.println("Taking some cover...");
            System.out.println("Reloading...\n");
            System.out.println("Cartridge Counter: " + bulletCounter);
            System.out.println("You currently have " + totalBullet + " Lapua Magnum cartridges left in your inventory.");
        }

    }

    //SHOP FUNCTION
    public void shop_interface(){
        Scanner input = new Scanner(System.in);

        //shop output
        System.out.println("--------------------------------------------------------------------------------------------\n");
        System.out.println("\t\t\t\t\tMarket\t\t\t\t\t\t\n");
        System.out.println("\t1. Adrenaline...............................................250 Radianite");
        System.out.println("\t2. Lapua Magnum Cartridges..................................12 Radianite");
        System.out.println("\t3. Combat Merit (LEVEL 6 REQUIRED!).........................8500 Radianite");
        System.out.println("\n--------------------------------------------------------------------------------------------");

        //input for specific item and quantity
        System.out.print("Enter the number of choice: ");
        int itemChoiceInput = input.nextInt();
        System.out.print("Enter the quantity: ");
        int itemQuantityInput = input.nextInt();

        switch(itemChoiceInput) {
            
            case 1:
                int adrenalinePrice = 250*itemQuantityInput;

                if(totalRadianite >= adrenalinePrice) {
                    totalRadianite -= adrenalinePrice;
                    totalAdrenaline += itemQuantityInput;
                    System.out.print("\n" + itemQuantityInput + " Adrenaline/s has been added to your inventory.\n");
                }
                else{
                    System.out.print("\nNot enough Radianite!");
                }
                break;
            case 2: 
                int cartridgePrice = 12*itemQuantityInput;

                if(totalRadianite >= cartridgePrice) {
                    totalRadianite -= cartridgePrice;
                    totalBullet += itemQuantityInput;
                    System.out.print("\n" + itemQuantityInput + " Cartridge/s has been added to your inventory.\n");
                }
                else{
                    System.out.print("\nNot enough Radianite!");
                }
                break;
            case 3:
                int combatMeritPrice = 8500*itemQuantityInput;

                if(totalRadianite >= combatMeritPrice && playerLevel == "Level 6") {
                    combatMeritTotal = 1;
                    System.out.print("\n" + itemQuantityInput + " Combat Merit/s has been added to your inventory.\n");
                }
                else if(totalRadianite >= combatMeritPrice && playerLevel != "Level 6") {
                    System.out.println("\nImmortal Level 6 REQUIRED!");
                }
                else if(totalRadianite < combatMeritPrice && playerLevel == "Level 6") {
                    System.out.println("\nNot enough Radianite!");
                }
                else if(totalRadianite > combatMeritPrice && playerLevel != "Level 6") {
                    System.out.println("\nNot enough Radianite and Player Rank!");
                }

        }
    }

    //USE FUNCTION
    public void useCombatMerit() {
        if(combatMeritTotal >= 1) {
            System.out.println("\nCongratulations! This Combat Merit will be a symbol for your bravery.");
            System.out.println("Thank you for serving the city. We are preparing you for the extraction... ");
            System.out.println("\n\t\t\t\tTHE GAME HAS BEEN COMPLETED");
        }
        else if(combatMeritTotal < 1) {
            System.out.println("\nNot enough Combat Merit!");
        }

    }
    
    //getters for STATS INTERFACE
    public int getPlayerStamina() {
        return playerStamina;
    }

    public int getkillCounter() {
        return killCounter;
    }

    public int getTotalBullet() {
        return totalBullet;
    }

    public int getTotalAdrenaline() {
        return totalAdrenaline;
    }
    public int getTotalRadianite() {
        return totalRadianite;
    }
    
    //getters for random enemy deaths
    public static String getRandomDeaths(String[] array){
        int result = new Random().nextInt(array.length);
        return array[result];
    }
}
