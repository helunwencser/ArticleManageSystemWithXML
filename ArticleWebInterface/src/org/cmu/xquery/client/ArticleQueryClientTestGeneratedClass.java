package org.cmu.xquery.client;

import org.cmu.ws.ArticleQeuryImplService;
import org.cmu.ws.ArticleQueryInterface;

public class ArticleQueryClientTestGeneratedClass {
	public static void main(String[] args){
		ArticleQeuryImplService service = new ArticleQeuryImplService();
		ArticleQueryInterface query = service.getArticleQeuryImplPort();
		System.out.println(query.selectAllArticleTitles());
	}
}
