import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GitTreeTests {

	//fields
	private GitTree gTree = new GitTree();
	protected FileSystem fSys = new FileSystem();
	protected GitIndex index = new GitIndex();
	protected Git g = new Git(fSys, index);
	
	public void setUp() {
		String data = "Hello, Git!";
		fSys.writeFileContents("file1.txt", data);
		gTree.addFile("file1.txt", 100644, (Sha1.hash(data)));
		g.commit("Tim", "the comment");
		String data2 = "Changed a thing";
		fSys.writeFileContents("file2.txt", data2);
		gTree.addFile("file2.txt", 100644, (Sha1.hash(data2)));
		g.commit("Tim", "Changed a thing");
	}
	
	@Test
	public void testAddFile() throws Exception {
		setUp();
		System.out.print(gTree.toString());
		//assertNotNull(currentGit.getFile("file1.txt"));
	}
	
	@Test
	public void testGetFiles() throws Exception {
		setUp();
		assertNotNull(gTree.getFiles());
	}	
	
	@Test
	public void testGetFile() throws Exception {
		setUp();
		assertNotNull(gTree.getFile("file1.txt"));
	}	

	@Test
	public void testToString() throws Exception {
		setUp();
		//String theString = currentGit.toString().split('\n')
		assertEquals(gTree.toString(), ("tree 116" + '\n' + "100644 file1.txt "
				+ "1d4d7d92f79dc328154dc91424e6e740f8f5a563" + '\n' + "100644 "
				+ "file2.txt b39c12399fa667974541ea8040beaedb42217a16" + '\n' +
				"..."));
	}	
	
//	@Test
//	public void testFromFile() throws Exception {
//		Scanner input = new Scanner(System.in);
//		System.out.print("type: file1.txt 100644 24be4db7b866e915bb21a87ab3c12ea44d7a99c5");
//		gTree.fromFile(input);
//		assertNotNull(gTree);
//	}
	
}