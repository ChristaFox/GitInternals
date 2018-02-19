import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GitBlobTests {

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
	public void test() {
		
	}

}
