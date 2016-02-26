import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.TransformerException;

import org.cmu.xquery.FileNames;
import org.cmu.xquery.XQuery;
import org.cmu.xquery.XslTransformer;
 
public class WebQuery extends HttpServlet {
	
	private static final long serialVersionUID = -4200518968532059099L;
	
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
        String option = request.getParameter("options");
        String year = request.getParameter("year");
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        XslTransformer transformer = new XslTransformer();
        
        String xml = null;
        InputStream xmlStream = null, xslStream = null;
        switch (option){
        case "1" : 
        	xml = XQuery.generateXML(XQuery.selectAllArticleTitles(), FileNames.ALLARTICLETITLES);
        	xmlStream = new ByteArrayInputStream(xml.getBytes());
        	xslStream = this.getServletContext().getResourceAsStream(FileNames.ALLARTICLETITLES);
        	break;
        case "2" :
        	xml = XQuery.generateXML(XQuery.selectTheTitleOfFirstArticle(), FileNames.THETITLEOFFIRSTARTICLE);
        	xmlStream = new ByteArrayInputStream(xml.getBytes());
        	xslStream = this.getServletContext().getResourceAsStream(FileNames.THETITLEOFFIRSTARTICLE);
        	break;        
       case "3" : 
		   	xml = XQuery.generateXML(XQuery.selectAllAuthors(), FileNames.ALLAUTHORS);
		   	xmlStream = new ByteArrayInputStream(xml.getBytes());
		   	xslStream = this.getServletContext().getResourceAsStream(FileNames.ALLAUTHORS);
		   	break;
        case "4" :
        	if(year == null || year.length() == 0 || !year.matches("[0-9]+")){
        		writer.write("Please input valid year");
        	}else{
	        	xml = XQuery.generateXML(XQuery.selectArticlesLaterThan(year), FileNames.ARTICLESLATERTHAN);
	        	xmlStream = new ByteArrayInputStream(xml.getBytes());
	        	xslStream = this.getServletContext().getResourceAsStream(FileNames.ARTICLESLATERTHAN);
        	}
        	break;
        default :
        	if(year == null || year.length() == 0 || !year.matches("[0-9]+")){
        		writer.write("Please input valid year");
        	}else{
            	xml = XQuery.generateXML(XQuery.selectTitlesLaterThan(year), FileNames.TITLESLATERTHAN);
            	xmlStream = new ByteArrayInputStream(xml.getBytes());
            	xslStream = this.getServletContext().getResourceAsStream(FileNames.TITLESLATERTHAN);
        	}
        	break;
        }
    	try {
    		if(xmlStream != null && xslStream != null)
    			transformer.process(new InputStreamReader(xmlStream), new InputStreamReader(xslStream), writer);
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	writer.close();
    }
 
}