package io.lombocska.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloResource {

    @GetMapping("/hello")
    public String getHello() {
        return "hello";
    }
}
