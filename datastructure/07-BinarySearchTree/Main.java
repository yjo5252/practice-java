public class Main {
  public static void main (String[] args){
    Tree TM = new Tree();
    TM.add(10, "cho");
    TM.add(20, "KIM");
    TM.add(30, "minho");
    TM.add(40, "JYeon");

    // (1)
    System.out.println('Data Search and Get... ');
    Object Temp = TM.get(20);
    System.out.println(Temp);

    // (2)
    System.out.println('Data Search and Get... ');
    Object Temp = TM.get(40);
    System.out.println(Temp);
  }
}