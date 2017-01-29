package sourcedatatypes;


public class Author implements Comparable<Author>{
	private static final String emptyName = "";
	private String firstName, secondName;
	
	Author(String firstName, String secondName){
		this.firstName = (firstName != null)?(firstName):(emptyName);
		this.secondName = (secondName != null)?(secondName):(emptyName);
	}

	/**
	 * @param otherAuthor Another author object is passed in to see if the two authors are the same
	 * 
	 * @return 1 if each name of the other author matches a name in this author, 0 if 1 is true, and there are no unmatched names in this author, -1 if otherAuthor contains a name this author does not have
	 * 
	 * Values returned greater than -1 will be considered a match
	 */
	public int compareTo(Author otherAuthor) {
		int compareResult = 0;
		
		if(otherAuthor.firstName != emptyName){
			if(!otherAuthor.firstName.equals(firstName)){
				return -1;
			}
		}else{
			compareResult = 1;
		}
		
		if(otherAuthor.secondName != emptyName){
			if(!otherAuthor.secondName.equals(secondName)){
				return -1;
			}
		}else{
			compareResult = 1;
		}
		
		return compareResult;
	}
	


}
