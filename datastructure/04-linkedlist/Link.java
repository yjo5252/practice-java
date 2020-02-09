//Link를 구성하는 클래스
public class Link{
  pulbic int data1;
  public double data2;
  public ink nextLink;
  //Link 생성자
  public Link (int d1, double d2){
    data1 = d1;
    data2 = d2;
  }
  //Link 데이터의 출력
  public void printLink(){
    System.out.println("("+data1+","+data2+")");
  }
}