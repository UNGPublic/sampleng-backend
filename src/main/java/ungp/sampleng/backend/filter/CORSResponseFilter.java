package ungp.sampleng.backend.filter;


import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

public class CORSResponseFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        
		HttpServletResponse servletResponse = (HttpServletResponse) response;
		
		servletResponse.addHeader("Access-Control-Allow-Origin", "*");
		servletResponse.addHeader("Access-Control-Allow-Headers", "origin, content-type, accept, authorization");
		servletResponse.addHeader("Access-Control-Allow-Credentials", "true");
		servletResponse.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD");
		servletResponse.addHeader("Access-Control-Max-Age", "1209600");
		
		chain.doFilter(request, servletResponse);
		
    }

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	
	@Override
	public void destroy() {
	}

}
