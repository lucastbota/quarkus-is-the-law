package tech.donau.service;

import io.smallrye.jwt.build.Jwt;
import org.eclipse.microprofile.jwt.Claims;
import org.jose4j.jwk.Use;
import org.jose4j.jwt.JwtClaims;
import tech.donau.resource.User;
import tech.donau.utils.TokenUtils;

import javax.enterprise.context.RequestScoped;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static tech.donau.utils.TokenUtils.ROLE_USER;

@RequestScoped
public class TokenService {
    public String generate(User user) {
        try {
            System.out.println(String.format("creating account for %s", user));

           /* JwtClaims jwtClaims = new JwtClaims();
            jwtClaims.setIssuer("DonauTech");
            jwtClaims.setJwtId("a-123");
            jwtClaims.setSubject(user.email());
            jwtClaims.setClaim(Claims.upn.name(), user.email());
            jwtClaims.setClaim(Claims.preferred_username.name(), user.name());
            jwtClaims.setClaim(Claims.birthdate.name(), user.birthDate());
            jwtClaims.setClaim(Claims.groups.name(), List.of(ROLE_USER));
            jwtClaims.setAudience("using-jwt");
            jwtClaims.setExpirationTimeMinutesInTheFuture(1);

             String token = TokenUtils.generateTokenString(jwtClaims);*/

            String token = Jwt.issuer("DonauTech")
                    .upn(user.email())
                    .groups(Set.of("User", "Admin"))
                    .claim(Claims.birthdate.name(), user.birthDate())
                    .sign();


            System.out.println(token);

            return token;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Oops!");
        }

    }
}
