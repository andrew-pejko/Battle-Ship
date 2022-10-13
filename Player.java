import java.util.*;

class Player {
  //random test value
  public int test;
  //contains the placment of ships
  public int ships[][] = new int[10][10];
  public String show[][] = new String[10][10];
  //hold to prevent overlaping ships
  public String hold[] = new String[20];
  //hold int for array
  int hld = 0;
  Random r = new Random();
  //letters
  public String letters[] = {"A", "B", "C","D", "E", "F", "G", "H", "I", "J"};
  //Hits
  int hits = 0;
  //Counts to see if a ship is fully destroyed
  int fivecount = 5;
  int fourcount = 4;
  int threecount = 3; 
  int twocount = 2;
 //constructor currently just holding a test value
 //I never added anything so the constructor is useless
  public Player(int i) {
    test = i;
  }
  //returns number of hits to see if there was a win
  public int wincheck(){
    return hits;
  }
  //used to check if a ship is dead
  public void deadcheck(){
    //checks counts to see if it is at zero
    //if it is it finds all of the ships destroyed parts and converts them to G
    if(twocount == 0){
      for (int x = 0; x < 10; x++) {
      for (int y = 0; y < 10; y++) {
        if(ships[x][y] == -2){
          show[x][y] = "G";        
          }
      }
    }
    twocount = -1;
    }
    //the rest all act the same as two count so the comments would be redundant
    if(threecount == 0){
      for (int x = 0; x < 10; x++) {
      for (int y = 0; y < 10; y++) {
        if(ships[x][y] == -3){
          show[x][y] = "G";        
          }
      }
    }
    threecount = -1;
    }
    if(fourcount == 0){
      for (int x = 0; x < 10; x++) {
      for (int y = 0; y < 10; y++) {
        if(ships[x][y] == -4){
          show[x][y] = "G";        
          }
      }
    }
    fourcount = -1;
    }
    if(fivecount == 0){
      for (int x = 0; x < 10; x++) {
      for (int y = 0; y < 10; y++) {
        if(ships[x][y] == -5){
          show[x][y] = "G";        
          }
      }
    }
    fivecount = -1;
    }
  }

  //Code to shoot at a specific spot
  //I added way to much and the code is slightly confusing but it works
  public void shoot (String left, int top){
  //convert players letter choice to lower case
  left = left.toLowerCase();
  int left2 = 0;

  //converts players letter to number so it is compatible with the ship array
  for (int z = 0; z < letters.length; z++){
    if(letters[z].toLowerCase().equals(left)){
      left2 = z;
    }
  }
  //checking if a shot was valid
  //if it is the count of that ship goes down and 
  //it is converted to a negative number
  //This is because the dead check uses negative numbers to find which ships to change to G
  if(ships[left2][top] > 0){
    if(ships[left2][top] == 2){
      twocount -= 1;
    } else if(ships[left2][top] == 3){
      threecount -= 1;
    } else if(ships[left2][top] == 4){
      fourcount -= 1;
    } else if(ships[left2][top] == 5){
      fivecount -= 1;
    }
    ships[left2][top] *= -1;
    hits += 1;
    } 
    //if it is a miss it is assigned the number -6
    else if(ships[left2][top] == 0){
      ships[left2][top] = -6;
    }
    //Here the x or - is placed on the board depending on if you hit or missed
        if(ships[left2][top] < 0 && ships[left2][top] > -6){
      show[left2][top] = "X";
        } else if(ships[left2][top] == -6){
          show[left2][top] = "-";
        }
    
  }
 
  //just prints out the board pretty self explanitory'
  //shows an overlay of the real board because original board is 
  //an int array and I wanted to have boxes for the ships
  public void printboard() {
    System.out.println();
    System.out.print("*" + "\t\t");
    for (int z = 0; z < 10; z++){
    System.out.print(z + "\t");
    }
    System.out.println();
    System.out.println("\t------------------------------------------");
    for (int x = 0; x < 10; x++) {
      System.out.print(letters[x] + "\t|\t");
      for (int y = 0; y < 10; y++) {
        System.out.print(show[x][y] + "\t");
      }
      System.out.println();
    }
  }
  
  //board generation
  //might not comment cause even I don't remember whats going on
  //As of Januray 26th I still don't remember how I wrote this but it works so...
  public void genboard(){
    int done = 0;
    int fifty = 0;
    int x = 0;
    int y = 0;
    int peice = 5;
    int counter = 0;
    while(peice > 1){
      done = 0;
      counter = 0;
      fifty = r.nextInt(2);
      x = r.nextInt(10);
      y = r.nextInt(10);

    if((fifty == 0) && ((x + 4) < 10)){
      for(int a = 1; a <= peice; a++){
        if(linecheck(x + (a-1), y) == 0){
          counter += 1;
        }
      }
      if (counter == peice){
      for(int a = 1; a <= peice; a++){
        ships[x + (a-1)][y] = peice;
        hold(x + (a-1), y);
       }
       done = 1;
      }
    } 

    else if((fifty == 0) && ((x - 4) > 0)){
      counter = 0;
      for(int a = 1; a <= peice; a++){
        if(linecheck((x - (a-1)), y) == 0){
          counter += 1;
        }
      }
      if (counter == peice){
      for(int a = 1; a <= peice; a++){
        ships[x - (a-1)][y] = peice;
        hold(x - (a-1), y);
       }
       done = 1;
      }else{
        fifty += 1;
      }
    }

    if((fifty == 1) && ((y + 4) < 10)){
      counter = 0;
       for(int a = 1; a <= peice; a++){
        if(linecheck(x, y + (a-1)) == 0){
          counter += 1;
        }
      }
      if(counter == peice){
      for(int a = 1; a <= peice; a++){
        ships[x][y + (a-1)] = peice;
        hold(x, y + (a-1));
       }
       done = 1;
      }
    }
    
    else if((fifty == 1) && ((y - 4) > 0)){
      counter = 0;
      for(int a = 1; a <= peice; a++){
        if(linecheck(x, (y - (a-1))) == 0){
          counter += 1;
        }
      }
      if(counter == peice){
      for(int a = 1; a <= peice; a++){
        ships[x][y - (a-1)] = peice;
        hold(x, y - (a-1));
      }
      done = 1;
     }
    } 
    if (done == 1){
    peice--;
    }
    }

     for (int n = 0; n < 10; n++) {
      for (int m = 0; m < 10; m++) {
      show[n][m] = "O";
      }
      System.out.println();
    }

    for (int k = 0; k < 10; k++) {
      for (int l = 0; l < 10; l++) {
        if(ships[k][l] > 0){
      show[k][l] = "☐";
        }
      }
      System.out.println();
    }

  }
  //hold method to store x and y values of placed ships
  public void hold(int x, int y) {
    hold[hld] = Integer.toString(x) + Integer.toString(y);
    hld += 1;
  }
  //check to see if the ship currently being placed overlaps with another ship
  public int linecheck(int x, int y) {
    int ret = 0;
    String value = Integer.toString(x) + Integer.toString(y);
    for (int a = 0; a < hold.length; a++) {
      if (value.equals(hold[a])) {
        ret = 1;
      }
    }
    return ret;
  }

}
