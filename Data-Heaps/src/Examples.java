import org.junit.Test;
import static org.junit.Assert.*;

import static org.junit.Assert.assertTrue;

public class Examples {

    public Examples(){}
    HeapChecker HT = new HeapChecker();
    HeapChecker HT2 = new HeapChecker();
    
    IHeap heap1 = new DataHeap(5, new DataHeap(15), new DataHeap(16));
    IHeap heap2 = new DataHeap(4,new DataHeap(19), new DataHeap(23));
    IHeap heap15 = heap1.addElt(12);
    IHeap heap25 = heap2.addElt(30);
    IHeap heap35 = heap1.remMinElt(); 
    
    IHeap heap1Order = new DataHeap(9, new DataHeap(21), new MtHeap());
    IHeap heap3 = new DataHeap(32, new DataHeap(40), new DataHeap(200));
    IHeap heap4 = new DataHeap(1, heap3, new DataHeap(300));
    IHeap heap5Test = new DataHeap(32,new DataHeap(40),new DataHeap(200));
    
    IHeap heap6Test = heap5Test.addElt(300);
    IHeap heap6 = new DataHeap(2, new MtHeap(), new DataHeap(7));
    IHeap notHeap6 = new DataHeap(9, new DataHeap(3), new DataHeap(2));
    
    IHeap remHeap7 = new DataHeap(7, new DataHeap(9), new DataHeap(20));
    IHeap remHeap8 = new DataHeap(7, new MtHeap(), new DataHeap(20));
    
    IHeap emptyHeap = new DataHeap(0, new MtHeap(), new MtHeap());
    IHeap wrongOrderAdd1 = new DataHeap(30, new DataHeap(30), new DataHeap(9));
    
    IBinTree treeCompare1 = heap1.addElt(12);
    IBinTree treeCompare2 = heap2.addElt(30);
    IBinTree treeCompareMt = new MtHeap().addElt(9);
    IBinTree wrongOrderTreeCompare1 = heap1Order.addElt(30);
    
    IBinTree treeCompare3 = heap6.remMinElt();
    IBinTree treeCompareTestFor5 = heap1.remMinElt();
    IBinTree treeCompare4 = emptyHeap.remMinElt();
    IBinTree remTreeCompare1 = remHeap7.remMinElt();
    
    
 
  
// tests if the heap is the correct one, should return False
    @Test 
    public void invalidHeapTest(){
        assertFalse(HT.addEltTester(heap15,12,treeCompare1));
    }
 // tests if the heap is the correct one, should return True
    @Test 
    public void validHeapTest(){
        assertFalse(HT.addEltTester(heap15,12,treeCompare1));
    }
    
    @Test 
    //tests if the elt is invalid, should return false
    public void invalidEltHeapTest(){
        assertFalse(HT.addEltTester(heap2,4,treeCompare2));
    }
   
    @Test 
    //tests if the elt is valid, should return True
    public void validEltHeapTest(){
        assertTrue(HT.addEltTester(heap2,30,treeCompare2));
    }
    // tests if the method accepts a non valid heap, should return false
    @Test 
    public void invalidHeapTest2(){
        assertFalse(HT.addEltTester(wrongOrderAdd1,30,wrongOrderTreeCompare1));
    }
    @Test
    //tests adding to an empty heap 
    public void emptyHeapAdd(){
        assertTrue(HT.addEltTester(new MtHeap(),9,treeCompareMt));
    }
    @Test
    //not a heap, so should be false
    public void notHeapTest(){
        assertFalse(HT.addEltTester(notHeap6,0,treeCompare1));
    }
    
    
    @Test
    //not a heap, so should be false
    public void notHeapTest2(){
        assertFalse(HT.remMinEltTester(notHeap6,treeCompare1));
    }
    @Test
    //test to remove, produces right answer, thus should be true
    public void remTrue(){
        assertTrue(HT2.remMinEltTester(heap35,treeCompareTestFor5));
    }
    @Test 
    //test to remove, produces wrong answer, thus should be false
    public void remFalse(){
        assertFalse(HT2.remMinEltTester(heap3,treeCompare3));
    }
    @Test 
    //test to remove an empty heap, result should be empty heap, thus should be true
    public void remEmpty(){
        assertTrue(HT2.remMinEltTester(new MtHeap(),treeCompare4));
    }
    @Test 
    //tests remove wrong amount of times elt
    public void remWrongEltTest(){
        assertFalse(HT2.remMinEltTester(remHeap8,remTreeCompare1));
    }
    
 
	 
	 
}
