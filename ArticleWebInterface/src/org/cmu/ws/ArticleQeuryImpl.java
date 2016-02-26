package org.cmu.ws;

import java.util.List;

import javax.jws.WebService;

import org.cmu.xquery.XQuery;

@WebService(endpointInterface = "org.cmu.ws.ArticleQueryInterface")
public class ArticleQeuryImpl implements ArticleQueryInterface {

	@Override
	public String selectAllArticleTitles() {
		// TODO Auto-generated method stub
		List<String> res = XQuery.query(XQuery.selectAllArticleTitles());
		StringBuilder sb = new StringBuilder();
		for(String e : res)
			sb.append(e + "\n");
		return sb.toString();
	}

	@Override
	public String selectAllAuthors() {
		// TODO Auto-generated method stub
		List<String> res = XQuery.query(XQuery.selectAllAuthors());
		StringBuilder sb = new StringBuilder();
		for(String e : res)
			sb.append(e + "\n");
		return sb.toString();	
	}

	@Override
	public String selectAllTheTitleOfFristArticle() {
		// TODO Auto-generated method stub
		List<String> res = XQuery.query(XQuery.selectTheTitleOfFirstArticle());
		StringBuilder sb = new StringBuilder();
		for(String e : res)
			sb.append(e + "\n");
		return sb.toString();
	}

	@Override
	public String selectArticlesLaterThan(String year) {
		// TODO Auto-generated method stub
		List<String> res = XQuery.query(XQuery.selectArticlesLaterThan(year));
		StringBuilder sb = new StringBuilder();
		for(String e : res)
			sb.append(e + "\n");
		return sb.toString();
	}

	@Override
	public String selectTitlesLaterThan(String year) {
		// TODO Auto-generated method stub
		List<String> res = XQuery.query(XQuery.selectTitlesLaterThan(year));
		StringBuilder sb = new StringBuilder();
		for(String e : res)
			sb.append(e + "\n");
		return sb.toString();
	}

}
