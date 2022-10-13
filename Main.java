import java.io.*;
import java.util.*;

class Main {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    String left = "";
    String test = "";
    int top = 0;
    int win = 0;
    //new object
    Player one = new Player(1);
    //new Ai
    Ai two = new Ai(1);
    //board generation
    one.genboard();
    two.genboard();
    System.out.println();
    intro();
    left = scan.nextLine();
    

  do{
    System.out.print("\033[H\033[2J"); 
    System.out.flush(); 
    System.out.println("\nAi Board: \n");
    two.printboard();
    System.out.println("\nPlayer Board: ");
    one.printboard();
    System.out.println("Choose a Letter on the left");
    left = scan.nextLine();
    System.out.println(left);
    System.out.println("Choose a number on the top");
    top = scan.nextInt();
    System.out.println(top);
    scan.nextLine();
    two.shoot(left, top);
    one.shoot(two.left(), two.top());
    System.out.println();
    test = scan.nextLine();
  }while (win == 0);      
  }

  public void intro(){
    Scanner lineIn = new Scanner (new FileReader("a.txt"));
    int ctr = 1;
    while(lineIn.hasNextLine())
     {
       String line = lineIn.nextLine();
       String x = processSentence(line);
       System.out.println("Line" + ctr + " " + x);
       ctr++;
     }
    lineIn.close();
  }
}