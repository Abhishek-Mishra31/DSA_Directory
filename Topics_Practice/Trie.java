package Topics_Practice;

public class Trie {
    Trie[] childrenArray;
    Boolean flag;

    public Trie() {
        flag = false;
        childrenArray = new Trie[26];
    }

    public void insert(Trie root, String value) {
        Trie current = root;

        for (char c : value.toCharArray()) {
            if (current.childrenArray[c - 'a'] == null) {
                Trie newNode = new Trie();
                current.childrenArray[c - 'a'] = newNode;
            }

            current = current.childrenArray[c - 'a'];
        }

        current.flag = true;
    }


    public boolean searchPrefix(Trie root, String prefix) {

        Trie current = root;
        int count = 0;

        for (char c : prefix.toCharArray()) {
            if (current.childrenArray[c - 'a'] == null){
                return false;
            }

            current = current.childrenArray[c - 'a'];
        }


       current.flag = true;
       return true;
    }


    public boolean startsWith( String prefix){
        Trie current = this;

        for(char c : prefix.toCharArray()){
            if(current.childrenArray[c - 'a'] == null){
                return false;
            }
            current = current.childrenArray[c - 'a'];
        }

        return true;
    }

    public String findLongestPrefix(Trie node,  String prefix){
        Trie current = node;
        StringBuilder result = new StringBuilder(26);

        for(char c : prefix.toCharArray()){
            if(current.childrenArray[c - 'a'] == null){
                 break;
            }

            result.append(c);
            current = current.childrenArray[c - 'a'];
        }

        return result.toString();
    }


    public static void main(String[] args) {
        Trie root = new Trie();
        root.insert(root, "abhishek");
        root.insert(root, "abhijeet");
        root.insert(root, "akash");
        root.insert(root, "aditya");
        root.insert(root , "app");


        System.out.println(root.searchPrefix(root, "ab"));
        System.out.println(root.startsWith("abh"));
        System.out.println(root.findLongestPrefix(root , "application"));
        System.out.println(root.findLongestPrefix(root , "abhishekak"));

    }
}
