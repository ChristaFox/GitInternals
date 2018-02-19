
public class FileEntry implements Comparable<FileEntry> {
	private String contents;
	private String filename;
	
    public FileEntry(String filename) {
    	this.filename = filename;
    }

    public String getFilename() {
        return filename;
    }

    @Override
    public String toString() {
        return contents;
    }

    public void setContents(String contents) {
    	this.contents = contents;
    }

    @Override
    public int compareTo(FileEntry fileToCompare) {
        return filename.compareTo(fileToCompare.filename);
    }
    
}