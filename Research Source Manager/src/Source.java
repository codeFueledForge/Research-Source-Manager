import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Source {
	public static final String DEFAULT_DELIMITER = ";";
	private static final char[] trimChars = {';', ':', '?', '!','\"','\'', '<', '>', ',','.'};
	private static final HashSet<Character> trimCharSet = initializeCharSet();
	
	//Instance Variables
	protected String[] authors;
	protected String []title;
	protected String[] subjects;
	protected String edition;
	protected String publisher;
	protected int yearOfPublication;
	protected SourceType sourceType;
	
	public Source(String[] authors, String title, String[] subjects, String edition, String publisher, int yearOfPublication, SourceType sourceType){
		this.authors = authors;
		this.title = parseTitle(title);
		this.subjects = subjects;
		this.edition = edition;
		this.publisher = publisher;
		this.yearOfPublication = yearOfPublication;
		this.sourceType = sourceType;
	}
	
	//Getters && Setters
	public String[] getAuthors(){
		return authors;
	}
	public void setAuthors(String[] authors) {
		this.authors = authors;
	}
	
	public String[] getTitle() {
		return this.title;
	}
	public void setTitle(String[] title) {
		this.title = title;
	}
	
	public String[] getSubjects() {
		return subjects;
	}
	public void setSubjects(String[] subjects) {
		this.subjects = subjects;
	}
	
	public String getEdition() {
		return edition;
	}
	public void setEdition(String edition) {
		this.edition = edition;
	}

	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	public int getYear() {
		return yearOfPublication;
	}
	public void setYear(int year) {
		this.yearOfPublication = year;
	}
	
	//Returns a string representing this object.
	public String toString(){
		StringBuilder output = new StringBuilder(100);
		
		//title
		for(String word: title)
			output.append(title + ", ");
		output.append(DEFAULT_DELIMITER);
		
		//edition
		if(edition != null){
			output.append(edition + DEFAULT_DELIMITER);
		}
		
		//Authors
		for(String author: authors)
			output.append(" "+ author + ", ");
		output.append(DEFAULT_DELIMITER);
		
		//Publication Date
		output.append(yearOfPublication + DEFAULT_DELIMITER);
		
		//Publisher
		output.append(yearOfPublication + DEFAULT_DELIMITER);
		
		//Source Type
		output.append(sourceType + DEFAULT_DELIMITER);
		
		//Subjects, delimited with comma space
		for(String subject : subjects)
			output.append(subject + ", ");
		output.append(DEFAULT_DELIMITER);
		
		return output.toString();
		
	}
	
	/**
	 * 
	 * @param title 
	 * @return an array of each space delimited word. Characters in the trimCharSet will be trimmed from the front and back of words
	 */
	public static String[] parseTitle(String title){
		ArrayList<String> titleList = new ArrayList<>(20);
		Scanner scan = new Scanner(title);
		scan.useDelimiter(" ");
		
		while(scan.hasNext()){
			titleList.add(trimPunctuation(scan.next()));
		}
		
		String[] titleArray = new String[titleList.size()];
		
		int index = 0;
		for(String titleWord: titleList){
			titleArray[index++] = titleWord;
		}
		
		return titleArray;
	}
	
	public static String trimPunctuation(String inString){
		int firstIndex = 0;
		int lastIndex = inString.length() - 1;
		
		while(trimCharSet.contains(inString.charAt(firstIndex))){
			firstIndex++;
		}
		while(trimCharSet.contains(inString.charAt(lastIndex))){
			lastIndex--;
		}
		
		return inString.substring(firstIndex, lastIndex + 1);
	}
	
	private static HashSet<Character> initializeCharSet(){
		HashSet<Character> trimCharSet = new HashSet<>();
		for(char charInSet: trimChars)
			trimCharSet.add(charInSet);
		
		return trimCharSet;
	}
	
	
	
}
