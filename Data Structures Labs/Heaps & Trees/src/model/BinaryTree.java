package model;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree<T extends Comparable<T>> {
	private T value;
	private Node<T> root;

// Get Max Value
	private T maxValue;

	public T getMaxValue() {
		rGetMax(root);
		return maxValue;
	}

	private void rGetMax(Node<T> pNode) {
		if (root != null) {
			if (pNode.getRightChild() != null) {
				rGetMax(pNode.getRightChild());
			} else {
				maxValue = pNode.getValue();
			}
		}
	}

//Get Minimum Value
	private T minValue;

	public T getMinValue() {
		rGetMin(root);
		return minValue;
	}

	private void rGetMin(Node<T> pNode) {
		if (root != null) {
			if (pNode.getLeftChild() != null) {
				rGetMin(pNode.getLeftChild());
			} else {
				minValue = pNode.getValue();
			}
		}
	}

// Get Size
	public int getSize() {
		return getSize(root);
	}

	private int getSize(Node<T> fromNode) {
		if (fromNode == null) {
			return 0;
		} else {
			return getSize(fromNode.getLeftChild()) + 1 + getSize(fromNode.getRightChild());
		}
	}

// Clear
	public void clear() {
		root = null;
	}

// Insert
	public void insert(T pValueToInsert) {
		if (root == null) {
			root = new Node<T>(pValueToInsert);
		} else {
			insertNode(root, new Node<T>(pValueToInsert));
		}
	}

	public void insert(Node<T> pNodeToInsert) {
		insertNode(root, pNodeToInsert);
	}

	public Node<T> insertValue(Node<T> currentNode, T value) {
		if (currentNode == null) {
			currentNode = new Node<T>(value);
			return currentNode;
		}
		if (value.compareTo(currentNode.getValue()) < 0) {
			currentNode.setLeftChild(insertValue(currentNode.getLeftChild(), value));
			currentNode.getLeftChild().setParent(currentNode);
		} else if (value.compareTo(currentNode.getValue()) > 0) {
			currentNode.setRightChild(insertValue(currentNode.getRightChild(), value));
			currentNode.getRightChild().setParent(currentNode);

		} else {
			return currentNode;
		}
		return currentNode;
	}

	public void insertNode(Node<T> currentNode, Node<T> value) {
		if (value.getValue().compareTo(currentNode.getValue()) < 0) {
			if (currentNode.getLeftChild() == null) {
				currentNode.setLeftChild(value);
				value.setParent(currentNode);
			} else {
				insertNode(currentNode.getLeftChild(), value);
			}
		} else if (value.getValue().compareTo(currentNode.getValue()) >= 0) {
			if (currentNode.getRightChild() == null) {
				currentNode.setRightChild(value);
				value.setParent(currentNode);
			} else {
				insertNode(currentNode.getRightChild(), value);
			}

		}
	}

//Find
	public Node<T> find(T valueToFind) {
		rFind(valueToFind, root);
		return rNode;
	}

	private Node<T> rNode;

	private void rFind(T pVal, Node<T> pNode) {
		if (pNode != null) {
			if (pNode.getValue().compareTo(pVal) > 0) {
				rFind(pVal, pNode.getLeftChild());
			} else if (pNode.getValue().compareTo(pVal) < 0) {
				rFind(pVal, pNode.getRightChild());
			} else {
				rNode = pNode;
			}
		}
	}

//Delete
	public void delete(T pVal) {
		if (find(pVal) != null) {
			Node<T> toDel = find(pVal);
			Node<T> right = toDel.getRightChild();
			Node<T> left = toDel.getLeftChild();

			if (right != null) {
				if (toDel.getParent() != null) {
					if (toDel.getParent().getLeftChild() == toDel) {
						toDel.getParent().setLeftChild(right);
						insert(left);
					} else if (toDel.getParent().getRightChild() == toDel) {
						toDel.getParent().setRightChild(right);
					}
				}
			} else {
				if (toDel.getParent() != null) {
					if (toDel.getParent().getLeftChild() == toDel) {
						toDel.getParent().setLeftChild(left);
						insert(left.getValue());
					} else if (toDel.getParent().getRightChild() == toDel) {
						toDel.getParent().setRightChild(left);
					}
				}

			}
		}
	}

// Get Max Depth
	private int depth;

	public int getMaxDepth() {
		depth = 0;
		rDepth(root);
		return depth;
	}

	private void rDepth(Node<T> pVal) {
		boolean test = false;
		if (pVal != null) {
			if (pVal.getLeftChild() != null) {
				rDepth(pVal.getLeftChild());
				test = true;
			}
			if (pVal.getRightChild() != null) {
				rDepth(pVal.getRightChild());
				test = true;
			}
			if (test) {
				depth++;
			}
		}
	}

//toString
	private StringBuilder sb = new StringBuilder();

	public String toString() {
		sb = new StringBuilder();
		sb.append(root);
		rTo(root);

		return sb.toString();
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

//toString for graph
//	private String rTree() {
//		StringBuilder st = new StringBuilder();
//		int a, b, c, d, e, f, g, h, i, j, k, l, m, n, o;
//		String f1= "( )", f2= "( )", f3= "( )", f4= "( )", f5= "( )", f6= "( )", f7= "( )", f8= "( )", f9= "( )", f10= "( )", f11= "( )", f12= "( )", f13= "( )", f14= "( )", f15= "( )";
//		int z = 0;
//		while (z < sb.length() && z < 15) {
//			a = Integer.parseInt(sb.substring(z, ++z));
//			b = Integer.parseInt(sb.substring(z, ++z));
//			c = Integer.parseInt(sb.substring(z, ++z));
//			d = Integer.parseInt(sb.substring(z, ++z));
//			e = Integer.parseInt(sb.substring(z, ++z));
//			f = Integer.parseInt(sb.substring(z, ++z));
//			g = Integer.parseInt(sb.substring(z, ++z));
//			h = Integer.parseInt(sb.substring(z, ++z));
//			i = Integer.parseInt(sb.substring(z, ++z));
//			j = Integer.parseInt(sb.substring(z, ++z));
//			k = Integer.parseInt(sb.substring(z, ++z));
//			l = Integer.parseInt(sb.substring(z, ++z));
//			m = Integer.parseInt(sb.substring(z, ++z));
//			n = Integer.parseInt(sb.substring(z, ++z));
//			o = Integer.parseInt(sb.substring(z, ++z));
//			
//			f1 = "(" + a + ")";
//			if (b < a) {
//			f2 = "(" + b + ")";
//			} else {
//			f3 = "(" + b + ")";
//			f2 = "(_)";
//			}
//		}
//		
//
//		return st.toString();
//	}
}
