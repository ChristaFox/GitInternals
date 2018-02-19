public class GitFileEntry extends FileEntry {
	//feilds
	private String filename;
	private int mode;
	private String hash;
	
	//const
    public GitFileEntry(String filename, int mode, String hash) {
    	super(filename);
        this.filename = filename;
        this.mode = mode;
        this.hash = hash;
    }

    //methods
    public int getMode() {
        return mode;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
    	this.hash = hash;
    }
}