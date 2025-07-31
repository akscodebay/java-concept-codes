package BinartTree;

public class ConstructTreePostorderAndInorder {
    int i = 0;
    int p = 0;
    public TreeNode buildTree(int[] postorder, int[] inorder) {
        i = inorder.length-1;
        p = postorder.length -1;
        return construct(postorder, inorder, Integer.MIN_VALUE);
    }

    public TreeNode construct(int[] postorder, int[] inorder, int stop){
        if(p<0){
            return null;
        }
        if(inorder[i]==stop){
            i--;
            return null;
        }
        TreeNode root = new TreeNode(postorder[p--]);
        root.right = construct(postorder,inorder, root.val);
        root.left = construct(postorder, inorder, stop);
        return root;
    }

    public static void main(String[] args) {
        int[] postorder = {9,15,7,20,3};
        int[] inorder = {9,3,15,20,7};
        TreeNode tree = new ConstructTreePostorderAndInorder().buildTree(postorder, inorder);
        new ConstructTreePostorderAndInorder().printTree(tree);
    }

    public void printTree(TreeNode root){
        if(root==null)
            return;
        System.out.println(root.val);
        printTree(root.left);
        printTree(root.right);
    }
}
