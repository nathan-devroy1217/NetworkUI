import java.io.File;
import java.util.ArrayList;

/**
 * File list feature for web UI
 * @author Nathan Devroy
 * @version 2/11/18
 */
public class FileLister {

	/** Directory we will pull files from */
	private String filePath = QueryConstants.FILE_PATH;
	
	/**
	 * Constructor for FileLister
	 */
	public FileLister() {
	
	}	
	
	/**
	 * Grabs files from filePath and returns list
	 * @return list of files
	 */
	public ArrayList<File> getFiles() {
		File folder = new File(filePath);
		File[] listArr = folder.listFiles();
		ArrayList<File> fileFolder = new ArrayList<File>();
		for(File f: listArr) {
			fileFolder.add(f);
		}
		return fileFolder;		
	}
}
