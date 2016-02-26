package org.cmu.xquery;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.xml.xquery.XQConnection;
import javax.xml.xquery.XQDataSource;
import javax.xml.xquery.XQException;
import javax.xml.xquery.XQPreparedExpression;
import javax.xml.xquery.XQResultSequence;

import com.saxonica.xqj.SaxonXQDataSource;


public class XQuery {
	public static String generateXML(InputStream inputStream, String filename){
		List<String> nodes = query(inputStream);
		StringBuilder sb = new StringBuilder();
		sb.append("<?xml version=\"1.0\"?>" + "\n");
		sb.append("<?xml-stylesheet type=\"text/xsl\" href=\"" + filename + "\"?>" + "\n");
		sb.append("<root>" + "\n");
		for(String node : nodes){
			sb.append("<node>" + "\n");
			sb.append(node + "\n");
			sb.append("</node>" + "\n");
		}
		sb.append("</root>" + "\n");
		return sb.toString();
	}
	
	public static List<String> query(InputStream inputStream){
		List<String> res = new ArrayList<String>();
		try {
		    XQDataSource ds = new SaxonXQDataSource();
		    XQConnection conn = ds.getConnection();
		    XQPreparedExpression exp = conn.prepareExpression(inputStream);
		    XQResultSequence result = exp.executeQuery();
		    while (result.next())
		    	res.add(result.getItemAsString(null));
		} catch (XQException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
	
	public static InputStream selectAllArticleTitles(){
		String query = "for $x in doc(\"records.xml\")/dblp/article" + "\n" + 
					   "return $x/title";
		return new ByteArrayInputStream(query.getBytes());
	}
	
	public static InputStream selectTheTitleOfFirstArticle(){
		String query = "doc(\"records.xml\")/dblp/article[1]/title";
		return new ByteArrayInputStream(query.getBytes());
	}
	
	public static InputStream selectAllAuthors(){
		String query = "let $authors := (doc(\"records.xml\")/dblp/article/author)" + "\n" +  
					   "let $unique_authors := distinct-values($authors)" + "\n" +
					   "for $author in $unique_authors" + "\n" +
					   "return <author>{$author}</author>";
		return new ByteArrayInputStream(query.getBytes());
	}
	
	public static InputStream selectArticlesLaterThan(String year){
		String query = "doc(\"records.xml\")/dblp/article[year>" + year + "]";
		return new ByteArrayInputStream(query.getBytes());
	}
	
	public static InputStream selectTitlesLaterThan(String year){
		String query = "doc(\"records.xml\")/dblp/article[year>" + year + "]/title";
		return new ByteArrayInputStream(query.getBytes());
	}
}
