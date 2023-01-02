package it.app2.filter;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Base64;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


public class JwtAuthenticationFilter implements Filter{

	
	private static final String SECRETKEY = Base64.getEncoder().encodeToString("abc1234".getBytes());
	private static final String PREFIX = "Bearer";
	private static final String EMPTY = "";
	private static final String AUTHORIZATION = "Authorization";
	
	private AuthenticationManager authenticationManager;
	
	
	public JwtAuthenticationFilter(AuthenticationManager authenticationManager) {
		super();
		this.authenticationManager = authenticationManager;
	}



	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		Authentication authentication = null;
		
		try {
			authentication = getAuthentication((HttpServletRequest)request);
		}
		catch(ExpiredJwtException e) {
			expired(response);
			return;
		}
		if(authentication==null) {
			forbidden(response);
		}
		else {
			try {
				authentication = authenticationManager.authenticate(authentication);
				SecurityContextHolder.getContext().setAuthentication(authentication);
				if(authentication.isAuthenticated()) {
					chain.doFilter(request, response);
				}
				else {
					forbidden(response);
				}
			}
			catch(AuthenticationException e) {
				forbidden(response);
			}
		}
		
	}
	
	public Authentication getAuthentication(HttpServletRequest request) throws ExpiredJwtException {
		String token = resolveToken(request);
		if(token!=null) {
			String username = getUserName(token);
			if(username!=null) {
				UserDetails userDetails = new UserDetails() {
					
					public Collection<? extends GrantedAuthority> getAuthorities(){
						return getRoles(token).stream().map(a->new SimpleGrantedAuthority(a))
								.collect(Collectors.toList());
					}
					public String getPassword() {
						return token;
					}
					public String getUsername() {
						return username;
					}
					public boolean isAccountNonExpired() {
						return false;
					}
					public boolean isAccountNonLocked() {
						return false;
					}
					public boolean isCredentialsNonExpired() {
						return false;
					}
					public boolean isEnabled() {
						return true;
					}
				};
				return new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
			}
		}
		return null;
	}
	
	private void forbidden(ServletResponse servletResponse) {
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		response.setStatus(HttpServletResponse.SC_FORBIDDEN);
	}
	
	private void expired(ServletResponse servletResponse) {
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		response.setStatus(HttpServletResponse.SC_FORBIDDEN);
		response.addHeader("token", "Expired");
	}
	
	private String resolveToken(HttpServletRequest request) {
		String bearerToken = request.getHeader(AUTHORIZATION);
		if(bearerToken!=null && bearerToken.startsWith(PREFIX)) {
			return bearerToken.replace(PREFIX, EMPTY);
		}
		return null;
	}
	
	private String getUserName(String token)throws ExpiredJwtException{
		return Jwts.parser().setSigningKey(SECRETKEY).parseClaimsJws(token).getBody().getSubject();
	}
	
	private List<String> getRoles(String token){
		return (List<String>)Jwts.parser().setSigningKey(SECRETKEY).parseClaimsJws(token).getBody().get("roles");
	}

}
