import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GitCommitTests {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGitCommit() {
		GitCommit commit = new GitCommit("704fef1b0dd7c6ad7682e9f54f8808899d9364a5", null, "Tim", "changed a thing");
		assertTrue(commit.equals(commit));
	}
	
	@Test
	public void testgetTreeHash() {
		GitCommit commit = new GitCommit("704fef1b0dd7c6ad7682e9f54f8808899d9364a5", null, "Tim", "changed a thing");
		assertEquals(commit.getTreeHash(), "704fef1b0dd7c6ad7682e9f54f8808899d9364a5");
	}

	@Test
	public void testgetParentHash() {
		GitCommit commit = new GitCommit("704fef1b0dd7c6ad7682e9f54f8808899d9364a5", null, "Tim", "changed a thing");
		assertEquals(commit.getParentHash(), null);
	}
	
	@Test
	public void testgetAuthor() {
		GitCommit commit = new GitCommit("704fef1b0dd7c6ad7682e9f54f8808899d9364a5", null, "Tim", "changed a thing");
		assertEquals(commit.getAuthor(), "Tim");
	}
	
	@Test
	public void testGetComment() {
		GitCommit commit = new GitCommit("704fef1b0dd7c6ad7682e9f54f8808899d9364a5", null, "Tim", "changed a thing");
		assertEquals(commit.getComment(), "changed a thing");
	}

	@Test
	public void testToString() {
		GitCommit commit = new GitCommit("704fef1b0dd7c6ad7682e9f54f8808899d9364a5", null, "Tim", "changed a thing");
		assertEquals((commit.toString()), ("commit 74" + '\n' + 
				"tree 704fef1b0dd7c6ad7682e9f54f8808899d9364a5" + '\n' +
				"author Tim" + '\n' + '\n' + "changed a thing" + '\n'));
	}
	
}
