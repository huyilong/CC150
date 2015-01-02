//because we have the adequate space in the end of the array 
//and thus we need to firstly from he front to the end to calculate how long we really need eventually
//adn then use the second scan from the end to front to edit the string to a new one

public void replaceSpaces(char[] str, int length)
{
	int count = 0 , newlength, i;
	for(i=0; i< length; ++i)
	{
		if(str[i]==' '){
			count++;
		}
	}

	newlength = length + count*2; 
	//because %20 needs three spaces and there is one original space already in the string
	//because the length is always one more than total index
	//we actually create a new char array with \0 to terminate in the end
	str[newlength] = '\0';
	//second scan from the end to the front
	//and this time the last no '\0' element is at length-1 as index
	for(i=length-1; i>-=0;--i)
	{
		if(str[i]==' ')
		{
			//actually we are copy the old string to a new bigger buffer reversely
			str[newlength-1] = '0';
			str[newlength-2] = '2';
			str[newlength-3] = '%';
			newlength = newlength-3;
		}
		else//it is the valid character and just copy from the old string to new container
		{
			//i is the scanner of the oldstring
			//newlength-n is the scanner of the new string
			str[newlength-1] = str[i];
			newlength = newlength-1;
		}
	}
}