import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q127 {
	public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
		if (!wordList.contains(endWord)) {
			return 0;
		}
		int adjacency [] [] = new int [wordList.size()][wordList.size()];
        for(int i = 0; i < wordList.size(); i++) {
        	for (int j = 0; j < wordList.size(); j++) {
        		String word1 = wordList.get(i);
        		String word2 = wordList.get(j);
        		if (word1.equals(word2)) {
        			adjacency[i][j] = 0;
        		} else if (oneDifference(word1, word2)) {
        			adjacency[i][j] = 1;
        			adjacency[j][i] = 1;
        		} else {
        			adjacency[i][j] = 0;
        			adjacency[j][i] = 0;
        		}
        	}
        }
        List<Integer> queue = new ArrayList<Integer>();
        for(int i = 0; i < wordList.size(); i ++) {
        	if (oneDifference(beginWord, wordList.get(i))) {
        		queue.add(i);
        	}
        }
        int [] distances = new int [wordList.size()];
        Arrays.fill(distances, 0);
        while(!queue.isEmpty()) {
        	String currentWord = wordList.get(queue.get(0));
        	int index = queue.get(0);
        	// System.out.println(queue.toString());
        	// System.out.println(index);
        	if (currentWord.equals(endWord)) {
        		break;
        	}

        	for(int i = 0; i < wordList.size(); i++) {
        		// System.out.print(adjacency[index][i]);
        		if (adjacency[index][i] == 1 && distances[i] == 0) {
        			distances[i] = distances[index] + 1;
        			queue.add(i);
        		} else if (adjacency[index][i] == 1 && distances[i] > distances[index] + 1) {
        			distances[i] = distances[index] + 1;
        			queue.add(i);
        		} 
        	}
        	// System.out.println();
        	queue.remove(0);
        	
        }
        /*
        System.out.println();
        for(int i = 0; i < wordList.size(); i++) {
        	for (int j = 0; j < wordList.size(); j++) {
        		System.out.print(adjacency[i][j]);
        	}
        	System.out.println();
        } */
        if (wordList.contains(beginWord) && distances[wordList.indexOf(endWord)] <= 1) {
        	return distances[wordList.indexOf(endWord)] == 0 ? 0 : distances[wordList.indexOf(endWord)] + 1;
        }
        return distances[wordList.indexOf(endWord)] == 0 ? 0 : distances[wordList.indexOf(endWord)] + 2;
        
    }
	public static boolean oneDifference(String word1, String word2) {
		int count = 0;
		for(int i = 0; i < word1.length(); i ++) {
			if (word1.charAt(i) != word2.charAt(i)) {
				count ++;
			}
		}
		return count <= 1;
	}
	public static void main(String[]args) {
		List<String> words = new ArrayList<String>();
		words.add("hot");
		words.add("dot");
		words.add("dog");
		words.add("lot");
		words.add("log");
		words.add("cog");
		System.out.println(ladderLength("hit", "cog", words));
	}
}
