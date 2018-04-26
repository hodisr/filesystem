import java.util.ArrayList;
import java.util.List;
import java.util.Date;
/*
    This class implements the Directory type in our FileSystem data structure
 */

public class DirComp extends FileSysComp {
    private List<FileSysComp> children = new ArrayList<>(); // A list to hold all the subfolders/files

    /***
     * Directory Component constructor
     * @param currName - current directory name
     * @param currDate - current date (for date created) java.Date type
     * @param parentDir - the parent directory of the dir
     */
    public DirComp(String currName, Date currDate, FileSysComp parentDir) {
        super(currName, currDate, parentDir);
    }

    public List<FileSysComp> getChildren() {
        return children;
    }

    /*
        overrides the addComp method in the FileSys Component
     */
    public void addComp(FileSysComp comp) {
        children.add(comp);
    }

    public void remComp(FileSysComp comp) {
        children.remove(comp);
    }

    /*
        Method to print all the System's files
     */
    public void showFileSystem() {
        if (this.getParentDir() == null)
            System.out.println('/'+ this.getName() + "\t date created: " + this.getDate());
        else
            System.out.println('/' + this.getParentDir().getName() + '/'+ this.getName() + "\t date created: "
                    + this.getDate());
        if (children.isEmpty()) {
            return;
        }
        for (FileSysComp curr : children) {
            if (curr instanceof FileComp) // Checks if its a file or a dir
                System.out.println(curr.getParentDir().getName() + '/'+ curr.getName() + "\t date created: "
                        + curr.getDate() + " size: " + ((FileComp) curr).getSize());
            else {
                ((DirComp) curr).showFileSystem(); // reversed recursion to get the children's filesystem if it's a directory
            }
        }
    }
}