package org.cmu.ws.publisher;

import javax.xml.ws.Endpoint;

import org.cmu.ws.ArticleQeuryImpl;

public class ArticleQueryPublisher {
	public static void main(String[] args){
		Endpoint.publish("http://localhost:8888/article/query", new ArticleQeuryImpl());
	}
}
