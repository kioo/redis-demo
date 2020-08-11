package person.wangchi.redisdemo.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import person.wangchi.redisdemo.User;

public interface UserService {
   public String setUser(User user) throws JsonProcessingException;
}
