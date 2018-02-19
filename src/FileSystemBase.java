import java.util.Collections;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Base class for filesystems
 * @author tim
 * @version 1.0
 */
public class FileSystemBase {
    /** The files in the filesystem */
	//feilds
	public TreeSet<FileEntry> files = new TreeSet<>();
	
	//methods
    /**
     * Returns the # of files
     * @return the # of files
     */
    public int getNumberOfFiles() {
        return files.size();
    }

    /**
     * Returns the files
     * @return the files
     */
    public SortedSet<FileEntry> getFiles() {
        return Collections.unmodifiableSortedSet(files);
    }

    /**
     * Returns the file entry for the given file
     * @param filename the file
     * @return the entry, or null
     */
    public FileEntry getFile(String filename) {
        for (FileEntry entry : files) {
            if (entry.getFilename().equals(filename)) {
                return entry;
            }
        }

        return null;
    }

    /**
     * Returns true if the file exists
     * @param filename the filename
     * @return true if the file exists
     */
    public boolean exists(String filename) {
        return getFile(filename) != null;
    }

    /**
     * Deletes a file
     * @param filename the filename
     * @return true if found and deleted
     */
    public boolean remove(String filename) {
        for (Iterator<FileEntry> iter = files.iterator(); 
        		iter.hasNext(); ) {
            FileEntry entry = iter.next();
            if (filename.equals(entry.getFilename())) {
                iter.remove();
                return true;
            }
        }

        return false;
    }
}
