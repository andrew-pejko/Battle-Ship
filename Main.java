/*
* Andrew Pejko
* ICS4U1
* Final Evaluation - Batlle Ship
* 26 January 2022
* This program does things
* It's also really cool :)
*/


//Only known issue is that if you scroll up in the console it will sometimes
//show previous boards because for some reason. To prevent this just make the consol larger
//and don't scroll up. Everything you need is already visible.

//import for scanner
import java.util.*;

class Main {
  public static void main(String[] args) {
    //scanner
    Scanner scan = new Scanner(System.in);
    //clear console
    System.out.print("\033[H\033[2J"); 
    System.out.flush(); 
    //string for conversion between letters and numbers
    String letters[] = {"A", "B", "C","D", "E", "F", "G", "H", "I", "J"};
    //for random numbers
    Random r = new Random();
    //Holds shot value for left side of bored
    String left = "";
    String Aileft = "";
    //holds shot values for top of board
    int top = 0;
    int Aitop = 0;
    int win = 0;
    //new object
    Player one = new Player(1);
    //new Ai
    Ai two = new Ai(1);
    //board generation
    one.genboard();
    two.genboard();
    //Shows Game Name
    intro();
    //asks about rules
    System.out.print("Press 1 to start and 2 for the rules: "); 
    left = scan.nextLine();
    //If user wants to see rules it shows them
    if(left.equals("2")){
      System.out.print("\033[H\033[2J"); 
      System.out.flush(); 
      rules();
      left = scan.nextLine();
      System.out.print("\033[H\033[2J"); 
      System.out.flush();
    }

  //loop to keep game running until win
  do{
    //clears board
    System.out.print("\033[H\033[2J"); 
    System.out.flush(); 
    //prints out user and ai board
    System.out.println("\nAi Board: \n");
    two.printboard();
    System.out.println("\nPlayer Board: ");
    one.printboard();
    //checks if user has played a round yet if they have shows ai shot from previous round
    if(Aileft.equals("")){
    } else{
      System.out.println("The Ai shot at: " + Aileft + Aitop);
      }
    //asks them to choose a coloum
    System.out.println("Choose a Letter on the left");
    left = scan.nextLine();
    //asks user to choose a row
    System.out.println("Choose a number on the top");
    top = scan.nextInt();
    scan.nextLine();
    //shoots at choosen spot
    two.shoot(left, top);
    //generating ai shot
    Aileft = letters[r.nextInt(10)];
    Aitop = r.nextInt(10);
    //ai shoots
    one.shoot(Aileft, Aitop);
    System.out.println();
    //checks if any ships have been fully destroyed
    one.deadcheck();
    two.deadcheck();
    //checks if ai or player has won yet
    if(one.wincheck() == 14){
      win = 2;
    }
    if(two.wincheck() == 14){
      win = 1;
    }
  }while (win == 0);  
  //clear console
  System.out.print("\033[H\033[2J"); 
  System.out.flush(); 

  //checks who won
  if(win == 1){
  System.out.println("You have won!!!");
  } else if (win == 2){
  System.out.println("The computer has won :(");
  }
  
  }

  //Battle Ship in ASCII
  public static void intro() {
    System.out.println("__________         __    __  .__           _________.__    .__");
    System.out.println("\\______   \\_____ _/  |__/  |_|  |   ____  /   _____/|  |__ |__|_____");
    System.out.println(" |    |  _/\\__  \\\\   __\\   __\\  | _/ __ \\ \\_____  \\ |  |  \\|  \\____ \\");
    System.out.println(" |    |   \\ / __ \\|  |  |  | |  |_\\  ___/ /        \\|   Y  \\  |  |_> >");
    System.out.println(" |______  /(____  /__|  |__| |____/\\___  >_______  /|___|  /__|   __/");
    System.out.println("        \\/      \\/                     \\/        \\/      \\/   |__|");
  }

  //Rules Method
  public static void rules(){
    System.out.println("__________      .__");
    System.out.println("\\______   \\__ __|  |   ____   ______");
    System.out.println(" |       _/  |  \\  | _/ __ \\ /  ___/");
    System.out.println(" |       _/  |  \\  | _/ __ \\ /  ___/");
    System.out.println(" |____|_  /____/|____/\\___  >____  >");
    System.out.println("        \\/                \\/     \\/");
    System.out.println("Each side has 4 ships: a 5, 4, 3, 2 peice");
    System.out.println("These peices are randomly generated and put annyware on the map");
    System.out.println("To win the game you must destroy all of the opponents peices");
    System.out.println("To shoot the game will ask you for a letter and a number");
    System.out.println("If you hit something on the opponents side it will be show with an X");
    System.out.println("If you miss it will be shown with a -");
    System.out.println("When an entire ship is destroyed you will see the letter G for gone");
    System.out.println("On your side of the field you will see ☐");
    System.out.println("This signifies your ships");
    System.out.println("The same attacking rules apply to your side (ie: X ai hit, - Ai miss etc)");
    System.out.println("You win the game when you destroy the all the ai's ships and lose if the ai destroys all of yours");
    System.out.println("Good Luck!!");
    System.out.println("Enter anything to exit");
  }
}
