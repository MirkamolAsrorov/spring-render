package uz.mirkamol.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@RestController
@RequiredArgsConstructor
public class UserController {

     static List<User> userList = new ArrayList<>(Arrays.asList(new User("Jahongir", 23), new User("Mirkamol", 18), new User("Sarvar", 19)));

     @GetMapping("/")
     public String index() {
         return  "Hello Uzbekistan";
     }
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

   @DeleteMapping
    public ResponseEntity<?> deleteUser(@RequestBody User requestUser) {
        User newUser = new User();
        newUser.setName(requestUser.getName());
        newUser.setAge(requestUser.getAge());
        userList.remove(newUser);
        return ResponseEntity.ok(newUser);
    }
}
