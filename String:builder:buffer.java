/*
String object is immutable whereas StringBuffer/StringBuilder objects are mutable.
String myString = “Hello”;
myString = myString + ” Guest”;
Although we made use of the same object(myString), internally a new object was created in the process.

To prove this,
String s = “Let’s test”;
s.concat(” if the String object is IMMUTABLE”);
System.out.println(s);
s = s.concat(” if the String object is IMMUTABLE”);
System.out.println(s);

The output of the above code will be:
Let’s test
Let’s test if the String object is IMMUTABLE
The above piece of code proves that String is immutable and hence the results of operations 
like concat etc. should be stored into a new object.
*/


/*
StringBuffer is synchronized( which means it is thread safe and hence you can use it when you implement 
threads for your methods) whereas StringBuilder is not synchronized( which implies it isn’t thread safe).

StringBuilder sb = new StringBuilder(“Hello”);
sb.append(” World”);
system.out.println(sb);

refer to the API  there are methods like reverse(), substring(), replace(), insert(), etc

*/

/*
import java.util.StringTokenizer;
 
public class App {
	public static void main(String[] args) {
 
		String str = "This is String , split by StringTokenizer, created by mkyong";
		StringTokenizer st = new StringTokenizer(str);
 
		System.out.println("---- Split by space ------");
		while (st.hasMoreElements()) {
			System.out.println(st.nextElement());
		}
 
		System.out.println("---- Split by comma ',' ------");
		StringTokenizer st2 = new StringTokenizer(str, ",");
 
		while (st2.hasMoreElements()) {
			System.out.println(st2.nextElement());
		}
	}
}
*/

/*

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
 
public class ReadFile {
 
	public static void main(String[] args) {
 
	BufferedReader br = null;
 
	try {
 
		String line;
 
		br = new BufferedReader(new FileReader("c:/test.csv"));
 
		while ((line = br.readLine()) != null) {
		   System.out.println(line);
 
		   StringTokenizer stringTokenizer = new StringTokenizer(line, "|");
 
		   while (stringTokenizer.hasMoreElements()) {
 
		    Integer id = Integer.parseInt(stringTokenizer.nextElement().toString());
		    Double price = Double.parseDouble(stringTokenizer.nextElement().toString());
		    String username = stringTokenizer.nextElement().toString();
 
			StringBuilder sb = new StringBuilder();
			sb.append("\nId : " + id);
			sb.append("\nPrice : " + price);
			sb.append("\nUsername : " + username);
			sb.append("\n*******************\n");
 
			System.out.println(sb.toString());
		   }
		}
 
		System.out.println("Done");
 
	} catch (IOException e) {
		e.printStackTrace();
	} finally {
		try {
			if (br != null)
				br.close();
 
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
 
	}
}
Output

1| 3.29| mkyong
 
Id : 1
Price : 3.29
Username :  mkyong
*******************
 
2| 4.345| eclipse
 
Id : 2
Price : 4.345
Username :  eclipse
*******************
 
Done

*/