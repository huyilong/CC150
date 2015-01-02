public boolean go(String str){
	//ASC II has 128 different tokens
	//A is 65 and a is 97 
	//while 0 is 48
	if(str.length()>128)  return false;

	boolean[] char_set = new boolean[256];
	for (int i=0; i<str.length(); ++i ){
		int val = str.charAt(i);// we directly represent the char with int
		//and use that int to represent the index of the set
		//the value stored in that set is used as the indicater of usage
		if(char_set[val]){
			return false;
		}

		char_set[val] = true;
	}

	return true;
}