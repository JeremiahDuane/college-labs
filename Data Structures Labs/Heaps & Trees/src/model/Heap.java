package model;

import javax.xml.crypto.NodeSetData;

public class Heap<T extends Comparable<T>> {
	@SuppressWarnings("unused")
	private T value;
	private Node<T> root;
	private int cIP = 1;

	private char[] getIndex(int pIndexOf) {
		return Integer.toBinaryString(pIndexOf).toCharArray();
	}

	private Node<T> getNode(int index) {
		char[] map = getIndex(index);
		Node<T> temp = root;
		for (int i = 1; i < map.length; i++) {
			if (map[i] == '0') {
				temp = temp.getLeftChild();
			} else {
				temp = temp.getRightChild();
			}
		}
		return temp;
	}

	public Node<T> getParentPosition() {
		Node<T> t = root;
		char[] b = getIndex(cIP);
		for (int n = 1; n < b.length - 1; n++) {
			if (b[n] == '0') {
				t = t.getLeftChild();
			}
			if (b[n] == '1') {
				t = t.getRightChild();
			}

		}
		return t;
	}

	public void insert(T pValueToInsert) {
		insertNode(new Node<T>(pValueToInsert));

	}

	public void insertNode(Node<T> pNode) {
		if (root == null) {
			root = pNode;
		} else {
			Node<T> t = getParentPosition();
			if (t.getLeftChild() == null) {
				t.setLeftChild(pNode);
				pNode.setParent(t);
				trickleUp(t.getLeftChild());

			} else if (t.getRightChild() == null) {
				t.setRightChild(pNode);
				pNode.setParent(t);

				trickleUp(t.getRightChild());

			}
		}
		cIP++;

	}

	public void clear() {
		root = null;
		cIP = 1;

	}

	public T delete() {
		Node<T> fRoot;
		if (cIP == 2) {
			cIP = 1;
			root = null;
		}
		if (root != null) {
			cIP--;
			if (getParentPosition().getRightChild() != null) {
				swap(root, getParentPosition().getRightChild());
				fRoot = getParentPosition().getRightChild();
				getParentPosition().setRightChild(null);

			} else {
				swap(root, getParentPosition().getLeftChild());
				fRoot = getParentPosition().getLeftChild();
				getParentPosition().setLeftChild(null);

			}
			trickleDown(root);
			return fRoot.getValue();

		}
		return null;

	}

	public void swap(Node<T> node1, Node<T> node2) {
		if (node1 != null && node2 != null) {
			Pairing<T> p = (Pairing<T>) node1.getValue();
			node1.setValue(node2.getValue());
			node2.setValue((T) p);
		}

	}

	private void trickleDown(Node<T> pNode) {

		if (pNode.getRightChild() != null) {
			if (pNode.getLeftChild().getValue().compareTo(pNode.getRightChild().getValue()) < 0) {
				if (pNode.getRightChild().getValue().compareTo(pNode.getValue()) > 0) {
					swap(pNode, pNode.getRightChild());
					trickleDown(pNode.getRightChild());
				}
			} else {
				if (pNode.getLeftChild().getValue().compareTo(pNode.getValue()) > 0) {
					swap(pNode, pNode.getLeftChild());
					trickleDown(pNode.getLeftChild());

				}
			}
		} else if (pNode.getLeftChild() != null) {
			if (pNode.getLeftChild().getValue().compareTo(pNode.getValue()) > 0) {
				swap(pNode, pNode.getLeftChild());
				trickleDown(pNode.getLeftChild());

			}
		}
	}

	private void trickleUp(Node<T> pNode) {
		if (pNode.getParent() != null) {
			if (pNode.getParent().getValue().compareTo(pNode.getValue()) < 0) {
				swap(pNode, pNode.getParent());
				trickleUp(pNode.getParent());
			}
		}
	}

	// toString
	private StringBuilder sb = new StringBuilder();

	public String toString() {
		for (int i = 1; i <= cIP; i++) {
			if (getNode(i) == null) {

			} else {

				System.out.println(i + ": " + getNode(i));
			}
		}
		sb = new StringBuilder();
		sb.append(root);
		rTo(root);

		return "";
	}

	private void rTo(Node<T> pCurrentNode) {
		if (pCurrentNode != null) {
			if (pCurrentNode.getLeftChild() != null) {
				sb.append(pCurrentNode.getLeftChild().getValue());
				rTo(pCurrentNode.getLeftChild());

			}
			if (pCurrentNode.getRightChild() != null) {
				sb.append(pCurrentNode.getRightChild().getValue());
				rTo(pCurrentNode.getRightChild());
			}
		}
	}
}
