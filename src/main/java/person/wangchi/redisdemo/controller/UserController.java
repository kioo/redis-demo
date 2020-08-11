package person.wangchi.redisdemo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import person.wangchi.redisdemo.User;
import person.wangchi.redisdemo.service.UserService;

@RestController
public class UserController {
    @Autowired
    UserService userServiceImpl;

    @RequestMapping("/getUser")
    public String getUser() throws JsonProcessingException {
        User user = new User();
        user.setName("wangchi");
        user.setAge(30);

        return userServiceImpl.setUser(user);
    }
}
