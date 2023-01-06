package ru.autohelp.server;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
class ServerApplicationTests{

	@Test
	void contextLoads() {
		Assert.notEmpty(new Object[]{1, "1", '1'});
	}

}
