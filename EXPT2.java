package currency;
import java.util.*;
import java.text.DecimalFormat;
public class currencyconvertor
{
double rupee,dollar,euro,yen;
Scanner sc=new Scanner(System.in);
DecimalFormat f=new DecimalFormat("##.###");
public void convertInrToEuro()
{
System.out.println("Enter amount in rupees");
rupee=sc.nextFloat();
euro=rupee/80;
System.out.println("Euro : "+f.format(euro));
}
public void convertEuroToInr()
{
System.out.println("Enter amount in Euro");
euro=sc.nextFloat();
rupee=euro*80;
System.out.println("Rupees :"+f.format(rupee));
}
public void convertInrToDollar()
{
System.out.println("Enter amount in rupees");
rupee=sc.nextFloat();
dollar=rupee/66;
System.out.println("Dollar:"+f.format(dollar));
}
public void convertDollarToInr()
{
System.out.println("Enter amount in Dollar");
dollar=sc.nextFloat();
rupee=dollar*66;
System.out.println("Rupees:"+f.format(rupee));
}
public void convertInrToYen()
{
System.out.println("Enter amount in rupees");
rupee=sc.nextFloat();
yen=rupee/0.61;
System.out.println("Yen :"+f.format(yen));
}
public void convertYenToInr()
{
System.out.println("Enter amount in Yen");
euro=sc.nextFloat();
rupee=yen*0.61;
System.out.println("Rupees: "+f.format(rupee));
}
}

package distance;
import java.util.*;
import java.text.DecimalFormat;
public class distanceconvertor
{
double meter,km,miles;
Scanner sc=new Scanner(System.in);
DecimalFormat f=new DecimalFormat("##.###");
public void convertMeterToKm()
{
System.out.println("Enter the meter");
meter=sc.nextFloat();
km=meter*0.001;
System.out.println("Kilometer:"+f.format(km));
}
public void convertKmToMeter()
{
System.out.println("Enter the kilometer");
km=sc.nextFloat();
meter=km/0.001;
System.out.println("Meter:"+f.format(meter));
}
public void convertMilesToKm()
{
System.out.println("Enter the miles");
miles=sc.nextFloat();
km=miles*1.6093;
System.out.println("Kilometer:"+f.format(km));
}
public void convertKmToMiles()
{
System.out.println("Enter the kilometer");
km=sc.nextFloat();
miles=km/1.6093;
System.out.println("Miles:"+f.format(miles));
}
}

package time;
import java.util.*;
import java.text.DecimalFormat;
public class timeconvertor
{
double hour,minute,second;
Scanner sc=new Scanner(System.in);
DecimalFormat f=new DecimalFormat("##.###");
public void convertHourToMinute()
{
System.out.println("Enter the Hour");
hour=sc.nextFloat();
minute=hour*60;
System.out.println("Minutes:"+f.format(minute));
}
public void convertMinuteToHour()
{
System.out.println("Enter the minute");
minute=sc.nextFloat();
hour=minute/60;
System.out.println("Hours: "+f.format(hour));
}
public void convertHourToSeconds()
{
System.out.println("Enter the Hour");
hour=sc.nextFloat();
second=hour*3600;
System.out.println("Seconds:"+f.format(second));
}
public void convertSecondsToHour()
{
System.out.println("Enter the seconds");
second=sc.nextFloat();
hour=second/3600;
System.out.println("Hours:"+f.format(hour));
}
}

import currency.*;
import distance.*;
import time.*;
import java.util.Scanner;
public class convertor
{
public static void main (String[] args)
{
int code,currency_code,distance_code,time_code;
Scanner sc=new Scanner(System.in);
currencyconvertor cc = new currencyconvertor();
distanceconvertor dc = new distanceconvertor();
timeconvertor tc = new timeconvertor(); 
System.out.println("Enter the code 1:Currency\n2:Distance\n3:Time");
code=sc.nextInt();
if(code==1)
{
System.out.println("Enter the Currency code 1:Euro\n2:Dollar\n3:Yen");
currency_code=sc.nextInt();
if(currency_code==1)
{
cc.convertInrToEuro();
cc.convertEuroToInr();
}
else if(currency_code==2)
{
cc.convertInrToDollar();
cc.convertDollarToInr();
}
else if(currency_code ==3)
{
cc.convertInrToYen();
cc.convertYenToInr();
}
else
{
System.out.println("Invalid Code");
}
}
else if(code==2)
{
System.out.println("Enter the distance code 1:Meter\n2:Miles");
distance_code=sc.nextInt();
if(distance_code==1)
{
dc.convertMeterToKm();
dc.convertKmToMeter();
}
else if(distance_code ==2)
{
dc.convertMilesToKm();
dc.convertKmToMiles();
}
else
{
System.out.println("invalid Code");
}
}
else if(code==3)
{
System.out.println("Enter the Time code 1:Minutes\n2:Seconds");
time_code=sc.nextInt();
if(time_code==1)
{
tc.convertHourToMinute();
tc.convertMinuteToHour();
}
else if(time_code==2)
{
tc.convertHourToSeconds();
tc.convertSecondsToHour();
}
else
{
System.out.println("Invalid code");
}
}
else
{
System.out.println("Invalid code");
}
sc.close();
}
}


OUTPUT:

Enter the code 1:Currency
2:Distance
3:Time
1
Enter the Currency code 1:Euro
2:Dollar
3:Yen
2
Enter amount in rupees
56
Dollar:0.848
Enter amount in Dollar
52
Rupees:3432

Enter the code 1:Currency
2:Distance
3:Time
2
Enter the distance code 1:Meter
2:Miles
1
Enter the meter
23
Kilometer:0.023
Enter the kilometer
56
Meter:56000


Enter the code 1:Currency
2:Distance
3:Time
3
Enter the Time code 1:Minutes
2:Seconds
1
Enter the Hour
56
Minutes:3360
Enter the minute
485
Hours: 8.083