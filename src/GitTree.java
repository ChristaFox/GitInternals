import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GitTree extends GitObject {
	
	//feilds
	private List<GitFileEntry> entries = new ArrayList<>();
	
	//methods
    public void addFile(String fName, int mode, String hash) {
    	entries.add(new GitFileEntry(fName, mode, hash));
    }

    public List<GitFileEntry> getFiles() {
        return entries;
    }

    public GitFileEntry getFile(String filename) {
        for (GitFileEntry gFile : entries) {
        	if (filename.equals(gFile.getFilename())) {
        		return gFile;
        	}
        }
    	return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (GitFileEntry gFEntry : entries) {
        	sb.append(gFEntry.getMode()).append(' ');
        	sb.append(gFEntry.getFilename()).append(' ');
        	sb.append(gFEntry.getHash()).append('\n');
        }
        return "tree " + sb.length() + '\n' + sb.toString() + "...";
    }

    public static GitTree fromFile(Scanner input) {
        GitTree tree = new GitTree();
        
        while (input.hasNextLine()) {
        	String line = input.nextLine();
        	String [] arr = line.split(" ");
        	tree.addFile(arr [1], Integer.parseInt(arr [0]), arr [2]); 
        }
        return tree;
    }

}
