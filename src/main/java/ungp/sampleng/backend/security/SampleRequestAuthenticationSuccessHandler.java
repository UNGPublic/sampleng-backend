package ungp.sampleng.backend.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

public class SampleRequestAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

	private static final String TICKET_PARAM_NAME = "ticket";
	private static final String DEFAULT_REDIRECT_URL = "http://192.168.33.10/sample/app/#/login-success"; //FIXME: Sim. Será fixo nesta primeira versão.
	private static final String URL_FORMAT = "%s/%s/%s";
	
	@Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws ServletException, IOException {
		
        clearAuthenticationAttributes(request);
        
		String targetUrl = String.format(URL_FORMAT, DEFAULT_REDIRECT_URL, authentication.getName(), getTicket(request));
        
        getRedirectStrategy().sendRedirect(request, response, targetUrl);
        
    }

	private String getTicket(HttpServletRequest request) {
		return request.getParameter(TICKET_PARAM_NAME);
	}
	
}
