package BinartTree;

public class ConstructTreePreorderAndInorder {
    int i = 0;
    int p = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return construct(preorder, inorder, Integer.MIN_VALUE);
    }

    public TreeNode construct(int[] preorder, int[] inorder, int stop){
        if(p>=preorder.length){
            return null;
        }
        if(inorder[i]==stop){
            i++;
            return null;
        }
        TreeNode root = new TreeNode(preorder[p++]);
        root.left = construct(preorder, inorder, root.val);
        root.right = construct(preorder,inorder, stop);
        return root;
    }

    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        TreeNode tree = new ConstructTreePreorderAndInorder().buildTree(preorder, inorder);
        new ConstructTreePreorderAndInorder().printTree(tree);
    }

    public void printTree(TreeNode root){
        if(root==null)
            return;
        System.out.println(root.val);
        printTree(root.left);
        printTree(root.right);
    }
}
