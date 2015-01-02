//the following without StringBuffer could only be used 
//if the string is really be "compressed", if the new string is longer than the original one
//this will not work

//because the problem requires that if the compressed string is longer than the original one
//then we return the original one instead

public String compreeBad(String str)
{
	String mystr = "";
	char last = str.charAt(0);
	int count = 1;
	for(int i=1; i<str.length();++i)
	{
		if(str.charAt(i) == last)
		{
			count++;
		}else{
			mystr + = last + "" + count;
			//when update the var use +=
			last = str.charAt(i);
			//we must reset the count every time
			count = 1;
		}
	}

	//do not forget that go through the iteration yourself
	//because we did not add the very last part of the string
	return mystr + last + count;
}

/////////////////////////////////////////////////////////////////
String compreesBetter(String str)
{
	//check if the compression will result in a longer string
	int size = countCompression(str);
	if(size >= str.length()){
		return str;//return the original str instead
	}

	StringBuffer mystr =new StringBuffer();
	//this is thread-safe and could be synchronized
	char last = str.charAt(0);
	int count =1;
	for(int i=1; i< str.length; ++i){
		if(str.charAt(i) == last){
			++count;
		}else{
			mystr.append(last);//insert the distinguished char
			mystr.appedn(count);
			//move to the next different char
			last = str.charAt(i);
			count = 1;//reset the count
		}
	}

	//really need to be careful at last to update the string
	mystr.append(str);
	mystr.append(count);

	return mystr.toString();
}

int countCompression(String str){
	//null is no string at all
	//isEmpty() is that the length of the string is 0
	if(str==null || str.isEmpty())
		return 0;
	/*
	The empty string is a string with zero length. The null value is not having a string at all.

	The expression s == null will return false if s is an empty string.
	The second version will throw a NullPointerException if the string is null.
	Here's a table showing the differences:

+-------+-----------+----------------------+
| s     | s == null | s.isEmpty()          |
+-------+-----------+----------------------+
| null  | true      | NullPointerException |
| ""    | false     | true                 |
| "foo" | false     | false                |
+-------+-----------+----------------------+

*/
	char last = str.charAt(0);
	int size = 0;
	int count =1;
	for(int i=1; i<str.length(); i++){
		if(str.charAt(i) == last){
			count++;
		}else{
			last = str.charAt(i);
			//could be 10,11,12.....not necessary is decimal
			//String.valueOf(count).length()
			size+ = 1+ String.valueOf(count).length();
			/*
			valueOf(boolean b): Returns the string representation of the boolean argument.

			valueOf(char c): Returns the string representation of the char argument.

			valueOf(char[] data): Returns the string representation of the char array argument.

			valueOf(char[] data, int offset, int count): Returns the string representation of a specific subarray of the char array argument.

			valueOf(double d): Returns the string representation of the double argument.

			valueOf(float f): Returns the string representation of the float argument.

			valueOf(int i): Returns the string representation of the int argument.

			valueOf(long l): Returns the string representation of the long argument.

			valueOf(Object obj): Returns the string representation of the Object argument.

			commana+A and then using tab to all move right
			*/
			count =1;
		}
	}
	//similarly we need to take care of the last part of the string
	size+ = 1+String.valueOf(count).length();
	return size;
}