import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;
public class DataHeap extends DataBT implements IHeap {
	IHeap left;
	IHeap right;
	DataHeap(int data, IHeap left, IHeap right) {
		super (data, left, right);
		this.left = left;
		this.right = right;
	}
	// an alternate constructor for when both subheaps are empty
	DataHeap(int data) {
		super(data);
		this.left = new MtHeap();
		this.right = new MtHeap();
	}

	public IHeap merge(IHeap withHeap) {
		int newRoot;
		IHeap H1, H2, H3;
		// make sure withHeap isn't empty
		// we'd rather not use instanceOf here, but it makes the merge algorithm easier 
		//to see
		if (withHeap instanceof MtHeap) { return this; }
		// determine the new root value and the three subtrees to consider merging
		else if (withHeap.isBigger(this.data)) {
			newRoot = this.data;
			H1 = this.left;
			H2 = this.right;
			H3 = withHeap;
		} else {
			// Since a MtHeap will always return true on isBigger, satisfying
			//  the first condition, we know that withHeap is a DataHeap.
			//  Therefore, we can cast it.
			newRoot = ((DataHeap) withHeap).data;
			H1 = ((DataHeap) withHeap).left;
			H2 = ((DataHeap) withHeap).right;
			H3 = this;
		}

		// choose which trees to merge and construct the new tree
		if (H1.height() > H2.height() && H1.height() > H3.height()) {
			return new DataHeap (newRoot, H1, H2.merge (H3));
		} else if (H2.height() > H1.height() && H2.height() > H3.height()) {
			return new DataHeap (newRoot, H2, H1.merge (H3));
		} else if (H3.height() > H1.height() && H3.height() > H2.height()){
			return new DataHeap (newRoot, H3, H1.merge (H2));
		} else {
			// If the two bigger heaps are of the same size, choose one at random.
			Random coinFlip = new Random();
			if (H1.height() == H2.height()) {
				if (coinFlip.nextInt() % 2 == 1) {
					return new DataHeap (newRoot, H1, H2.merge(H3));
				} else {
					return new DataHeap (newRoot, H2, H1.merge(H3));
				}
			} else if (H2.height() == H3.height()) {
				if (coinFlip.nextInt() % 2 == 1) {
					return new DataHeap (newRoot, H2, H3.merge(H1));
				} else {
					return new DataHeap (newRoot, H3, H2.merge(H1));
				}
			} else {
				if (coinFlip.nextInt() %2 == 1) {
					return new DataHeap (newRoot, H3, H1.merge(H2));
				} else {
					return new DataHeap (newRoot, H1, H3.merge(H2));
				}
			}
		}
	}
	@Override
	public IHeap addElt(int e) {
		return this.merge(new DataHeap(e, new MtHeap(), new MtHeap()));
	}
	@Override
	public IHeap remMinElt() {
		return this.right.merge(this.left);
	}
	@Override
	public boolean isBigger(int e) {
		return (this.data >= e);
	}
	/**
	 * Checks if heap is a heap or not.
	 * @param  
	 * @return  boolean whether it is true or false
	 */
	public boolean heapHuh() {
		  // if the tree is empty, it is a valid heap
        if ((this.left.size() == 0) & (this.right.size() == 0)){
            return true;
        }
        // if the base of the tree is bigger than the base of either branch it is not a valid tree
        if (right.isBigger(this.data)){
            return false ;
        }
        if (left.isBigger(this.data)){
            return false ;
        }
        else {
            return (left.heapHuh()) && (right.heapHuh()) ;
        }

    }

	/**
	 * Checks if the original heap is the same along with removed element in the heap
	 * @param  an IHeap and IBinTree as a heap 
	 * @return  boolean whether it is true or false
	 */
	public Boolean hasOrigRem(IHeap hOrig, IBinTree hRemoved) {
		LinkedList<Integer> List1 = new LinkedList<>();
		LinkedList<Integer> List2 = new LinkedList<>();
		List1 = hOrig.intoList();
		List2 = hRemoved.intoList();
		Collections.sort(List1);
		Collections.sort(List2);
		for(int i = 0; i <List1.size()-1; i++) {
			if (List1.get(i)!= List2.get(i)) {
				return false;
			}
		}
		return true;

	/**
	 * Checks if the original heap is the same along with  added element in the heap
	 * @param  an IHeap and IBinTree as a heap, int elt as the element to add into the heap
	 * @return  boolean whether it is true or false
	 */

	}

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