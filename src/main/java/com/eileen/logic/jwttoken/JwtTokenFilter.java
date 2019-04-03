//package com.eileen.logic.jwttoken;


//public class JwtTokenFilter extends GenericFilterBean {
//
//
//    private JwtTokenProvider jwtTokenProvider;
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//        String token = jwtTokenProvider.resolveToken((HttpServletRequest) req);
//        if (token != null && jwtTokenProvider.validateToken(token)) {
//            Authentication auth = token != null ? jwtTokenProvider.getAuthentication(token) : null;
//            SecurityContextHolder.getContext().setAuthentication(auth);
//        }
//        filterChain.doFilter(req, res);
//    }
//}
