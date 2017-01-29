package sourceformats;
import sourcedatatypes.*;
import java.util.List;


public interface Source{

	//Returns an array of Strings representing Authors
	List getAuthors();
	void setAuthors(Author[] authors);
	boolean addAuthor(Author author);
	
	
	Title getTitle();
	void setTitle(Title title);
	boolean titleContains();
	
	PublicationData getPublicationData();
	void setPublicationData(PublicationData data);
	
	List getSubjectList();
	void setSubjectList();
	boolean addSubjectToList(Subject subject);
	
	
	
	
}
