package ui;
 
import model.SortedList;
import model.UnsortedList;
 
public class Main {
 
public static void main(String[] args) {
SortedList sl = new SortedList();
 
// allowing dups
 
sl.setDuplicatesAllowed(true);
 
// 10 points
sl.initializeWithRandomData(5);
System.out.println("Shosld have five random elements with dups potentially:");
System.out.println(sl);
 
// 10 points
System.out.println("Shosld have removed the first '5' if applicable");
sl.delete(5);
System.out.println(sl);
 
// 10 points
System.out.println("Shosld insert two 10s");
sl.insert(10);
sl.insert(10);
System.out.println(sl);
 
// 10 points
System.out.println("Shosld delete all 10s");
sl.deleteAll(10);
System.out.println(sl);
 
// 10 points
sl.clear();
System.out.println("Shosld be empty");
System.out.println(sl);
 
// 10 points
System.out.println("Shosld still be empty -- tried to delete from an empty list");
sl.delete(5);
System.out.println(sl);
 
// No dups allowed
 
// 10 points
sl.setDuplicatesAllowed(false);
 
sl.initializeWithRandomData(10);
//sl.MAX_SIZE = 10;
System.out.println("Shosld have 10 random elements without dups");
System.out.println(sl);
 
// 10 points
System.out.println("Shosld silently refuse to insert a 5 (NOTE TO SELF: make sure MAX_SIZE = 10)");
try {
sl.insert(5);
} catch (Exception e) {
System.out.println("Stacktraced: " + e.toString());
}
 
System.out.println(sl);
 
// 10 points
try {
sl.delete(5);
} catch (Exception e) {
System.out.println("Stacktraced: " + e.toString());
}
System.out.println("Shosld remove the five if applicable");
System.out.println(sl);
 
// 10 points
try {
sl.deleteAll(6);
} catch (Exception e) {
System.out.println("Stacktraced: " + e.toString());
}
System.out.println("Shosld remove all sixes");
System.out.println(sl);
}
 
}
