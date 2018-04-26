import java.util.Date;
/*
    this class implements the File component in our FileSystem data structure.
 */
public class FileComp extends FileSysComp{
    private long size;

    /***
     * Constructor for the File Component
     * Uses File System Component constructor and adds size
     * @param currName - Name of the file
     * @param currDate - Date created
     * @param parentDir - Parent Directory
     * @param sz - File's size
     */
    public FileComp(String currName, Date currDate, FileSysComp parentDir, long sz){
        super(currName, currDate, parentDir);
        this.setSize(sz);
    }

    public void setSize(long size) {
        this.size = size;
    }

    public long getSize() {
        return size;
    }
}