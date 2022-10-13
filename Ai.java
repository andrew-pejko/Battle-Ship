public class Ai extends Player {
  public String hide[][] = new String[10][10];
    public Ai(int a)
    {
      super(a);
    }

  public void genboard() {
    super.genboard();
  for (int x = 0; x < 10; x++) {
      for (int y = 0; y < 10; y++) {
      hide[x][y] = "O";
      }
      System.out.println();
    }
  }

  public int top(){
    int random = (int)Math.floor(Math.random() * 9 + 1);
    return random;
  }

  public String left(){
    int random = (int)Math.floor(Math.random() * 9 + 1);
    return letters[random];
  }

  public void shoot(String left, int top){
    super.shoot(left, top);
    
    int hit = 0;

    for (int x = 0; x < 10; x++) {
      for (int y = 0; y < 10; y++) {
      if(ships[x][y] == -1){
        hide[x][y] = "X";
        hit = 1;
        System.out.println("Shot 2");
      } 
      }
  }

  int left2 = 0;
  for (int z = 0; z < letters.length; z++){
    if(letters[z].equals(left)){
      left2 = z;
      System.out.println("Letter 2");
    }
  }

  if (hit == 0){
    hide[left2][top] = "-";
    System.out.println("Miss 2");
  }

  hit = 0;
  }
  
  public void printboard() {
    System.out.print("*" + "\t\t");
    for (int z = 0; z < 10; z++){
    System.out.print(z + "\t");
    }
    System.out.println();
    System.out.println("\t------------------------------------------");
    for (int x = 0; x < 10; x++) {
      System.out.print(letters[x] + "\t|\t");
      for (int y = 0; y < 10; y++) {
        System.out.print(hide[x][y] + "\t");
      }
      System.out.println();
    }
  }

  public static void clear(){
  System.out.print("\033[H\033[2J"); 
  System.out.flush(); 
  }
}