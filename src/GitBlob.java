import java.util.Scanner;

public class GitBlob extends GitObject {
	//feilds
	private String data;
	
	//const
    public GitBlob(String data) {
    	this.data = data;
    }

    //methods
    public String getData() {
        return data;
    }

    @Override
    public String toString() {
        return "blob " + data.length() + '\n' + data + '\n' + '\n';
    }

    public static GitBlob fromFile(Scanner input) {
        return new GitBlob(input.nextLine());
    }
}
