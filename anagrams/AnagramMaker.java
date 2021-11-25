package ua.com.foxminded.anagrams;

public class AnagramMaker { 
	
    private static final String SPACE_DELIMITER = " ";

    public String makeAnagram(String sentence) {
        validateSentence(sentence);

        String[] words = sentence.split(SPACE_DELIMITER);
        String[] reversedWords = new String[words.length];

        for (int i = 0; i < words.length; i++) {
            reversedWords[i] = reversedWord(words[i]);
        }
        return concat(reversedWords);
    }

    private void validateSentence(String sentence) {
        if (sentence == null) {
            throw new IllegalArgumentException("sentence is null");
        } 
        if(sentence.isEmpty()) {
            throw new IllegalArgumentException("sentence is empty");
        }
        if(sentence.trim().isEmpty()) {
            throw new IllegalArgumentException("sentence contains only whitespace");
        }

    }

    private String reversedWord(String word) {
    	char[] symbols = word.toCharArray();
    	int minIndex = 0;
    	int maxIndex = symbols.length - 1;
    	while(minIndex < maxIndex) {
    	    if(!Character.isLetter(symbols[minIndex]) && (!Character.isLetter(symbols[maxIndex]))) {
    		minIndex++;
        	maxIndex--;
    	    }
    	    else if(Character.isLetter(symbols[minIndex]) && (!Character.isLetter(symbols[maxIndex]))) {
    		maxIndex--;
    	    }
    	    else if(!Character.isLetter(symbols[minIndex]) && (Character.isLetter(symbols[maxIndex]))) {
    		minIndex++;
    		}
    	    else if(Character.isLetter(symbols[minIndex]) && (Character.isLetter(symbols[maxIndex]))) {
    	        swap(symbols, minIndex, maxIndex);
    		minIndex++;
    		maxIndex--;
    	    }
    			
    	}    		
    	return String.valueOf(symbols);    	
    }

    private String concat(String[] words) {
        return String.join(SPACE_DELIMITER, words); 	
    }
    
    private void swap(char[] symbols, int minIndex, int maxIndex) {
    	char buffer = symbols[minIndex];
    	symbols[minIndex] = symbols[maxIndex];
    	symbols[maxIndex] = buffer;
    }
    
}

