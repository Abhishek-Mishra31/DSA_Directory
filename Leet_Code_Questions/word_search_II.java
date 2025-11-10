package Leet_Code_Questions;

import java.util.*;

class TrieNodeSearch {
    TrieNodeSearch[] children = new TrieNodeSearch[26];
    String word = null;
}

public class word_search_II {
    private TrieNodeSearch root = new TrieNodeSearch();
    private List<String> result = new ArrayList<>();

    private void insert(String word) {
        TrieNodeSearch current = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (current.children[index] == null) {
                current.children[index] = new TrieNodeSearch();
            }
            current = current.children[index];
        }
        current.word = word;
    }

    public List<String> findWords(char[][] board, String[] words) {

        for (String word : words) {
            insert(word);
        }

        int rows = board.length;
        int cols = board[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
               
            }
        }

        return result;
    }

}
