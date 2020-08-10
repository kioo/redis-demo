package person.wangchi.redisdemo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import person.wangchi.redisdemo.utils.RedisUtil;

@SpringBootTest
class RedisDemoApplicationTests {

	@Autowired
	@Qualifier("redisTemplate")
	private RedisTemplate redisTemplate;

	@Autowired
	private RedisUtil redisUtil;

	// 使用工具后的方法
	@Test
	public void test1(){
		redisUtil.set("name","wanchi");
		System.out.println(redisUtil.get("name"));
	}

	@Test
	void contextLoads() {
//		redisTemplate.getConnectionFactory().getConnection();
		redisTemplate.opsForList().leftPush("person","wangchi");
		redisTemplate.opsForList().leftPush("person","doudou");

		System.out.println(redisTemplate.opsForList().leftPop("person"));
	}

	@Test
	public void test() throws JsonProcessingException {
		User user = new User("kuang", 3);
		String jsonUser = new ObjectMapper().writeValueAsString(user);
		redisTemplate.opsForValue().set("user",jsonUser);
		System.out.println(redisTemplate.opsForValue().get("user"));

	}

}
