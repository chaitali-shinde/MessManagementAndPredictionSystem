package mess.predict.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class PathHelper {
	public static FileInputStream fin = null;
	public static File f = null;
	static {
		 f = new File(".");//. se java project ka path aayenga
		String path = (f.getAbsolutePath().substring(0, f.getAbsolutePath().length()-1)) + "src\\db.properties"; //path mai andr o dot(.) hai to nikalna hai iske liye path absolute krna padenga and substring krke uski length -1 krni padegi.
		//System.out.println(path);
		
		try {
			 fin = new FileInputStream(path);//varchya pathh  pass krnysathi
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();	
		}
		
		
	}
}
