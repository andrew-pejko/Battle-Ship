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

 //constructor currently just holding a test value
  public Player(int i) {
    test = i;
  }

  public void shoot (String left, int top){

  int left2 = 0;

  for (int z = 0; z < letters.length; z++){
    if(letters[z].equals(left)){
      left2 = z;
      System.out.println("Letter");
    }
  }

  if(ships[left2][top] > 0){
    ships[left2][top] = -1;
    System.out.println("Shot");
    } else{
      ships[left2][top] = -2;
      System.out.println("Miss");
    }

    for (int k = 0; k < 10; k++) {
      for (int l = 0; l < 10; l++) {
        if(ships[k][l] == -1){
      show[k][l] = "X";
        } else if(ships[k][l] == -2){
          show[k][l] = "-";
        }
      }
      System.out.println();
    }
    
  }
 
  //just prints out the board pretty self explanitory
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
  //might not comment cause even I don't know whats going on
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