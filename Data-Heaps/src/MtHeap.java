import java.util.Collections;
import java.util.LinkedList;

public class MtHeap extends MtBT implements IHeap {
 MtHeap(){}
 @Override
 // If you add an element to a MtHeap, you create a new DataHeap
 public IHeap addElt(int e) {
  return new DataHeap(e, new MtHeap(), new MtHeap());
 }
 @Override
 // The min element of an empty heap returns an empty heap.
 public IHeap remMinElt() {
  return new MtHeap();
 }
 
 @Override
 // An empty heap should always lose a competition for which root is smaller (for 
//the merge function)
 public boolean isBigger(int e) {
  return true;
 }
 @Override
 // An empty heap merged with another heap is the other heap (identity).
 public IHeap merge(IHeap withHeap) {
  return withHeap;
 }

 /**
	 * Empty Heaps are always heaps returns true
	 * @param 
	 * @return  boolean true
	 */
 public boolean heapHuh() {
	 return true;
	 
	 /**
		 * Checks if the original heap is the same along with removed element in the heap
		 * @param  an IHeap and IBinTree as a heap 
		 * @return  boolean whether it is true or false
		 */
 }
 public Boolean hasOrigRem(IHeap hOrig, IBinTree hRemoved) {
	 LinkedList<Integer> List1 = new LinkedList<>();
    	LinkedList<Integer> List2 = new LinkedList<>();
    	
    	List1 = hOrig.intoList();
    	List2 = hRemoved.intoList();
    	Collections.sort(List1);
		Collections.sort(List2);
		for(int i = 0; i <List1.size(); i++) {
			if (List1.get(i)!= List2.get(i)) {
				return false;
			}
		
		}
		return true;
    	
	 
 }
 /**
	 * Checks if the original heap is the same along with  added element in the heap
	 * @param  an IHeap and IBinTree as a heap, int elt as the element to add into the heap
	 * @return  boolean whether it is true or false
	 */
 
 public Boolean hasOrigAdd(IHeap hOrig, int elt,IBinTree hAdded) {
	 LinkedList<Integer> List1 = new LinkedList<>();
    	LinkedList<Integer> List2 = new LinkedList<>();
    	List1 = hOrig.intoList();
		List1.add(elt);
		List2 = hAdded.intoList();
		Collections.sort(List1);
		Collections.sort(List2);
		for(int i = 0; i <List1.size()-1; i++) {
			if (List1.get(i)!= List2.get(i)) {
				return false;
    	
	 
 }
		}
		 return true;
}


}