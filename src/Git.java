import java.util.LinkedList;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class Git {
	
	//fields
	private FileSystem fSys;
	private GitIndex index;
	private LinkedList<GitCommit> commits;

    public Git(FileSystem fSys, GitIndex index) {
    	this.fSys = fSys;
    	this.index = index;
    	this.commits = new LinkedList<>();
    }

    public String storeObject(GitObject gObj) {
    	String hash = gObj.getHash();
    	fSys.writeFileContents(filenameFromHash(hash), gObj.toString());
    	return hash;
    }

    public String filenameFromHash(String hash) {
		return "git/objects/" + hash.substring(0, 2) + '/' + hash.substring(2);
	}

	public String catFile(String hash) {
        return fSys.readFileContents(filenameFromHash(hash));
    }

    public void add(String filename) {
    	GitBlob blob = new GitBlob(fSys.readFileContents(filename));
    	String hash = storeObject(blob);
    	index.addFile(filename, hash);
    }

    public void remove(String filename) {
    	index.remove(filename);
    	index.size--;
    }

    public String commit(String author, String comment) {
        GitTree gTree = new GitTree();
        for (FileEntry gFEntry : index.getFiles()) {
        	gTree.addFile(gFEntry.getFilename(), ((GitFileEntry) gFEntry).getMode(), ((GitFileEntry) gFEntry).getHash());
        }
        String treeHash = storeObject(gTree);
        String parentHash = null;
        if (!commits.isEmpty()) {
        	parentHash = commits.get(commits.size() -1).getHash();
        }
        GitCommit gCommit = new GitCommit(treeHash, parentHash, author, comment);
        commits.add(gCommit);
        return  storeObject(gCommit);
    }

    public String log() {
        StringBuilder sBuild = new StringBuilder();
        for(int i = commits.size() -1; i >= 0; i--) {
        	GitCommit commit = commits.get(i);
        	sBuild.append("commit ").append(commit.getHash()).append('\n');
        	sBuild.append("Author: ").append(commit.getAuthor()).append('\n');
        	sBuild.append('\n');
        	sBuild.append("    ").append(commit.getComment()).append('\n');
        	
        	if (i > 0) {
        		sBuild.append('\n');
        	}
        }
    	return sBuild.toString();
    }

    public void checkout(String hash) {
    
    GitCommit gCommit = null;
    SortedSet<FileEntry> files = new TreeSet<>(fSys.getFiles());
    String tFile = filenameFromHash(gCommit.getTreeHash());
    String tData = fSys.readFileContents(tFile);
    GitTree gTree = (GitTree)GitObject.fromFile(new Scanner (tData));

    
	    for (GitCommit gCom : commits) {
	    	if (gCom.getHash().equals(hash)) {
	    		gCommit = gCom;
	    		break;
	    	}
	    }
	    for (FileEntry fEntry : files) {
	    	if (!fEntry.getFilename().startsWith(".git")) {
	    		fSys.deleteFile(fEntry.getFilename());
	    	}
	    }
	
	    for (GitFileEntry gFEntry : gTree.getFiles()) {
	    	String bFile = filenameFromHash(gFEntry.getHash());
	    	String bData = fSys.readFileContents(bFile);
	    	GitBlob gBlob = (GitBlob)GitObject.fromFile(new Scanner (bData));
	    	fSys.writeFileContents(gFEntry.getFilename(), gBlob.getData());
	    } 
    }
    
    public void clear() {
    	fSys.clear();
    }

	public int size() {
		return index.size();
	}
    
}
