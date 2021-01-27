import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Q403 {
    private Map<Integer, HashSet<Integer>> hops = new HashMap<Integer, HashSet<Integer>>();
    private Set<Integer> stoneLocations = new HashSet<Integer>();
    
    public boolean canCross(int[] stones) {
    	for(int i = 0; i < stones.length; i++) {
    		stoneLocations.add(stones[i]);
    	}
        return crossing(stones, 1, 1);
    }
    private boolean crossing(int[] stones, int stone, int k) {
    	if (hops.containsKey(stone) && hops.get(stone).contains(k)) {
    		return false;
    	} else if (!stoneLocations.contains(stone)) {
    		return false;
    	} else if (stone > stones[stones.length-1]) {
    		return false;
    	} else if (stone == stones[stones.length-1]) {
    		return true;
    	} else {
    		if (hops.containsKey(stone)) {
    			HashSet<Integer> previous = hops.get(stone);
        		previous.add(k);
        		hops.put(stone, previous);
    		} else {
    			HashSet<Integer> previous = new HashSet<Integer>();
        		previous.add(k);
        		hops.put(stone, previous);
    		}
    		if (k - 1 == 0) {
    			return crossing(stones, stone + k + 1, k + 1) || crossing(stones, stone + k, k);
    		}
    		return crossing(stones, stone + k + 1, k + 1) || crossing(stones, stone + k, k) ||
    				crossing(stones, stone + k - 1, k - 1);
    	}
    }
}
