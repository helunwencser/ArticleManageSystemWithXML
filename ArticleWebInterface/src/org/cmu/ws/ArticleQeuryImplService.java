
package org.cmu.ws;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "ArticleQeuryImplService", targetNamespace = "http://ws.cmu.org/", wsdlLocation = "http://localhost:8888/article/query?wsdl")
public class ArticleQeuryImplService
    extends Service
{

    private final static URL ARTICLEQEURYIMPLSERVICE_WSDL_LOCATION;
    private final static WebServiceException ARTICLEQEURYIMPLSERVICE_EXCEPTION;
    private final static QName ARTICLEQEURYIMPLSERVICE_QNAME = new QName("http://ws.cmu.org/", "ArticleQeuryImplService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8888/article/query?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        ARTICLEQEURYIMPLSERVICE_WSDL_LOCATION = url;
        ARTICLEQEURYIMPLSERVICE_EXCEPTION = e;
    }

    public ArticleQeuryImplService() {
        super(__getWsdlLocation(), ARTICLEQEURYIMPLSERVICE_QNAME);
    }

    public ArticleQeuryImplService(WebServiceFeature... features) {
        super(__getWsdlLocation(), ARTICLEQEURYIMPLSERVICE_QNAME, features);
    }

    public ArticleQeuryImplService(URL wsdlLocation) {
        super(wsdlLocation, ARTICLEQEURYIMPLSERVICE_QNAME);
    }

    public ArticleQeuryImplService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, ARTICLEQEURYIMPLSERVICE_QNAME, features);
    }

    public ArticleQeuryImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ArticleQeuryImplService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns ArticleQueryInterface
     */
    @WebEndpoint(name = "ArticleQeuryImplPort")
    public ArticleQueryInterface getArticleQeuryImplPort() {
        return super.getPort(new QName("http://ws.cmu.org/", "ArticleQeuryImplPort"), ArticleQueryInterface.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ArticleQueryInterface
     */
    @WebEndpoint(name = "ArticleQeuryImplPort")
    public ArticleQueryInterface getArticleQeuryImplPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://ws.cmu.org/", "ArticleQeuryImplPort"), ArticleQueryInterface.class, features);
    }

    private static URL __getWsdlLocation() {
        if (ARTICLEQEURYIMPLSERVICE_EXCEPTION!= null) {
            throw ARTICLEQEURYIMPLSERVICE_EXCEPTION;
        }
        return ARTICLEQEURYIMPLSERVICE_WSDL_LOCATION;
    }

}
