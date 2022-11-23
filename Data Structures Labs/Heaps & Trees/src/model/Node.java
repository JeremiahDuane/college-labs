package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Node<T extends Comparable<T>> {
	private T value;
	private Node<T> leftChild;
	private Node<T> rightChild;
	private Node<T> parent;

	public Node(T pValue) {
		value = pValue;
	}
	public T getValue() {
		return value;
	}
	public void setValue(T value) {
		this.value = value;
	}
	public Node<T> getLeftChild() {
		return leftChild;
	}
	public void setLeftChild(Node<T> leftChild) {
		this.leftChild = leftChild;
	}
	public Node<T> getRightChild() {
		return rightChild;
	}
	public void setRightChild(Node<T> rightChild) {
		this.rightChild = rightChild;
	}
	public Node<T> getParent() {
		return parent;
	}
	public void setParent(Node<T> parent) {
		this.parent = parent;
	}
	
	public String toString() {
		return value.toString();
	   
	}
}
