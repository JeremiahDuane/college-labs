package ui;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import model.Listable;

public class Main {

	public static void main(String[] args) {
		Listable ul = new UnsortedList();
		ul.setDuplicatesAllowed(false);
		 ul.insert(1);
		 ul.insert(1);
		 ul.insert(2);
		 ul.insert(2);
		 ul.insert(3);
		 ul.insert(3);
		 ul.insert(4);
		 ul.insert(4);
		 System.out.println(ul);
		 ul.deleteAll(3);
		 ul.deleteAll(9);
		 System.out.println(ul);
		 ul.delete(1);
		 System.out.println(ul);
		 ul.insert(5);
		 System.out.println(ul);
		 ul.clear();
		 System.out.println(ul);
		 ul.insert(5);
		 System.out.println(ul);
		 System.out.println(ul.areDuplicatesAllowed());
		 System.out.println(ul.getSizeOfList());
		 System.out.println("ll");
		 System.out.println(ul);
		 System.out.println(ul.find(1));
		 
		 System.out.println("ll");
		 System.out.println(Arrays.toString(ul.findAll(4))); 
		 System.out.println(ul.find(9));
		 ul.insert(1);
		 ul.insert(1);
		 ul.insert(2);
		 ul.insert(2);
		 ul.insert(3);
		 ul.insert(3);
		 ul.insert(4);
		 ul.insert(4);
		 System.out.println(ul);
		 ul.deleteAll(3);
		 ul.deleteAll(9);
		 System.out.println(ul);
		 ul.delete(1);
		 System.out.println(ul);
		 ul.insert(5);
		 System.out.println(ul);
		 ul.clear();
		 System.out.println(ul);
		 ul.insert(5);
		 System.out.println(ul);
		 ul.areDuplicatesAllowed();
		 ul.getSizeOfList();
		 ul.find(1);
		 ul.findAll(4); 
		 ul.find(9);
		 System.out.println(ul.find(1));
		 System.out.println(Arrays.toString(ul.findAll(1)));
		 System.out.println(Arrays.toString(ul.findAll(2)));
		 System.out.println(Arrays.toString(ul.findAll(3)));
		 System.out.println(ul.find(3));
		 
	
	}

}