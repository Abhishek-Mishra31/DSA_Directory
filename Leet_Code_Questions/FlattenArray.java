package Leet_Code_Questions;

// _______________________ Question 114 ( Leetcode ) _________________________________________________________
public class FlattenArray {
    int val;
    FlattenArray left;
    FlattenArray right;

    FlattenArray() {
    }

    FlattenArray(int val) {
        this.val = val;
    }

    FlattenArray(int val, FlattenArray left, FlattenArray right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static void flatten(FlattenArray root) {
        if (root == null) {
            return;
        }

        FlattenArray current = root;
        while (current != null) {
            if (current.left != null) {
                FlattenArray temp = current.left;
                while(temp.right != null) {
                    temp = temp.right;
                }
                temp.right = current.right;
                current.right = current.left;
                current.left = null;
            }

            current = current.right;
        }
    }

    public static void getValues(FlattenArray root) {
        FlattenArray current = root;
        while (current != null) {
            System.out.println(current.val + " ");
            current = current.right;
        }
    }


    public static void main(String[] args) {
        FlattenArray node6 = new FlattenArray(6);
        FlattenArray node5 = new FlattenArray(4);
        FlattenArray node4 = new FlattenArray(3);
        FlattenArray node3 = new FlattenArray(5, null, node6);
        FlattenArray node2 = new FlattenArray(2, node4, node5);
        FlattenArray root = new FlattenArray(1, node2, node3);
        flatten(root);
        getValues(root);
    }
}
