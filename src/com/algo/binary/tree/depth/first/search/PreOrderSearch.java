package com.algo.binary.tree.depth.first.search;

import java.util.Arrays;
import java.util.List;

import com.algo.binary.tree.BinaryTree;
import com.algo.binary.tree.Node;

/**
 * This class is going to show how to traverse a tree in depth first + Pre order traversal method
 * 
 * Pre Order traversal steps are as follows
 * 
 * 1. Read the current node
 * 2. Read the left node
 * 3. Read the right node
 * 
 * This is also known as DLR method as D -> Data, L -> Left, R -> Right
 * @author prabhuddha.bhashitha
 *
 */
public class PreOrderSearch {
	
	public static void main(String[] args) {
		List<Integer> valArr = Arrays.asList(7, 3, 4, 5, 10, 1,12,0);
		BinaryTree bt = new BinaryTree();
		for (int val : valArr) {
			bt.add(val);
		}
		traverseTree(bt.getRoot());
	}

	private static void traverseTree(Node node) {
		System.out.println(node.getValue());
		if(node.getLeft()!=null) {
			traverseTree(node.getLeft());
		}
		if(node.getRight()!=null) {
			traverseTree(node.getRight());
		}
		// TODO Auto-generated method stub
		
	}

}
