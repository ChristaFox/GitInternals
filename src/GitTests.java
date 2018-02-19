import static org.junit.Assert.*;

import java.util.LinkedList;
import org.junit.Test;

public class GitTests {
	
	protected FileSystem fSys = new FileSystem();
	protected GitIndex index = new GitIndex();
	protected Git g = new Git(fSys, index);

	public void setUp() {
		String data = "Hello, Git!";
		fSys.writeFileContents("file1.txt", data);
		g.add("file1.txt");
		g.commit("Tim", "the comment");
		String test = "testing";
		fSys.writeFileContents("file2.txt", test);
		g.add("file2.txt");
		g.commit("Tim", "Changed a thing");
	}
	
	public void tearDown() {
		g.clear();
	}
	
	@Test
	public void testStoreObject() {
		setUp();
		assertEquals(g.size(), 2);
		tearDown();
	}
	
	@Test
	public void testFilenameFromHash() {
		assertEquals((g.filenameFromHash(Sha1.hash("Hello, Git!"))), "git/objects/1d/4d7d92f79dc328154dc91424e6e740f8f5a563");
	}
	
	@Test
	public void testCatFile() {
		setUp();
		assertEquals((fSys.readFileContents("file1.txt")), "Hello, Git!");
		tearDown();
	}

	@Test
	public void testAdd() {
		setUp();
		//System.out.print(index.size());
		assertEquals(index.size(), 2);
		tearDown();
	}
	
	@Test
	public void testRemove() {
		setUp();
		g.remove("file1.txt");
		//System.out.print(g.size());
		assertEquals(g.size(), 1);
	}

	@Test
	public void testCommit() {
		setUp();
		assertNotNull(g.log());
		tearDown();
	}
	//log
	//checkout
	
}
