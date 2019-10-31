# BongoBD Written Test


1.Write a function that detects if two strings are anagram e.g. ‘bleat’ and ‘table’ are anagrams but ‘eat’ and ‘tar’ are not.

Answer: 

This function returns a 'true' value when the two strings are anagrams and returns a 'false' value when they are not anagrams.

    public static boolean detectAnagram(String s1, String s2){
        char [] ch1 = s1.toCharArray();
        char [] ch2 = s2.toCharArray();
        int matchCount = 0;
        for(int i = 0; i < ch1.length; i++){
            for(int j = 0; j < ch2.length; j++){
                if(ch1[i]==ch2[j]){
                    ch1[i]='#';
                    ch2[j]='#';
                    matchCount++;
                    break;
                }
            }
        }
        if(matchCount==ch1.length){
            return true;
        } else {
            return false;
        }
    }
 
 2.Explain the design pattern used in following:
 
    interface Vehicle {
        int set_num_of_wheels()
        int set_num_of_passengers()
        boolean has_gas()
    }
  
a) Explain how you can use the pattern to create car and plane class?

Answer: 

I can implement the interface on the car and plane class where I have to add the key word "implements" after the class name.
e.g. public class car implements Vehicle(){}. Since its an interface I have to implement all the methods inside Vehicle inside both car and plane.
    
    public class car implements Vehicle{
        int num_of_wheels;
        int num_of_passengers;
 
        public int set_num_of_wheels(){
            num_of_wheels = 4;
            return num_of_wheels;
        }
        public int set_num_of_passengers(){
            num_of_passengers=4;
            return num_of_passengers;
        }
        public boolean has_gas(){
            return true;
        }
    }
    
    public class plane implements Vehicle{
        int num_of_wheels;
        int num_of_passengers;
 
        public int set_num_of_wheels(){
            num_of_wheels = 4;
            return num_of_wheels;
        }
        public int set_num_of_passengers(){
            num_of_passengers=4;
            return num_of_passengers;
        }
        public boolean has_gas(){
            return true;
        }
    }
    
This design has some problems considering international conventions of coding , a setter method should not return anything and should have parameter/s or argument/s that the method was supposed to set their value into preferred variables. On the contrary a the style of the methods mentioned to have a setter method should be getter methods because they do return values after finishing a certain action.

b) Use a different design pattern for this solution.

Answer: 

We can use abstract class design where the properties given for a generalized entity will be stored in an abstract class, which we will extend and build our car and plane class.

3.Write a video player application with ‘Play’, ‘Forward’ , ‘Rewind’ functionalities. Please write pseudocode for this program and explain the design pattern you will use to develop these three functionalities.

Answer:


