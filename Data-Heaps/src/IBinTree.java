

import java.util.LinkedList;
public interface IBinTree {
 // determines whether element is in the tree
 boolean hasElt(int e);
 // returns number of nodes in the tree; counts duplicate elements as separate 
//items
 int size();
 // returns depth of longest branch in the tree
 int height();
 
 // check if it is a heap
 boolean heapHuh();

 // turns heap into a list
 LinkedList<Integer>intoList();
 
}

