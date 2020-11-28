package lamph11.api.config;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.util.Strings;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import lamph11.api.service.JwtService;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class AuthFilter extends OncePerRequestFilter {

    private static final String TOKEN_HEADER = "Auth_token";
    private static final String PREFIX = "bearer";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String token = request.getHeader(TOKEN_HEADER);
        try {
            if (Objects.nonNull(token) && Strings.isNotEmpty(token)) {
                token = token.replace(PREFIX, "").trim();
                Authentication auth = JwtService.generateAuthentication(token);
                SecurityContextHolder.getContext().setAuthentication(auth);
            }
        } catch (Exception e) {
            log.error(this.getClass().getName(), e);
        } finally {
            filterChain.doFilter(request, response);
        }
    }

}
