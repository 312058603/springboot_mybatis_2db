package com.wpx;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootMybatisApplicationTests {

	@Test
	public void contextLoads() {
		String hashAlgorithmName = "MD5";//加密方式
		Object crdentials = "123456";//密码原值
		Object salt = "wpx";//盐值 其实就是在原始密码前面补上wpx 再进行md5加密
		int hashIterations = 1;//加密1024次
		Object result = new SimpleHash(hashAlgorithmName,crdentials,salt,hashIterations);
		System.out.println("加密后的值:"+result);
	}

}
