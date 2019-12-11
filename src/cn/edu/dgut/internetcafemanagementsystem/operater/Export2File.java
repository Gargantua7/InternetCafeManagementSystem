package cn.edu.dgut.internetcafemanagementsystem.operater;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Export2File {

	public Export2File(String[][] data, String fileName) throws IOException
	{
		File dir = new File("data");
		dir.mkdirs();
		File file = new File(dir, "" + fileName + ".csv");
		file.createNewFile();
		FileWriter out = new FileWriter(file);
		
		out.write("Ê±¼ä,½ð¶î\n");
		for(int i = 0; i < data.length; i++) {
				out.write(data[i][0] + ", " + data[i][1] + "\n");
		}
		out.close();		
	}
}
