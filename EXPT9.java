import java.util.*;
public class ArrayListExample
{
public static void main(String args[])
{
ArrayList<String> obj1=new ArrayList<String>();
obj1.add("Ajeet");
obj1.add("Harry");
obj1.add("Chaitanya");
obj1.add("Steve");
obj1.add("Anuj");
System.out.println("\nCurrently the array list obj1 has following elements:"+obj1);
obj1.add("Babu");
obj1.add("Kamal");
ArrayList<String> obj2=new ArrayList<String>();
obj2.add("Alice");
obj2.add("Bob");
obj2.add("Raj");
obj1.addAll(obj2);
System.out.println("\nArray List obj1 after add All:"+obj1);
obj1.add(0,"Rahul");
obj1.add(1,"Justin");
System.out.println("\nArrayList obj1 after add element at the given index:"+obj1);
System.out.println("\nEnter the Search element");
Scanner input=new Scanner(System.in);
String search=input.nextLine();
System.out.println("\nArray List obj1 contains the string "+search+":"+obj1.contains(search));
obj1.remove("Chaitanya");
obj1.remove("Harry");
System.out.println("\nCurrent array list of obj1 after removing element is:"+obj1);
obj1.remove(1);
System.out.println("\nCurrent array list of obj1 after removing element through index is:"+obj1);
System.out.println("\nEnter the letter to display all the string start with given letter:");
search=input.nextLine();
ArrayList<String>obj3=new ArrayList<String>();
for(int i=0;i<obj1.size();i++)
{
if(obj1.get(i).startsWith(search.toUpperCase()))
{
obj3.add(obj1.get(i));
}
}
if(obj3.size()>0)
{
System.out.println("\nArrayList obj1 contains all the string start with given"+search+":"+obj3);
}
else
{
System.out.println("\nNO Name start with "+search+"letter int ArrayList obj1");
}
}
}
