package lk.ijse.cmjd109.LostAndFoundApplication.secureConfig;

import java.io.IOException;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;


import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.ijse.cmjd109.LostAndFoundApplication.dao.UserDao;
import lombok.RequiredArgsConstructor;

@Component
@Configuration
@RequiredArgsConstructor
@Order(1)
public class AuthFilter extends OncePerRequestFilter {
    private final JWTUtils jwtUtils;
    private final UserDao userDao;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
       
        try {
            var token = getToken(request);
            if(token != null && jwtUtils.validateToken(token)) {
                var userNameFromToken = jwtUtils.getUserNameFrommToken(token);
                var userDetails = userDao.findByEmail(userNameFromToken);
                var authToken =
                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.get().getAuthorities());
                authToken.setDetails(new WebAuthenticationDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        filterChain.doFilter(request, response);
    }

    private String getToken(HttpServletRequest request) {
        var authHeader = request.getHeader("Authorization");
        if(StringUtils.hasText(authHeader) && authHeader.startsWith("Bearer ")) {
            return authHeader.substring(7);
        }
        return null;
    }
}
