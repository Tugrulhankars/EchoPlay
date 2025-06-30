package org.echoplay.echoplay.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.echoplay.echoplay.service.UserService;
import org.echoplay.echoplay.service.impl.JwtServiceImpl;
import org.echoplay.echoplay.service.impl.UserServiceImpl;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@Component
public class AuthenticationFilter extends OncePerRequestFilter {

    private final UserServiceImpl userService;
    private final JwtServiceImpl jwtService;
    private static final List<String> PUBLIC_URLS=List.of("");
    public AuthenticationFilter(UserServiceImpl userService, JwtServiceImpl jwtService) {
        this.userService = userService;
        this.jwtService = jwtService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String path=request.getServletPath();
        if (PUBLIC_URLS.contains(path)){
            filterChain.doFilter(request,response);
        }

        String jwt=null;
        String email=null;
        final  String authorizationHeader=request.getHeader("Authorization");
        if (authorizationHeader!=null && authorizationHeader.startsWith("Bearer")){
            jwt=authorizationHeader.substring(7);
        }
        if (jwt==null){
            Cookie[] cookies=request.getCookies();
            if (cookies!=null){
                for (Cookie cookie:cookies){
                    if (cookie.getName().equals("jwt")){
                        jwt=cookie.getValue();
                        break;
                    }
                }
            }
        }

        if (jwt!=null){
            email=jwtService.extractEmail(jwt);
            if (email!=null && SecurityContextHolder.getContext().getAuthentication()==null){
                UserDetails userDetails=userService.loadUserByUsername(email);
                if (jwtService.validateToken(jwt,userDetails)){
                    UsernamePasswordAuthenticationToken authenticationToken=
                            new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                }
            }
        }
        filterChain.doFilter(request,response);

    }
}
