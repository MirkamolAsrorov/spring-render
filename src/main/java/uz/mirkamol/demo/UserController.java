package uz.mirkamol.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
@RestController
@RequiredArgsConstructor
public class UserController {

     static List<User> userList = new ArrayList<>();
    @GetMapping("/user")
    public String hello() {
        return userList.toString();
    }
    @PostMapping("/addUser")
    public ResponseEntity<?> addUser(@RequestBody User requestUser) {
        User newUser = new User();
        newUser.setName(requestUser.getName());
        newUser.setAge(requestUser.getAge());
        userList.add(newUser);
        return ResponseEntity.ok(newUser);
    }
}
