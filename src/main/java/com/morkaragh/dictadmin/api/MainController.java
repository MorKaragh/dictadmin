package com.morkaragh.dictadmin.api;

import jakarta.annotation.security.PermitAll;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@PermitAll
@RestController
@RequestMapping("api")
public class MainController {

    @GetMapping("test")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("hello, world");
    }


}
