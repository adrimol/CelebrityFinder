package adrimol;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.function.Supplier;
import java.util.stream.Stream;

//Given a file with n lines, which every line has a person of the team followed by a list of persons knowed by him
// find the one that is a celebrity if: 
// 	A celebrity is known by everyone but he/she doesn't know anybody.
public class CelebrityFinder {
	
	//Main class
	public static void main(String[] args) {
		//String fName = "D:\\\\Globant\\\\Challenges\\\\CelebrityFinder//Team1.txt";
		String fName = args[0];
		// Method findCelebrity: Look for people who 
		String celebrity = findCelebrity(fName);
		System.out.println("Celebrity is "+celebrity);
	}
	
	//
    private static String findCelebrity(String fileName) {
        try {
        	//Get stream supplier for multiple operations
        	Supplier<Stream<String>> streamSupplier = () -> {
				try {
					return Files.lines(Paths.get(fileName));
				} catch (IOException ie) {
					ie.printStackTrace();
				}
				return null;
			};
				
			//Count number of registers
            System.out.println("Analyzing file with " + streamSupplier.get().count() +" lines...");
            Optional<String> names = streamSupplier.get().findFirst();
            
            List<String> line = Arrays.asList ( streamSupplier.get().findFirst().get().split(" ") ); 
            for(int i=0; i<line.size(); i++) {
        		//Look for name in every line
            	System.out.println("Check for celebrity : " + line.get(i));
            	if(find(line.get(i),streamSupplier))
            		return line.get(i);
        	}
            return "No one";
        } catch(Exception e) {
            e.printStackTrace();
            return "No one";
        }
    }
    
    public static boolean find(String name,Supplier<Stream<String>> streamSupplier){
    	Iterator iter = streamSupplier.get().iterator();
    	while(iter.hasNext()) {
            String element = (String)iter.next();
            if(!element.contains(name)) {
            	System.out.println(name+" discarded!");
            	return false;
            }            	
         }
		return true;
    }


}
