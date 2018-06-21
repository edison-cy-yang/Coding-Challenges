package dictionary;

import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;

public class Dictionary {
	TreeNode root;
	
	
	public Dictionary() {
		root = new TreeNode();
	}
	
	
	/**
	 * Insert a word into the dictionary
	 * @param word The word to be inserted into the dictionary
	 */
	public void insert(String word) {
		Map<Character, TreeNode> children = root.children;
		
		for(int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			
			
			TreeNode temp = null;
			if(children.containsKey(c)) {
				temp = children.get(c);
			}
			
			else {
				temp = new TreeNode(c, i + 1);
				children.put(c, temp);
			}
			
			children = temp.children;
			
			if(i == word.length() - 1) {
				temp.isWord = true;
			}
		}
	}
	
	
	/**
	 * Search the dictionary for this word
	 * @param word
	 * @return
	 */
	public boolean search(String word) {
		Map<Character, TreeNode> children = root.children; 
        TreeNode t = null;
        /**
         * For each iteration, check if the char is contained in the children map, if not then we can stop searching
         * if yes, keep going down the trie
         */
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(children.containsKey(c)){
                t = children.get(c);
                children = t.children;
            }else{
                t = null;
                break;
            }
        }
 
        if(t != null && t.isWord)  {
//        	System.out.println("depth: " + t.depth);
        	return true;
        }
            
        else {
            return false;
        }
    }
	
	
	/**
	 * 
	 * @param word
	 * @return
	 */
//	public boolean canBeWord(String word) {
//		Map<Character, TreeNode> children = root.children; 
//        TreeNode t = null;
//        /**
//         * For each iteration, check if the char is contained in the children map, if not then we can stop searching
//         * if yes, keep going down the trie
//         */
//        for(int i = 0; i < word.length(); i++){
//            char c = word.charAt(i);
//            if(children.containsKey(c)){
//                t = children.get(c);
//                children = t.children;
//            }else{
//                t = null;
//                break;
//            }
//        }
//        
//        if(t == null) {
//        	return false;
//        }
//        else {
//        	return true;
//        }
//	}
	
	
//	public static void main(String[] args) {
//		Dictionary dic = new Dictionary();
//		String  line = null;
//		try{
//			// open input stream test.txt for reading purpose.
//			BufferedReader br = new BufferedReader(new FileReader("/Users/chengyuyang/Desktop/Coding Challenges/Ghost Game/src/dictionary/WORD.LST.txt"));
//			while ((line = br.readLine()) != null) {
////				System.out.println(thisLine);
//				dic.insert(line);
//			}       
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//		
////		System.out.println(dic.search("abioses"));
////		System.out.println(dic.search("abcdefg"));
//		System.out.println(dic.search("aahed"));
//		
//	}
}
