import java.util.Date;

/*
    This is an abstract class for the FileSystem DataStructure.
*/
public abstract class FileSysComp{
    private String name;
    private Date date;
    private FileSysComp parentDir = null;

    public FileSysComp(String currName, Date currDate, FileSysComp currParent){
        this.setName(currName);
        this.setDate(currDate);
        this.setParentDir(currParent);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public FileSysComp getParentDir() {
        return parentDir;
    }

    public void setParentDir(FileSysComp parentDir) {
        this.parentDir = parentDir;
    }

    public void addComp(FileSysComp comp){} // abstract method

    public void remComp(FileSysComp comp){} // abstract method

}