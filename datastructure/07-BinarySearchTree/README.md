# Binary Search Tree  

##  sudo code

```java
// Tree.java
public class Tree {
  TreeNode topNode
  public void add (int key, Object value);
  public Object get (int key); // top node 의 값을 반환
}
```
```java
//TreeNode.java
public class TreeNode {
   public TreeNode (int key, Object value);
   public Object find (int key);
   public void add (int key, Object value);
   private int selectSubNode (int key);
   private object findSub (int node, int key);
   private void SubNode (int node, int key, Object value);
}
  
// SubNode => add => selectSubNode
// findSub => find => selectSubnode
```
