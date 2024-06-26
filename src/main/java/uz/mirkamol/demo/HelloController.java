package uz.mirkamol.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HelloController {

    private final HelloRepo helloRepo;
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
    @PostMapping("/hello")
    public ResponseEntity<?> helloPost(@RequestBody String message) {
        Hello hello = new Hello();
        hello.setMessage(message);
        helloRepo.save(hello);
        return ResponseEntity.ok(hello);
    }
}
