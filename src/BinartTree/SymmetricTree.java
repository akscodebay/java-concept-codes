package BinartTree;

public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return isMirrorTree(root.left, root.right);
    }

    public boolean isMirrorTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        if (p.val != q.val) {
            return false;
        }

        boolean left = isMirrorTree(p.left, q.right);
        boolean right = isMirrorTree(p.right, q.left);
        return left && right;
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(3);
        root2.right = new TreeNode(2);

        TreeNode root = new TreeNode(0);
        root.left = root1;
        root.right = root2;

        System.out.println(new SymmetricTree().isSymmetric(root));
    }
}
