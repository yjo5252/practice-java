//���� ����Ʈ�� ���� �����ϴ� Ŭ����
public class Linklist{
  private Link first;

  //link ������
  public LinkList(){
    first = null;
  }
  
  //��� �ִٸ�, null�� ��ȯ
  public boolean isEmpty (){
    return first == null;
  }

  //����Ʈ�� ù ��°�� ���ο� ����Ʈ ����
  pubilc void insert(int d1, double d2){
    Link link = new Link(d1,d2);
    link.nextLink = first;
    first = link;
  }

  //��Ʈ�� ù��° ���Ҹ� ����
  public Link delete(){
    Link temp = first;
    first = first.next;
    return temp;
  }

  //�������� ���
  public void printList(){
    Link currentLink = first;
    System.out.println("List: ");
    while (currentLink != null) {
      currentLink.printLink();
      currentLink = currentLink.nextLink;
    }
    Sytem.out.println("");
  }
}