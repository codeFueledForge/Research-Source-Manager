package sourcedatatypes;
import java.util.List;
import java.util.Scanner;
import java.util.Iterator;
import java.util.LinkedList;

public class Title {

	public final char delimeter = 0xF1; //Unit separator character
	private String title;

	public Title(String title){
		
	}
	
	public void setTitle(String title){
		
	}
	
	public String getTitle(){
		return "";
	}
	
	
	public boolean contains(){
		return false;
	}
	
	
	//Gross, works for now;
	/**
	 * 
	 * @param title
	 * @return an array of substrings of words: a word is delimited by any non-digit or letter
	 */
	public static String[] parseTitle(String title){
		Scanner scanner = new Scanner(title);
		List<String> firstPassList = new LinkedList<String>();
		List<String> secondPassList = new LinkedList<String>();
		
		while(scanner.hasNext()){
			firstPassList.add(scanner.next());
		}
		
		
		//Removes all non-characters from words and adds the front half to the list.
		boolean wordSubstringed = false;
		int substringFrontIndex = 0;
		//Loop through each word
		for(String word: firstPassList){
			//Check each character
			for(int i = 0; i < word.length(); i++){
				//If it is not a letter
				if(!isCharacterInRange(word.charAt(i))){
					//DEBUG: System.out.println(word + ": " + i + ": " + word.charAt(i));
					//split the word at this point and add the front portion of the string to the list;
					//set the split point to after the non letter character
					wordSubstringed = true;
					if(substringFrontIndex != i)
						secondPassList.add(word.substring(substringFrontIndex, i));
					substringFrontIndex = i+1;
				}
			}
			//make sure the final word is added to the list
			if(wordSubstringed){
				//DEBUG: System.out.println("substringed: " + word);
				if(substringFrontIndex < word.length()){
					secondPassList.add(word.substring(substringFrontIndex, word.length()));
				}
				substringFrontIndex = 0;
				wordSubstringed = false;
			}else{
				secondPassList.add(word);
			}
		}
		
		scanner.close();

		String[] result = new String[secondPassList.size()];

		Iterator words = secondPassList.iterator();
		for(int i = 0; i < secondPassList.size(); i++){
			result[i] = (String) words.next();
		}
		
		return result;

	}
	
	public static boolean isCharacterInRange(char c){
		if(0x30 > c || c > 0x7A){//outer bounds of characters (Digits and upper and lowercase letters)
			return false;
		}else{
			if((0x39 < c && c < 0x41)||(0x5A < c && c < 0x61)){//bounds of other punctuation between the digits and the uppercase letters
				return false;
			}else{
				return true;
			}
		}
	}
	
	
}
