import java.util.Hashtable;
import java.util.Date;

/*
    This class represents a single FileSystem
    The instance created had an hashtable and a root folder to start from.
 */

public class FileSystem {
    private Hashtable<String, FileSysComp> FilesSystemHierarchy = new Hashtable<>(); // A hashtable to hold all created files and directories
                                                                                     // Used to make deleting the files and getting the parent folder easier
    private DirComp root;

    public FileSystem(){
        this.setRoot(new DirComp("root", new Date(), null));
        FilesSystemHierarchy.put("root", this.getRoot());
    }

    public void setRoot(DirComp root) {
        this.root = root;
    }

    public DirComp getRoot() {
        return root;
    }

    public Hashtable<String, FileSysComp> getFilesSystemHierarchy() {
        return FilesSystemHierarchy;
    }

    /***
     * This function lets you add a file to the filesystem
     * @param parentDirName - the name of the parent dir to create the file in
     * @param fileName - the name of the file
     * @param fileSize - size of the file
     */
    public void addFile(String parentDirName, String fileName, long fileSize) {
        FileComp currFile = new FileComp(fileName, new Date(), null, fileSize); // Create a file instance
        if (parentDirName == null) {
            currFile.setParentDir(this.getRoot());// Sets up the parent dir to root
            this.getFilesSystemHierarchy().put(currFile.getName(), currFile); // Insert the file to the FileSystem Hierarchy
            this.getRoot().addComp(currFile); // Add the file as a child to the parent folder
        }
        else {
            if (this.getFilesSystemHierarchy().get(parentDirName) == null)
                return;
            else {
                this.getFilesSystemHierarchy().get(parentDirName).addComp(currFile);
                this.getFilesSystemHierarchy().put(currFile.getName(), currFile);
                currFile.setParentDir(this.getFilesSystemHierarchy().get(parentDirName)); // Set the parent dir using the name
            }

        }
    }

    /***
     * Thie function lets you add a dir to the filesystem
     * @param parentDirName - Name of the parent directory
     * @param dirName - Name of the new directory
     */
    public void addDir (String parentDirName, String dirName){
        DirComp currDir = new DirComp(dirName, new Date(), null);
        if (parentDirName == null) {
            currDir.setParentDir(this.getRoot());
            this.getFilesSystemHierarchy().put(currDir.getName(), currDir);
            this.getRoot().addComp(currDir);
        }
        else {
            if (this.getFilesSystemHierarchy().get(parentDirName) == null)
                return;
            else{
                this.getFilesSystemHierarchy().get(parentDirName).addComp(currDir);
                this.getFilesSystemHierarchy().put(currDir.getName(), currDir);
                currDir.setParentDir(this.getFilesSystemHierarchy().get(parentDirName));
            }
        }
    }

    public void delete(String fileName) {
        FileSysComp temp = this.getFilesSystemHierarchy().get(fileName);
        this.getFilesSystemHierarchy().remove(fileName);
        if (temp.getParentDir() != null)
            temp.getParentDir().remComp(temp);
    }

    public void showFileSystem(){
        System.out.println("File System Files:");
        this.getRoot().showFileSystem();
        System.out.println("End of File System Files.");
    }

}
