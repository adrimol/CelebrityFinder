# CelebrityFinder
In a team of n people, a celebrity is known by everyone but he/she doesn't know anybody.

Having a list of people names, each team member in the very first column of every line followed by the name of people of the team who knows, 
find the celebrity (if exists) between them.

To run and test the project:

1. Download / clone repository
2. Open command line and go to your project folder
3. mvn clean install
4. Run project (set your sample file location in arguments):
mvn exec:java -Dexec.mainClass="adrimol.CelebrityFinder" -Dexec.args="D:\\\\Globant\\\\Challenges\\\\CelebrityFinder//Team1.txt"


Sample file (Team1.txt)
You can save next lines in a text file or create yours:
"James Caroline Amanda Charlie
Caroline Amanda 
Charlie Cesar Amanda Adrian
Amanda Brandon Charles
Brad Yolima Charles Amanda"
