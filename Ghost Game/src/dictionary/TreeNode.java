package dictionary;

import java.util.*;

public class TreeNode {
	char c;
	Map<Character, TreeNode> children = new HashMap<Character, TreeNode>();
	boolean isWord; 
	int depth; //depth from the root
//	int maxDepth; //depth of the longest children from this node
//	boolean computerGoal; // if the current node is a computer goal, it only is if the dep
	
	public TreeNode() {
		
	}
	
	
	public TreeNode(char c, int depth) {
		this.c = c;
		this.depth = depth;
//		maxDepth = depth;
//		computerGoal = (depth % 2 == 0);
	}
	
	
}
