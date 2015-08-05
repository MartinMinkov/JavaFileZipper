import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipUtil {
	private static String FILEPATH = "/home/martin/JavaFileZipper/";
	private static String FILE = "compress.txt";
	private static String FILETOZIP = "helloWorld.zip";
	static ZipGUI g;
	
	public static void main (String [] args) {
		g = new ZipGUI();
	}
	public static void ZipFile() {
		byte[] buffer = new byte[1024];
		
		
		FILEPATH = g.getFileLocation();
		FILE = g.getFileName();
		FILETOZIP = g.getZipFileName();
		System.out.println("FILEPATH : " + FILEPATH);
		System.out.println("FILE : " + FILE);
		System.out.println("FILETOZIP : " + FILETOZIP);
		
		if (FILEPATH == null || FILE == null || FILETOZIP == null) {
			g.checkFileNames();
		}
		
		try {
			FileOutputStream fos = new FileOutputStream(FILEPATH  + "/"+ FILETOZIP);
			ZipOutputStream zos = new ZipOutputStream(fos);
			ZipEntry ze = new ZipEntry(FILE);
			zos.putNextEntry(ze);
			FileInputStream in = new FileInputStream(FILEPATH +"/"+ FILE);
			
			int len;
			while ((len = in.read(buffer)) > 0) {
				zos.write(buffer, 0, len);
			}
			in.close();
			zos.closeEntry();
			zos.close();
			System.out.println("Done!");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
