//when we check with the string we may want to char[] arr = string.toCharArray()  or string.charAt()
//alse we could firstly sort the string or array when we get it 
//and we want to get uniform pattern of these word.toLowerCase(); to dump the excessive work


//when the problem is relatively easy then talking and discussing could be important
//talk with the interviewer with the corner conditions and self-careful
HashTable<String, Integer> go(String[] book)
{
	HashTable<String, Integer> table = new HashTable<String, Integer> ();
	//for(Object word: book)
	for (String word: book)
	{
		word = word.toLowerCase();
		//String.trim()
		//This method returns a copy of the string, with leading and trailing whitespace omitted.
		if(word.trim()!= "")
			//this is really important to think of the empty string with just useless space
			//so we need to call the word.trim() function
		{
			//firstly asssume it is not in the table 
			//then create a new entry
			if(!table.containsKey(word)){
				table.put(word, 0 );
			}

			//if it is already in the table then just 
			//read out the frequency and then increase it
			table.put(word, table.get(word) + 1);
		}
	}

	return table;
}

int run(HashTable<String,Integer> table, String word){
	if(table == null || word == null)  return -1;
	//useful as the trim() and toLowerCase()
	word = word.toLowerCase();
	if(table.containsKey(word)){
		return table.get(word);
	}
	return 0;
}