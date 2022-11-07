import java.util.LinkedList;

class MtBT implements IBinTree {
 MtBT(){}

 // returns false since empty tree has no elements
 public boolean hasElt(int e) {
  return false;
 }

 // returns 0 since empty tree has no elements
 public int size() {
  return 0;
 }

 // returns 0 since empty tree has no branches
 public int height() {
  return 0;
 }
 
 /**
	 * Empty Heaps are always heaps returns true
	 * @param 
	 * @return  boolean true
	 */
 //returns empty heap is a heap
 public boolean heapHuh() {
	 return true;
 }
 
 /**
	 * Turns empty heap into a new list.
	 * @param
	 * @return Result of empty list
	 */

@Override
public LinkedList<Integer> intoList() {
	 LinkedList<Integer> newList = new LinkedList<>();
	 return newList;
 }
}



