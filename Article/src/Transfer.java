import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.xml.transform.TransformerException;


public class Transfer {
	private static XslTransformer transformer = new XslTransformer();
	
	public static void transfer(String filename){	
		File file = new File(filename + ".html");
		BufferedWriter writer;
		try {
			writer = new BufferedWriter(new FileWriter(file));
			BufferedReader xmlReader = new BufferedReader(new FileReader(filename + ".xml"));
			BufferedReader xslReader = new BufferedReader(new FileReader(filename + ".xsl"));
			transformer.process(xmlReader, xslReader, writer);
			writer.flush();
			writer.close();
			xmlReader.close();
			xslReader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args){
		transfer(FileNames.ALLARTICLETITLES);
		
		transfer(FileNames.THETITLEOFFIRSTARTICLE);
		
		transfer(FileNames.ALLAUTHORS);
		
		transfer(FileNames.ARTICLESLATERTHAN2010);
		
		transfer(FileNames.TITLESLATERTHAN2010);
	}
}
