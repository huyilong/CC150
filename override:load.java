//overriding is the same name and the same signature to override the abstract function in base class
Overriding methods is completely different from overloading methods. 
If a derived class requires a different definition for an inherited method, 
then that method can be redefined in the derived class. This would be considered 
overriding. An overridden method would have the exact same method name, return type, 
number of parameters, and types of parameters as the method in the parent class, 
and the only difference would be the definition of the method.

//overloading is just the same name but not the same signature to offer different function for calling
Method overloading in Java occurs when two or more methods in the same class have the 
exact same name but different parameters (remember that method parameters accept values 
	passed into the method). Now, two or more methods with the same name in the same 
class sounds simple enough to understand.

//
//compiler error - can't overload based on the   
//type returned -
//(one method returns int, the other returns a float):    

int changeDate(int Year) ;  
float changeDate (int Year);    

//compiler error - can't overload by changing just 
//the name of the parameter (from Year to Month):    

int changeDate(int Year);   
int changeDate(int Month) ;  
 
//valid case of overloading, since the methods
//have different number of parameters:        

int changeDate(int Year, int Month) ;  
int changeDate(int Year);    

//also a valid case of overloading, since the   
//parameters are of different types:    

int changeDate(float Year) ;  
int changeDate(int Year);  