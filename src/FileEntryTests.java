import static org.junit.Assert.*;

import java.util.TreeSet;

import org.junit.Test;

/**
 * @author Starfox_desktop
 *
 */
public class FileEntryTests {

	//fields
	private FileEntry testEntry;
	private FileEntry anotherFileEntry;
	
	//constructors
	public FileEntryTests() {
		testEntry = new FileEntry("testFile");
		testEntry.setContents("18542");
	}
	
	//tests

	@Test
	public void testGetFilename(){
		assertEquals("testFile", testEntry.getFilename());
	}
	
	@Test
	public void testToString() {
		assertEquals(testEntry.toString(), "18542");
	}
	
	@Test
	public void testCompareTo() {
		TreeSet<FileEntry> files = new TreeSet<>();
		anotherFileEntry = new FileEntry("anotherFileName");
		anotherFileEntry.setContents("13213");
		testEntry.setContents("18542");
		files.add(anotherFileEntry);
		files.add(testEntry);
		//if the compareTo method works properly both files 
		//will be added to the treeSet because they are unique.
		assertEquals(2, (files.size()));
	}
	
}