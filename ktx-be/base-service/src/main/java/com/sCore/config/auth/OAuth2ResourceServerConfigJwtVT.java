//package com.sCore.config.auth;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.sCore.config.jwt.JwtService;
//import org.apache.commons.codec.binary.Base64;
//import org.jose4j.jwe.JsonWebEncryption;
//import org.jose4j.jwk.JsonWebKey;
//import org.jose4j.jws.JsonWebSignature;
//import org.jose4j.keys.AesKey;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
//import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
//import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
//import org.springframework.security.oauth2.provider.token.TokenStore;
//import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
//import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//import java.nio.charset.StandardCharsets;
//import java.security.Key;
//import java.util.HashMap;
//import java.util.Map;
//
//@Configuration
//@EnableResourceServer
//public class OAuth2ResourceServerConfigJwtVT extends ResourceServerConfigurerAdapter {
//    public static final Logger LOGGER = LoggerFactory.getLogger(OAuth2ResourceServerConfigJwtVT.class);
//    @Autowired
//    private VfAccessTokenConverter vftAccessTokenConverter;
//
//    @Autowired
//    JwtService jwtService;
//
//    @Autowired
//    JwtAuthenticationFilter jwtAuthenticationFilter;
//
//    @Autowired
//    AuthenticationProvider authenticationProvider;
//
//
//    @Override
//    public void configure(final HttpSecurity http) throws Exception {
//        // @formatter:off
//        // Dung de test tien trinh dong bo
//    	//http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED).and().authorizeRequests().anyRequest().permitAll();
//    	// @formatter:off
//        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
//                .and().authorizeRequests()
//                .antMatchers("/v1/auth/login").permitAll()
//                .antMatchers("/v1/users/token-infor").permitAll()
//                .antMatchers("/**").authenticated()
////                .antMatchers("/**").permitAll();
//                .and()
//                .authenticationProvider(authenticationProvider)
//                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
//        // @formatter:on
//        http.headers().frameOptions().disable();
//        // @formatter:on
//    }
//
//    @Override
//    public void configure(final ResourceServerSecurityConfigurer config) {
//        config.tokenServices(tokenServices()).resourceId("rest_api");
//    }
//
//    @Bean
//    public TokenStore tokenStore() {
//        return new JwtTokenStore(jwtAccessTokenConverter());
//    }
//
//    @Bean
//    public JwtAccessTokenConverter jwtAccessTokenConverter() {
//        JwtJweAccessTokenConverter converter = new JwtJweAccessTokenConverter();
//        converter.setAccessTokenConverter(vftAccessTokenConverter);
//        converter.setEncryptionKey("rle6pMmf5eWeix5LHm2sil_aP8WWl3IB8RtMWsRw1vs");
//        converter.setSigningKey("ahN47WHSA3-_I7wAcfQ7W2qyTKMeQrbDBYJQoENpGeTs8xLWddVPaMfqgC_e_UboPB9wJluMVC3M8CtoBKt7Ow");
//        return converter;
//    }
//
//    @Bean
//    @Primary
//    public DefaultTokenServices tokenServices() {
//        final DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
//        defaultTokenServices.setTokenStore(tokenStore());
//        return defaultTokenServices;
//    }
//
//    class JwtJweAccessTokenConverter extends JwtAccessTokenConverter {
//
//        String signingKey;
//        String encryptionKey;
//
//        public JwtJweAccessTokenConverter() {
//            super();
//        }
//
//        public void setSigningKey(String signingKey) {
//            this.signingKey = signingKey;
//        }
//
//        public void setEncryptionKey(String encryptionKey) {
//            this.encryptionKey = encryptionKey;
//        }
//
////        @SuppressWarnings("unchecked")
////        @Override
////        protected Map<String, Object> decode(String token) {
////            Map<String, Object> decoderObject = new HashMap<>();
////            try {
////                Key key = new AesKey(signingKey.getBytes(StandardCharsets.UTF_8));
////
////                final JsonWebSignature jws = new JsonWebSignature();
////                jws.setCompactSerialization(token);
////                jws.setKey(key);
////                if (!jws.verifySignature()) {
////                    throw new Exception("JWT verification failed");
////                }
////                final byte[] decodedBytes = Base64
////                        .decodeBase64(jws.getEncodedPayload().getBytes(StandardCharsets.UTF_8));
////                final String decodedPayload = new String(decodedBytes, StandardCharsets.UTF_8);
////
////                final JsonWebEncryption jwe = new JsonWebEncryption();
////                final JsonWebKey jsonWebKey = JsonWebKey.Factory
////                        .newJwk("\n" + "{\"kty\":\"oct\",\n" + " \"k\":\"" + encryptionKey + "\"\n" + "}");
////                jwe.setCompactSerialization(decodedPayload);
////                jwe.setKey(new AesKey(jsonWebKey.getKey().getEncoded()));
////                String jwtString = jwe.getPlaintextString();
////                ObjectMapper mapper = new ObjectMapper();
////                decoderObject = mapper.readValue(jwtString, Map.class);
////                if (decoderObject.get("exp") != null) {
////                    decoderObject.put("exp", Long.valueOf(decoderObject.get("exp").toString()));
////                }
////                if (decoderObject.get("iat") != null) {
////                    decoderObject.put("iat", Long.valueOf(decoderObject.get("iat").toString()));
////                }
////                decoderObject.put("user_name", decoderObject.get("userName"));
////                decoderObject.put("oauth2-resource", decoderObject.get("aud"));
////                decoderObject.remove("userName");
////                decoderObject.remove("aud");
////            } catch (Exception ex) {
////                LOGGER.error("loi xay ra:", ex);
////            }
////            return decoderObject;
////        }
//
////        @Override
////        protected Map<String, Object> decode(String token) {
////            Map<String, Object> decoderObject = new HashMap<>();
////            jwtService.isTokenValid(token);
////
////            return decoderObject;
////        }
//    }
//}
