import java.util.LinkedList;

public interface IHeap extends IBinTree {
 // adds given element to the heap without removing other elements
 IHeap addElt(int e);
 
 // removes one occurrence of the smallest element from the heap
 IHeap remMinElt();
 
 // Merge the current heap with another heap
 IHeap merge(IHeap withHeap);
 
 // Determine if the root of this heap is bigger than the given element
 boolean isBigger(int e);
 
 public boolean heapHuh();
 // Turns heap into a list
 LinkedList<Integer>intoList();
 
 // sees if the original heap is there
 public Boolean hasOrigRem(IHeap hOrig, IBinTree hRemoved);
 
 //sees if the original heap is here
 
 public Boolean hasOrigAdd(IHeap hOrig, int elt,IBinTree hAdded); 

}



