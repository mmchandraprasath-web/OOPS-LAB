public class WrapperClassDemo
{
public static void main(String[] args)
{
int primitiveInt = 100;
float primitiveFloat = 25.75f;
char primitiveChar = 'A';
boolean primitiveBoolean = true;
Integer wrappedInt = primitiveInt;
Float wrappedFloat = primitiveFloat;
Character wrappedChar = primitiveChar;
Boolean wrappedBoolean = primitiveBoolean;
System.out.println("Autoboxed Integer:"+ wrappedInt);
System.out.println("Autoboxed Float:" + wrappedFloat);
System.out.println("Autoboxed Character :" + wrappedChar);
System.out.println("Autoboxed Boolean:" + wrappedBoolean);
int unboxedInt = wrappedInt;
float unboxedFloat = wrappedFloat;
char unboxedChar = wrappedChar;
boolean unboxedBoolean = wrappedBoolean;
System.out.println("Unboxed int:" + unboxedInt);
System.out.println("Unboxed float:" + unboxedFloat);
System.out.println("Unboxed char:" + unboxedChar);
System.out.println("Unboxed boolean:" + unboxedBoolean);
String intString = "300";
Integer parsedInt = Integer.parseInt(intString);
String floatString = "75.25";
Float parsedFloat = Float.parseFloat(floatString);
String charString ="C";
Character parsedChar = charString.charAt(0);
String booleanString = "true";
Boolean parsedBoolean = Boolean.parseBoolean(booleanString);
System.out.println("parsed and autoboxed Integer:" + parsedInt);
System.out.println("parsed and autoboxed Float:" + parsedFloat);
System.out.println("parsed and autoboxed Character:" + parsedChar);
System.out.println("parsed and autoboxed Boolean:" + parsedBoolean);
}
}

OUTPUT:

Autoboxed Integer:100
Autoboxed Float:25.75
Autoboxed Character :A
Autoboxed Boolean:true
Unboxed int:100
Unboxed float:25.75
Unboxed char:A
Unboxed boolean:true
parsed and autoboxed Integer:300
parsed and autoboxed Float:75.25
parsed and autoboxed Character:C
parsed and autoboxed Boolean:true