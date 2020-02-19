public class Tree {
  TreeNode topNode = null;
  public void add (int key, Object value){
    if (topNode == null)
      topNode = new topNode(key, value);
    else
      topNode.add(key, value);
  }
  public Object get (int key){
    return topNode == null ? null : topNode : find(key)
  }
}