import static org.junit.Assert.*;

import java.util.TreeSet;

import org.junit.BeforeClass;
import org.junit.Test;

public class FileSystemTests {
	
	//fields
	FileSystem fs = new FileSystem();
	String data = "Hello, Git!";

	public void setUp() {
		fs.writeFileContents("file1.txt", data);
	}
	
	public void tearDown() {
		fs.clear();
	}
	
	@Test
	public void testReadFile() {
		setUp();
		assertEquals(fs.readFileContents("file1.txt"), data);
		tearDown();
	}
	
	@Test
	public void testDeleteFile() {
		setUp();
		fs.deleteFile("file1.txt");
		assertEquals ((fs.getNumberOfFiles()), 0);
		fs.clear();
	}
	
	@Test
	public void testWriteFileAdd() {
		setUp();
		assertTrue(fs.exists("file1.txt"));
		fs.clear();
	}
	
	@Test
	public void testWriteFileContent() {
		setUp();
		assertEquals((fs.readFileContents("file1.txt")), data);
		fs.clear();
	}
	
	@Test
	public void testGetNumberOfFiles() {
		setUp();
		String text = "testing 1, 2, 3, 4";
		fs.writeFileContents("test.txt", text);
		assertEquals(fs.getNumberOfFiles(), 2);
		fs.clear();
	}

	@Test
	public void testGetFiles() {
		setUp();
		String text = "testing 1, 2, 3, 4";
		fs.writeFileContents("test.txt", text);
		String method = (fs.getFiles()).toString();
		assertEquals(method, ('[' + data + ", " + text + ']'));
		fs.clear();
	}
	
	@Test
	public void testGetFile() {
		setUp();
		String text = "testing 1, 2, 3, 4";
		fs.writeFileContents("test.txt", text);
		assertNotNull(fs.getFile("test.txt"));
		fs.clear();
	}
	
	@Test
	public void testExixts() {
		setUp();
		assertTrue(fs.exists("file1.txt"));
	}
	
	@Test
	public void testClear() {
		setUp();
		fs.clear();
		assertEquals(fs.size(), 0);
	}
	
	@Test
	public void testSize() {
		setUp();
		assertEquals(fs.size(), 1);
		fs.clear();
	}
	
}
