package br.com.efb.controller.api;

import org.apache.log4j.Logger;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

@Provider
public class CORSResponseFilter implements ContainerResponseFilter {

	private static final Logger logger =
			Logger.getLogger(CORSResponseFilter.class);

	public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext)
			throws IOException {

		MultivaluedMap<String, Object> headers = responseContext.getHeaders();

		headers.add("Access-Control-Expose-Headers", "Authorization");
		headers.add("Access-Control-Expose-Headers"," X-Custom-header");
		headers.add("Access-Control-Allow-Headers", "Authorization, X-Custom-header");
		headers.add("Access-Control-Allow-Origin", "*");
		headers.add("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT, OPTIONS");
		headers.add("Access-Control-Allow-Headers", "Access-Control-Allow-Headers, Origin,Accept, X-Requested-With, Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers" );
		headers.add("Access-Control-Max-Age", "3600");
		headers.add("Access-Control-Expose-Headers", "tokenJWT");


		String token = requestContext.getHeaderString("tokenJWT");

		logger.info("tokenJWT: " + token);
	}

}
