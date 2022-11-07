

public class HeapChecker {
	boolean addEltTester(IHeap hOrig, int elt, IBinTree hAdded) {
	    if(hOrig.size() == 0){
	        if(hAdded.size() == 1 && (hAdded.hasElt(elt))){
	            return true ;
	        }
	    }
	    if(hAdded.heapHuh()) {
	        if(hOrig.hasOrigAdd(hOrig, elt, hAdded)) {
	            return true;
	        }
	        return false;
	    }
	    return false;
	}
	
	
	  boolean remMinEltTester(IHeap hOrig, IBinTree hRemoved) {
		  if(hOrig.size() == 0){
		        if(hRemoved.size() == 1 ){
		            return true ;
		        }
		    }
		  if(hRemoved.heapHuh()) {
				if(hOrig.hasOrigRem(hOrig, hRemoved)) {
					return true;
				}
				return false;
			}
			return false;
	    }
}


