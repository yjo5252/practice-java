public class TreeNode{
  private int itsKey;
  private Object itsValue;
  private TreeNode nodes[] = new TreeNode[2];
  public TreeNode (int key, Object Value) {
    itsKey = key;
    itsValue = value;
    System.out.println("start TreeMapNode");
  }

  public Object find(int key){
    if (key == itskey){
      return itsValue;
    }
    return findSub (select SubNode (key), key);
  private Object findSub (int node, int key){
    return nodes [node] == null? null: nodes[node].find(key);
  }
  private int selectSubNode(int key){
    return (key < itsKey)?0:1;
  }
  public void add(int key, Object Value){
    if (key == itsKey) itsValue = value;
    else SubNode (selectSubNode (key), key, value);
  }
  private void SubNode(int node, int key, Object value){
    if (nodes[node] == null)
        nodes[node] = new TreeNode(key, value);
    else
        nodes[node].add(key, value);
  }
}