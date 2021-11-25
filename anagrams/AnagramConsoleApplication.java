package ua.com.foxminded.anagrams;
import java.util.Scanner;

public class AnagramConsoleApplication {

    public static void main(String[] args) {
    	
        Scanner scanner = new Scanner(System.in);
        
        String sentence = scanner.nextLine();

        AnagramMaker anagramMaker = new AnagramMaker();

	System.out.println(anagramMaker.makeAnagram(sentence));
		
    } 

}
