import java.util.Date;
import java.util.Set;
public class Main {

    public static void main(String[] args) {
        FileSystem filesys = new FileSystem();
        filesys.addFile(null,"test",100);
        filesys.addDir(null, "src");
        filesys.addFile("src", "inSrc", 1000);
        filesys.delete("src");
        filesys.addDir("src", "ttest1");
        filesys.addDir(null, "src");
        filesys.addDir("src", "ttest2");

        filesys.showFileSystem();


    }
}
