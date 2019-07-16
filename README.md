# Celebrities

Find a celebrity in a population. 

A celebrity is a person who is known by every one, but doesn't know anybody.
The population is modeled by an int's matrix, where each position represents if a person (row) knows other person (column).
For example, the next matrix represents a population where person in position 4 (in a zero based count) is the celebrity and person in position 0 knows everyone else.

1, 0, 0, 0, 1 <br/>
1, 0, 1, 0, 1 <br/>
1, 1, 0, 0, 1 <br/>
0, 1, 0, 0, 1 <br/>
0, 0, 0, 0, 1 <br/>


BUILD

Download or clone Git repo: https://github.com/pfrodriguezj/Celebrities.git
Import project as a maven project
Run Maven -> build with goals "clean compile assembly:single"


EXECUTION
Go to target directory where jar was generated and open a command line
Type java -jar celebrities-0.0.1-SNAPSHOT-jar-with-dependencies.jar <mode> <parameter>


First parameter <mode> can be only "CSV", "DB" or "RAND".
Second parameter is, respectively:  
	- CSV file path
	- Any name you want to assign to database table
	- population size
Parameters examples:
	* "CSV c:\\my_folder\\my_file.csv" (data are stored in a CSV file, whose path/name is the second parameter), 
	* "DB population" (data are stored in a in-memory database, second parameter is the table name )
	* "RAND 5" (data are generated randomly)
	
A CSV example file called "celebrities.csv" can be found inside the project.

That's all I made in 4 hours. ;)
	
