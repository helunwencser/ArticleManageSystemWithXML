package org.cmu.xquery.client;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import org.cmu.ws.ArticleQueryInterface;

public class ArticleQueryClient {
	public static void main(String[] args) throws Exception {
		
		URL url = new URL("http://localhost:8888/article/query");
	
        QName qname = new QName("http://ws.cmu.org/", "ArticleQeuryImplService");

        Service service = Service.create(url, qname);

        ArticleQueryInterface query = service.getPort(ArticleQueryInterface.class);

        System.out.println(query.selectTitlesLaterThan("2010"));

    }
}
