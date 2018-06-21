package dictionary;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class Ghost {
	
	Dictionary dic;
	String currentWord;
	TreeNode currentNode;
	boolean gameOver = false;
	
	
	public Ghost() {
		currentWord = "";
		dic = new Dictionary();
		String  line = null;
		try{
			// open input stream test.txt for reading purpose.
			BufferedReader br = new BufferedReader(new FileReader("/Users/chengyuyang/Desktop/Coding Challenges/Ghost Game/src/dictionary/WORD.LST.txt"));
			while ((line = br.readLine()) != null) {
				// insert each word into the dictionary
				dic.insert(line);
			}       
		}catch(Exception e) {
			e.printStackTrace();
		}
		// start the game's current node at the root of the dictionary
		currentNode = dic.root;
	}
	
	
	/**
	 * User's move
	 * @param c User's choice of letter
	 * @return  true if letter can be added (valid word and not game over), false if letter cannot be added
	 */
	public boolean userMove(char c) {
		if(!currentNode.children.containsKey(c)) {
			System.out.println(currentWord + c + " cannot be part of a word, you lost");
			return false;
		}
		else {
			currentWord = currentWord + c;
			currentNode = currentNode.children.get(c); //Update the current node if the letter can be found
			if(currentNode.isWord && currentNode.depth > 4) {
				System.out.println("this is a word, you lost");
				return false;
			}
			System.out.println("current word: " + currentWord);
			return true;
		}
	}
	
	
	/**
	 * 
	 * @param node the current node the ghost game is on, ghost.currentNode
	 * @return the list of optimal nodes the computer can take
	 */
	public ArrayList<TreeNode> getOptimalMoves(TreeNode node) {
		
		// Initialize the potential node
		TreeNode potentialNode = null;
		
		ArrayList<TreeNode> optimalNodes = new ArrayList<TreeNode>();
			

		for (TreeNode computersMoves : node.children.values()) { //all possible choices of letter computer can choose{
			if (!computersMoves.children.isEmpty()) {
				potentialNode = computersMoves;
				for (TreeNode usersMoves : computersMoves.children.values()) {
					/**
					 * Two cases that we can un-mark the potential node (these wont be optimal nodes):
					 * 1. the grandChild (user's potential nodes) is not a leaf node (want to make them leaf nodes)
					 * 2. Keep recursion, if no optimal nodes are returned, that means there are no optimal nodes for 
					 * 	  computer's next next move,
					 */
					if (!usersMoves.children.isEmpty() && getOptimalMoves(usersMoves) == null) {
						potentialNode = null;
						break;
					}
				}
			}
			
			// Add the potential node to the list of optimal nodes
			if (potentialNode != null) {
				if(!optimalNodes.contains(potentialNode))
					optimalNodes.add(potentialNode);
			}
				
		}

		return optimalNodes;
	}

	
	/**
	 * 
	 * @param node ghost.currentNode
	 * @return
	 */
	public TreeNode longestWord(TreeNode node) {
		TreeNode longestChild = null;

		for (TreeNode child : node.children.values()) {
			/**
			 * -if longestChild is null, then initialize child to be the longest child
			 * -if maximum length of the child is greater than the maximum length of the longest child,
			 *  then update longestChild to be child
			 */
			if (longestChild == null || (maxLength(child) > maxLength(longestChild))) {
				longestChild = child;
			}
		}
		return longestChild;
	}
	  
	
	/**
	 * 
	 * @param n the node to calculate the length from 
	 * @return the maximum possible length starting from node n
	 */
	public int maxLength(TreeNode n) {
		int length = 0;
		int maxLength = 0;

		for (TreeNode node : n.children.values())
		{
			length = maxLength(node);
			maxLength = Math.max(maxLength, length);
		}
		// max length of child node + 1
		return maxLength + 1;
	}
	
	
	/**
	 * Randomly choose a letter(node) from the list of possible winning letters
	 */
	private void computerMove() {
		
		ArrayList<TreeNode> winningChildren = getOptimalMoves(currentNode);
		
		System.out.print("Computer's possible choices: ");
		for(TreeNode node: winningChildren) {
			System.out.print(node.c + ", ");
		}
		System.out.println();
		
		
		// Choose a random node from the list of possible computer nodes
		if(winningChildren.size() > 0) {
			int i = (int)(Math.random() * winningChildren.size());  
			currentNode = winningChildren.get(i); 
		}
		
		// If no optimal nodes are found (computer would lose), then proceed with the node that has the longest routes
		else {
			currentNode = longestWord(currentNode);
		}
		
		currentWord = currentWord + currentNode.c;
		System.out.println("computer's move: " + currentNode.c + ", currentWord: " + currentWord); 
		
		if(currentNode.isWord && currentNode.depth > 4) {
			System.out.println("Computer lost, you won");
			return;
		}		
	}
	

	public static void main(String[] args) {
		
		//Create a new ghost game
		Ghost ghost = new Ghost();
		
		Scanner scn = new Scanner(System.in);

		while(!ghost.gameOver) {
			char input;
			System.out.print("Please enter a letter: ");
			input = scn.next().charAt(0);
			
			// if the letter user entered can be added 
			if(ghost.userMove(input)) { 
				System.out.println("User chose: " + input + ", current word: " + ghost.currentWord);
				ghost.computerMove();
			}
			// if the letter user entered cannot be added, then game is over
			else {
				ghost.gameOver = true;
			}			
		}
		return;
	}



}
