package main;

public class TreeNode {
	private int val;
	private TreeNode left;
	private TreeNode right;
	
	public TreeNode(int val) {
		this.val = val;
	}
	
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) { //both node null
            return true;
        }
        if(p == null ^ q == null) { //one node null, one node not null
            return false;
        }
        else { // both nodes not null
                return (p.val == q.val) && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }
}
