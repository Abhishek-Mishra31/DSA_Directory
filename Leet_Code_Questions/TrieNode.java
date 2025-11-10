package Leet_Code_Questions;

public class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isEnd = false;
    int childCount = 0;

    class Trie {
        TrieNode root = new TrieNode();

        public void insert(String word) {
            TrieNode current = root;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (current.children[index] == null) {
                    current.children[index] = new TrieNode();
                    current.childCount++;
                }
                current = current.children[index];
            }
            current.isEnd = true;
        }

        public String findLongestCommonPrefix() {
            StringBuilder prefix = new StringBuilder();
            TrieNode current = root;

            while (current != null && current.childCount == 1 && !current.isEnd) {
                for (int i = 0; i < 26; i++) {
                    if (current.children[i] != null) {
                        prefix.append((char) (i + 'a'));
                        current = current.children[i];
                        break;
                    }
                }
            }

            return prefix.toString();
        }
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        Trie trie = new Trie();

        for (String word : strs) {
            trie.insert(word);
        }

        return trie.findLongestCommonPrefix();
    }


    public static void main(String[] args) {

    }

}