package com.nowcoder.community;

import com.nowcoder.community.dao.AlphaDao;
import com.nowcoder.community.dao.MessageMapper;
import com.nowcoder.community.entity.Message;
import com.nowcoder.community.service.AlphaService;
import com.nowcoder.community.service.MessageService;
import org.checkerframework.checker.units.qual.A;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class CommunityApplicationTests implements ApplicationContextAware {

	private ApplicationContext applicationContext;

	@Autowired
	private MessageService messageService;

	@Autowired
	private MessageMapper messageMapper;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}

	@Test
	public void contextLoads() {
	}

	@Test
	public void applicationTest(){
		AlphaDao ad = (AlphaDao) applicationContext.getBean("Hiber");
		System.out.println(ad.select());
	}

	@Test
	public void beanManagement(){
		AlphaService bean = applicationContext.getBean(AlphaService.class);

	}

	@Test
	public void configTest(){
		SimpleDateFormat bean = applicationContext.getBean(SimpleDateFormat.class);
		System.out.println(bean.format(new Date()));
	}

	@Autowired
	@Qualifier("Hiber")
	public AlphaDao alphaDao;
	@Test
	public void testDI(){
		System.out.println(alphaDao);
	}


	@Test
	public void testSerializer(){
		List<Message> comment = messageMapper.selectLettersVersion2("comment", 0, 100);
		System.out.println("isempty:"+comment.isEmpty());
		for (Message message : comment) {
			String content = message.getContent();
			System.out.println(content);
			System.out.println("=====");
			System.out.println(message);
		}
	}
}
