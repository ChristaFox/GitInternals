import java.util.Iterator;

public class FileSystem extends FileSystemBase {
	
	protected String contents;

	public FileSystem() {
		super();
	}

    public String readFileContents(String filename) {
    	FileEntry entry = getFile(filename);
    	return entry ==null ? null : entry.toString();
    }
    
    @Override
    public String toString() {
    	return contents;
    }
    
    public void writeFileContents(String filename, String contents) {
    	FileEntry file = getFile(filename);
    	if (file == null) {
    		file = new FileEntry(filename);
    		files.add(file);
    	}
        file.setContents(contents);
    }

    public void deleteFile(String filename) {
    	remove(filename);
    }
    
    public void clear() {
		files.clear();
    }

    public int size() {
    	return super.getNumberOfFiles();
    }

}
