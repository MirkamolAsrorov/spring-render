package uz.mirkamol.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class UserController {
    static int userId = 1;
    static List<User> userList = new ArrayList<>(Arrays.asList(new User(userId++, "Jahongir", 23), new User(userId++, "Mirkamol", 18), new User(userId++, "Sarvar", 19)));

    @GetMapping("/")
    public String index() {
        return "Hello Uzbekistan" + "\n" +
                "for more information about User List visit: https://spring-render-09ks.onrender.com/user" + "\n" +
                "for add User visit: https://spring-render-09ks.onrender.com/addUser" + "\n" +
                "for delete User visit: https://spring-render-09ks.onrender.com/deleteUser";
    }

    @GetMapping("/user")
    public String hello() {
        return userList.toString();
    }

    @PostMapping("/addUser")
    public ResponseEntity<?> addUser(@RequestBody User requestUser) {
        User newUser = new User();
        newUser.setUserId(userId++);
        newUser.setName(requestUser.getName());
        newUser.setAge(requestUser.getAge());
        userList.add(newUser);
        return ResponseEntity.ok(newUser);
    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable int id) {
        User requestUser = userList.get(id-1);
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getName().equals(requestUser.getName())) {
                userList.remove(i);
                return ResponseEntity.ok(userList);
            }
        }
        return ResponseEntity.status(404).body("User not found");
    }
}
