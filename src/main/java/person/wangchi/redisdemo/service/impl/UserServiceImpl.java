package person.wangchi.redisdemo.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import person.wangchi.redisdemo.User;
import person.wangchi.redisdemo.service.UserService;
import person.wangchi.redisdemo.utils.RedisUtil;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public String setUser(User user) throws JsonProcessingException {

        String jsonUser = new ObjectMapper().writeValueAsString(user);
        redisUtil.set(user.getName(),jsonUser);
        return redisUtil.get(user.getName()).toString();

    }
}
