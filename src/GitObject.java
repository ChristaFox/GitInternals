import java.util.Scanner;

public abstract class GitObject {
    public String getHash() {
        return Sha1.hash(this.toString());
    }

    //provided by Tim Kington via Piazza
    public static GitObject fromFile(Scanner in) {
        String line = in.nextLine();
        String type = line.split(" ")[0];
        if (type.equals("blob")) {
            return GitBlob.fromFile(in);
        }
        else if (type.equals("tree")) {
            return GitTree.fromFile(in);
        }
        else {
            return GitCommit.fromFile(in);
        }
    }
}
