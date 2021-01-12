package com.capgemini.market.web.contoller;

import com.capgemini.market.domain.dto.AuthenticationRequest;
import com.capgemini.market.domain.dto.AuthenticationResponse;
import com.capgemini.market.domain.service.CapgeminiUserDetailService;
import com.capgemini.market.web.security.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CapgeminiUserDetailService capgeminiUserDetailService;

    @Autowired
    private JWTUtil jwtutil;

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> createToken(@RequestBody AuthenticationRequest requestt){

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(requestt.getUsername(),requestt.getPassword()));


            UserDetails userDetails = capgeminiUserDetailService.loadUserByUsername(requestt.getUsername());
            String jwt = jwtutil.generateToken(userDetails);
            return  new ResponseEntity<>(new AuthenticationResponse(jwt),HttpStatus.OK);
        }catch (BadCredentialsException e){
            return  new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }

    }
}
