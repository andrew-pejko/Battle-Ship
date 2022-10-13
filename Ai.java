//sub class used to change a few methods
class Ai extends Player{

//useless constructor
  public Ai(int a){
    super(a);
  }

  //modified print board to show board as hidden and not reveal ship locations
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
        if(show[x][y].equals("☐")){
          System.out.print("O\t");
        }else{
        System.out.print(show[x][y] + "\t");
        }
      }
      System.out.println();
    }
  }
}
