import java.util.Scanner;

public class GitCommit extends GitObject {
	
	//feilds
	private String treeHash; 
	private String parentHash; 
	private String author;
	private String comment;

	//const
    public GitCommit(String treeHash, String parentHash, String author, String comment) {
    	this.treeHash = treeHash;
    	this.parentHash = parentHash;
    	this.author = author;
    	this.comment = comment;
    }

    //methods
    public String getTreeHash() {
        return treeHash;
    }

    public String getParentHash() {
        return parentHash;
    }

    public String getAuthor() {
        return author;
    }

    public String getComment() {
        return comment;
    }

    @Override
    public String toString() {
        StringBuilder sBuild = new StringBuilder();
        sBuild.append("tree "). append(treeHash).append('\n');
        
        if (parentHash != null) {
        	sBuild.append("parent ").append(parentHash).append('\n');
        }
    	sBuild.append("author ").append(author).append('\n');
        sBuild.append('\n');
    	sBuild.append(comment).append('\n');
        return "commit " + sBuild.length() + "\n" + sBuild.toString();
    }

    public static GitCommit fromFile(Scanner in) {
        String treeHash = in.nextLine().split(" ")[1];
        String parentHash = null;
        String[] arr = in.nextLine().split(" ", 2);
        if (arr[0].equals("parent")) {
        	parentHash = arr[1];
        }
        String author = arr[1];
        in.nextLine();
        String comment = in.nextLine();
        
        return new GitCommit(treeHash, parentHash, author, comment);
    }
}
