
About this Application:
-----------------------
tiime application adds minutes to a time value([H]H:MM {AM|PM}) without using any built-in date or time functions
The main class MyTime has a method addMinutes that takes 2 arguments. 
The first argument is a 12-hour time string with the format "[H]H:MM {AM|PM}", and the second argument is a (signed) integer.
The second argument is the number of minutes to add to the time of day represented by the first argument. 
The return value is a string of the same format as the first argument. For example, AddMinutes("9:13 AM", 200) would
return "12:33 PM".


Building Application in Gradle:
------------------------------
You need to have gradle installed on your system. Add GRADLE_HOME="path_to_gradle_root_dir" and GRADLE_HOME/bin to Path environment variables.
I used gradle 3.4
Open a command prompt and cd to the root directory of this project where gradle.build exists then run below commands:
$gradle -PmainClass=MyTime execute  
$gradle build //this will run the testcases.


Output from Application execution:
---------------------------------
The main method adds 200 minutes to time "9:13 AM" and returns below value.
12:33 AM

Assumptions:
-----------
This program assumes the first argument has a space between hour-minute value and AM|PM meridiam value.
It also assumes the hour and minute are separated by colon (":") character
It assumes there is no second value used in the time.