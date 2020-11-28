package lamph11.api.router;

import java.util.Collections;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lamph11.api.dto.rest.AuthResponse;
import lamph11.api.service.JwtService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthResource {

    private AuthenticationManager authenticationManager;

    @RequestMapping("/login")
    public ResponseEntity<?> auth(
        @RequestParam String username, @RequestParam String password
    ) {
        try {
            UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
                username,
                password,
                Collections.emptyList()
            );
            Authentication result = authenticationManager.authenticate(auth);
            String token = JwtService.generateToken(result);
            AuthResponse response = new AuthResponse();
            response.setToken(token);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e);
        }
    }

}