package uz.pdp.werehouse.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {


    @GetMapping("/login")
    public ResponseEntity<Void> login() {


        return new ResponseEntity<>(HttpStatus.OK);
    }
}
