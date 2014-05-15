package com.zendy.study;

import java.sql.SQLException;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UserDAOTest {
	
	@Test
	public void addAndGet() throws ClassNotFoundException, SQLException{
		ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);
		UserDAO dao = context.getBean("userDao", UserDAO.class);
		
		User user = new User();
		user.setId("zendy");
		user.setName("김병우");
		user.setPassword("password");

		dao.add(user);
		
//		System.out.println(user.getId() + "등록 성공");
		
		User user2 = dao.get(user.getId());
//		System.out.println(user2.getName());
		
		assertThat(user.getId(), is(user2.getId()));
		
		dao.remove(user2.getId());
//		System.out.println(" 삭제성공.");
		
	}
}
