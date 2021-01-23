import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Q295 {
	List<Integer> temp = new ArrayList<Integer>();
	
	 /** initialize your data structure here. */
    public Q295() {
        this.temp.clear();
    }
    
    public void addNum(int num) {
        this.temp.add(num);
    }
    
    public double findMedian() {
        Collections.sort(this.temp);
        return findMedian(this.temp);
    }
    
    private double findMedian(List<Integer> a){
    	if(a.size()%2 == 0) {
    		return (a.get(a.size()/2) + a.get(a.size()/2 + 1))/2;
    	} else {
    		return (a.get(a.size()/2 + 1));
    	}
    }
}
/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
