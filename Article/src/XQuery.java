import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.xml.transform.Result;
import javax.xml.transform.TransformerException;
import javax.xml.xquery.XQConnection;
import javax.xml.xquery.XQDataSource;
import javax.xml.xquery.XQException;
import javax.xml.xquery.XQPreparedExpression;
import javax.xml.xquery.XQResultSequence;

import com.saxonica.xqj.SaxonXQDataSource;


public class XQuery {
	public static void generateXMLFile(List<String> nodes, String filename){
		File file = new File(filename + ".xml");
		if(file.exists())
			file.delete();
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.write("<?xml version=\"1.0\"?>" + "\n");
			writer.write("<?xml-stylesheet type=\"text/xsl\" href=\"" + filename + ".xsl\"?>" + "\n");
			writer.write("<root>" + "\n");
			for(String node : nodes){
				writer.write("<node>" + "\n");
				writer.write(node + "\n");
				writer.write("</node>" + "\n");
			}
			writer.write("</root>" + "\n");
			writer.flush();
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void selectAllArticleTitles(){
		List<String> res = new ArrayList<String>();
		InputStream inputStream;
		try {
			inputStream = new FileInputStream(new File("selectAllArticleTitles.xqy"));
		    XQDataSource ds = new SaxonXQDataSource();
		    XQConnection conn = ds.getConnection();
		    XQPreparedExpression exp = conn.prepareExpression(inputStream);
		    XQResultSequence result = exp.executeQuery();
		    while (result.next())
		    	res.add(result.getItemAsString(null));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (XQException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		generateXMLFile(res, FileNames.ALLARTICLETITLES);
	}
	
	public static void selectTheTitleOfFirstArticle(){
		List<String> res = new ArrayList<String>();
		InputStream inputStream;
		try {
			inputStream = new FileInputStream(new File("selectTheTitleOfFirstArticle.xqy"));
		    XQDataSource ds = new SaxonXQDataSource();
		    XQConnection conn = ds.getConnection();
		    XQPreparedExpression exp = conn.prepareExpression(inputStream);
		    XQResultSequence result = exp.executeQuery();
		    while(result.next()){
		    	res.add(result.getItemAsString(null));
		    	break;
		    }
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (XQException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		generateXMLFile(res, FileNames.THETITLEOFFIRSTARTICLE);
	}
	
	public static void selectAllAuthors(){
		List<String> res = new ArrayList<String>();
		InputStream inputStream;
		try {
			inputStream = new FileInputStream(new File("selectAllAuthors.xqy"));
		    XQDataSource ds = new SaxonXQDataSource();
		    XQConnection conn = ds.getConnection();
		    XQPreparedExpression exp = conn.prepareExpression(inputStream);
		    XQResultSequence result = exp.executeQuery();
		    while(result.next()){
		    	res.add(result.getItemAsString(null));
		    }
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (XQException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		generateXMLFile(res, FileNames.ALLAUTHORS);	
	}
	
	public static void selectArticlesLaterThan2010(){
		List<String> res = new ArrayList<String>();
		InputStream inputStream;
		try {
			inputStream = new FileInputStream(new File("selectArticlesLaterThan2010.xqy"));
		    XQDataSource ds = new SaxonXQDataSource();
		    XQConnection conn = ds.getConnection();
		    XQPreparedExpression exp = conn.prepareExpression(inputStream);
		    XQResultSequence result = exp.executeQuery();
		    while(result.next()){
		    	res.add(result.getItemAsString(null));
		    }
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (XQException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		generateXMLFile(res, FileNames.ARTICLESLATERTHAN2010);
	}
	
	public static void selectTitlesLaterThan2010(){
		List<String> res = new ArrayList<String>();
		InputStream inputStream;
		try {
			inputStream = new FileInputStream(new File("selectTitlesLaterThan2010.xqy"));
		    XQDataSource ds = new SaxonXQDataSource();
		    XQConnection conn = ds.getConnection();
		    XQPreparedExpression exp = conn.prepareExpression(inputStream);
		    XQResultSequence result = exp.executeQuery();
		    while(result.next()){
		    	res.add(result.getItemAsString(null));
		    }
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (XQException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		generateXMLFile(res, FileNames.TITLESLATERTHAN2010);		
	}
	public static void main(String[] args){
		selectAllArticleTitles();
		
		selectTheTitleOfFirstArticle();
		
		selectAllAuthors();
		
		selectArticlesLaterThan2010();
		
		selectTitlesLaterThan2010();
		
	}
}
