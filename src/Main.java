import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main (String[] args) {

        //Initialization
        Scanner input = new Scanner(System.in);
        String arrayOfInitiation[] = new String[]{"A bandit has secretly infiltrating the base...\n","An enemy has been alerted!\n",
                                                    "An assassin was seen flanking...\n","A guerilla is sneaking up...\n","Enemy footsteps approaching...\n"};
        Help h = new Help();
        Player p = new Player();
        boolean running = true;
        
        //Border
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\n");
        System.out.println("\t\t\tWelcome to the battlefield, Radiant!\t\t\t\n");

        //User's name
        System.out.print("Enter your name: ");
        String userName = input.nextLine();
        //Brief intro
        System.out.println("\nImmortal Chamber: So you must be Radiant " + userName +"!");
        System.out.println("Immortal Chamber: Before you take my position, kindly type <help> to see the commands list.");
        System.out.print("\nEnter your move: ");
        String introInput = input.nextLine();
        System.out.println("\n<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\n");
            //redirected to HELP INTERFACE
            if (introInput.equals("help")) {
                h.help_interface();
            }

        //Game Loop
        while(running) {
            //Enemy entry point
            System.out.println("\n<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\n");
            System.out.println(getRandomInitiation(arrayOfInitiation));

            //User's move
            System.out.print("Enter your move: ");
            String playerAction = input.nextLine();

            //HELP INTERFACE
            if (playerAction.equals("help")) {
                h.help_interface();
            }
            //HEAL INTERFACE    
            if (playerAction.equals("inject")) {
                p.inject_interface();
            }
            //RELOAD INTERFACE
            if (playerAction.equals("reload")) {
                p.reload_interface();
            }
            //SHOOT INTERFACE
            if (playerAction.equals("shoot")) {
                p.shoot_interface();
            }
            //SHOP INTERFACE
            if (playerAction.equals("shop")) {
                p.shop_interface();
            }
            //STATS INTERFACE
            if (playerAction.equals("stats")) {
                System.out.println("\n<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                System.out.println("\n\t\t\t\t\tPlayer Statistics\t\t\t\t");
                System.out.println("\n\t\t\t\t\tRadiant " + userName + "\t\t\t\t");
                System.out.println("\t\t\t\t\t" + p.playerLevel + ": " + p.playerRank + "\t\t\t\t\n");
                System.out.println("\tStamina: " + p.getPlayerStamina());
                System.out.println("\tEnemies killed: " + p.getkillCounter());
                System.out.println("\tTotal Cartridges: " + p.getTotalBullet());
                System.out.println("\tAdrenaline Shots left: " + p.getTotalAdrenaline());
                System.out.println("\tExperience Gained: " + p.totalExp);
                System.out.println("\tRadianite Gained: " + p.getTotalRadianite());
            }
            //EXIT INTERFACE
            if (playerAction.equals("exit")) {
                System.out.println("\n<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                System.out.println("\nExtracting from the site...");
                System.out.println("\n\t\t\t\t\tCombat Summary\t\t\t\t\n");
                System.out.println("\tEnemies killed: " + p.getkillCounter());
                System.out.println("\tExperience Gained: " + p.totalExp);
                System.out.println("\tRadianite Gained: " + p.getTotalRadianite());
                System.out.println("\nWell Played, " + p.playerRank + " " + userName + "!");
                System.out.println("\n<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                break;
            }
            if (playerAction.equals("use")) {
                System.out.println("\n<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                p.useCombatMerit();
                System.out.println("\nExtracting from the site...");
                System.out.println("\nCOMBAT SUMMARY\t\t\t\t\n");
                System.out.println("Enemies killed: " + p.getkillCounter());
                System.out.println("Experience Gained: " + p.totalExp);
                System.out.println("Radianite Gained: " + p.getTotalRadianite());
                System.out.println("\n\t\t\t\tWell Played, " + p.playerRank + " " + userName + "!");
                System.out.println("\n<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                break;
            }

        } 
        
    }
    
    //getters for random enemy entries
    public static String getRandomInitiation(String[] array){
        int result = new Random().nextInt(array.length);
        return array[result];
    }


}
