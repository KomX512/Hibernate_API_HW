package org.main.hibernate_api.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/hi")
public class TestHiController {

    @GetMapping
    public ResponseEntity<String> sayHi() {
        return ResponseEntity.ok("HI! <br><pr>" + LocalDateTime.now());
    }

}
