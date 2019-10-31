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

car class:

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

plane class:

    public class plane implements Vehicle{
        int num_of_wheels;
        int num_of_passengers;
 
        public int set_num_of_wheels(){
            num_of_wheels = 12;
            return num_of_wheels;
        }
        public int set_num_of_passengers(){
            num_of_passengers=300;
            return num_of_passengers;
        }
        public boolean has_gas(){
            return true;
        }
    }
    
This design has some problems considering international conventions of coding , a setter method should not return anything and should have parameter/s or argument/s that the method was supposed to set their value into preferred variables. On the contrary a the style of the methods mentioned to have a setter method should be getter methods because they do return values after finishing a certain action.

b) Use a different design pattern for this solution.

Answer:

Here is the solution with the conventional getter setter,

car class:

    public class car implements Vehicle{
        int num_of_wheels;
        int num_of_passengers;
        boolean gas_availability;
        
        public int get_num_of_wheels(){
            return num_of_wheels;
        }
 
        public set_num_of_wheels(int num_of_wheels){
            this.num_of_wheels = num_of_wheels;
        }
        
        public int get_num_of_passengers(){
            return num_of_passengers;
        }
        
        public set_num_of_passengers(int num_of_passengers){
            this.num_of_passengers = num_of_passengers;
        }
        
        public boolean has_gas(){
            return true;
        }
    }

plane class:

    public class Plane implements Vehicle{
            int num_of_wheels;
            int num_of_passengers;
            boolean gas_availability;

            public int get_num_of_wheels(){
                return num_of_wheels;
            }

            public set_num_of_wheels(int num_of_wheels){
                this.num_of_wheels = num_of_wheels;
            }

            public int get_num_of_passengers(){
                return num_of_passengers;
            }

            public set_num_of_passengers(int num_of_passengers){
                this.num_of_passengers = num_of_passengers;
            }

            public boolean has_gas(){
                return true;
            }
        }



3.Write a video player application with ‘Play’, ‘Forward’ , ‘Rewind’ functionalities. Please write pseudocode for this program and explain the design pattern you will use to develop these three functionalities.

Answer:

I have written a small application which allows the user to browse through the default file manager and where the user selects and plays a certain video and it also allows the user to forward and rewind the video. The psuedo code is provided below:

    public class MainActivity extends AppCompatActivity {
        Declare Global variable videoFileIntent, buttonVideoSelect, uri, videoView;
   
        Override protected void onCreate(Bundle savedInstanceState) method {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            Initialize videoFileIntent, buttonVideoSelect, uri, videoView;

            Call setButtonVideoSelect() Method to set the button's on click listener;

            // Set MediaController  to enable play, pause, forward, etc options.
            Initialize mediaController = new MediaController ;
            Connect mediaController with the Videoview with setAnchorView method; 
            Connect videoView with mediaController with setMediaController method;
        }


        public void checkUriAndPlay() {
            if (uri is not null) {
                Assign video URI to the videoView with setVideoURI method;
                Request Focus for videoView;
                Start the video;
            }
        }

        public void setButtonVideoSelect() {
            Define buttonVideoSelect.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) method {
                    Initialize videoFileIntent = new Intent(Intent.ACTION_GET_CONTENT);
                    Set the formats that we want to see with videoFileIntent.setType("video/mp4");
                    Send data to the onActivityResult method by startActivityForResult(videoFileIntent,10);
                }
            });
        }

        @Override
        protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
            switch (requestCode) {
                case 10:
                    if (resultCode is checked okay) {
                        Get Data for the uri, uri = data.getData();
                        Call checkUriAndPlay() method to take the data and assign it to the videoview to play video;
                    }
                    break;
            }
        }
    }


