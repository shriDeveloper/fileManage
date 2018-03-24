package filemanagesys;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;
import java.nio.file.Path;
import java.nio.file.Paths;
public class FileClient {
	private Socket s;
	public FileClient(String host, int port, String file) {
		try {
			s = new Socket(host, port);
			sendFile(file);
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	public void sendFile(String file) throws IOException {
		DataOutputStream dos = new DataOutputStream(s.getOutputStream());
		Path p=Paths.get(file);
		dos.writeUTF(p.getFileName().toString());
		FileInputStream fis = new FileInputStream(file);
		byte[] buffer = new byte[file.length()];	
		while (fis.read(buffer) > 0) {
			dos.write(buffer);
		}
		fis.close();
		dos.close();	
	}
}
