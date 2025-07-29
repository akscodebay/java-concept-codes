package BinartTree;

public class InvertTree {
    public TreeNode invertTree(TreeNode root) {
        if(root==null){
            return root;
        }

        invertTree(root.left);
        invertTree(root.right);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;
    }

    public void printTree(TreeNode root){
        if(root==null)
            return;
        System.out.println(root.val);
        printTree(root.left);
        printTree(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        new InvertTree().invertTree(root);
        new InvertTree().printTree(root);
    }
}
