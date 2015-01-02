import java.io.*;
import java.util.*;
/*
if s2 = yx is a rotation of s1 = xy ,
then s2 must be the substring of s3 = s1+s1 = xyxy;
*/
public class StrRotation{

	//not necessary self-defined constructor :: no return type, must same name with class
	//public StrRotation(){}

	public static boolean isSubString(String str,String substr){

		if(str == null || substr == null)	
			return false;
		//using indexOf >=0 to check if a string is a substring of another
		if((str.indexOf(substr)) >= 0)	
			return true;
		else 
			return false;
			
	}

	public boolean isRotation(String s1, String s2)
	{
		int len = s1.length();
		//first condition: s1 and s2 are equal length and not empty
		//like a prune to check the most obvious condition
		if(len == s2.length() && len>0)
		{
			String s3 = s1 + s1;
			//this is not advisable because string is immutable
			//we create a new object and take up the extra storage space
			//stringbuffer is synchronized but stringbuilder is not for thread
			return isSubString(s3,s2);//parent is first and child is second
		}
		//if it did not go into the if at all then it does not meet the basic requirement
		return false;
	}

	//overload the function with different type :: static
	public static boolean static_isRotation(String s1, String s2)
	{
		int len = s1.length();
		//first condition: s1 and s2 are equal length and not empty
		//like a prune to check the most obvious condition
		if(len == s2.length() && len>0)
		{
			String s3 = s1 + s1;
			//this is not advisable because string is immutable
			//we create a new object and take up the extra storage space
			//stringbuffer is synchronized but stringbuilder is not for thread
			return isSubString(s3,s2);//parent is first and child is second
		}
		//if it did not go into the if at all then it does not meet the basic requirement
		return false;
	}


	public static void main(String[] args)
	{
		StrRotation test = new StrRotation();
		//using the default constructor offered by the compiler
		String s1 = "waterbottle";
		String s2 = "erbottlewat";
		String crack = "hah";
		//calling the non-static function with obj of the class -> test
		boolean result = test.isRotation(s1,s2);
		//calling the static function without obj
		//if this is in c++ then we also need a scoping operator to avoid compiler errors
		boolean static_result = static_isRotation(s1,crack);
		//warning: the static and non-static cannot differentiate the overriding of functions!

		System.out.println("Is s2 a rotation of s1 ? " + result);
		System.out.println("Is crack a rotation of s1 ? " + static_result);
	}
}