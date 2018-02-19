import java.util.Collections;
import java.util.SortedSet;
import java.util.TreeSet;

public class GitIndex extends FileSystemBase {
	
	//feilds
	protected TreeSet<GitFileEntry> gFEntries = new TreeSet<>();
	public int size = 0;
	
	//constr
	
	
	//methods
	/*
	 * provided by Tim Kington via piazza
	 */
	public void addFile(String filename, String hash) {
		GitFileEntry entry = (GitFileEntry) getFile(filename);
		if (entry == null) {
			entry = new GitFileEntry(filename, 100644, hash);
			gFEntries.add(entry);
			size++;
		} else {
			entry.setHash(hash);
		}
	}
	public int size() {
		return size;
	}
}
