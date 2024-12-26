package com.algo.binary.tree.depth.first.search;

import java.util.Arrays;
import java.util.List;

import com.algo.binary.tree.BinaryTree;
import com.algo.binary.tree.Node;

/**
 * 
 * This class is going to show how to traverse a tree in depth first + In order traversal method
 * 
 * In Order traversal steps are as follows
 * 
 * 1. Read the left  node
 * 2. Read the current node
 * 3. Read the right node
 * 
 * This is also known as LDR method as  L -> Left, D -> Data, R -> Right
 * 
 * @author prabhuddha.bhashitha
 *
 */
public class InOrderSearch {
	
	public static void main(String[] args) {
		List<Integer> valArr = Arrays.asList(7, 3, 4, 5, 10, 1,12,0);
		BinaryTree bt = new BinaryTree();
		for (int val : valArr) {
			bt.add(val);
		}
		traverseTree(bt.getRoot());
	}

	private static void traverseTree(Node node) {
		if(node.getLeft()!=null) {
			traverseTree(node.getLeft());
		}
		System.out.println(node.getValue());
		if(node.getRight()!=null) {
			traverseTree(node.getRight());
		}
	}
}
