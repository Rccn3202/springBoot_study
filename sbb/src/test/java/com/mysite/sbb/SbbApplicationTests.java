package com.mysite.sbb;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SbbApplicationTests {

	@Autowired
	private QuestionRepository questionRepository;

	@Test
	void contextLoads() {
		Question q1 = new Question();
		q1.setSubject("sbb subject");
		q1.setContent("sbb content");
		q1.setCreateDate(LocalDateTime.now());
		this.questionRepository.save(q1);
		
		Question q2 = new Question();
		q2.setSubject("sbb subject");
		q2.setContent("sbb content");
		q2.setCreateDate(LocalDateTime.now());
		this.questionRepository.save(q2);
	}
	
	@Test
	void testJpa() {
		List<Question> all = this.questionRepository.findAll();
		System.out.println(all.get(0) + "test!!");
		assertEquals(14, all.size()); //(기대값, 실제처리값)
	}
	
	@Test
	void testJpaFindById() {
		Optional<Question> oq = this.questionRepository.findById(2);
		if(oq.isPresent()) {
			Question q=oq.get();
			assertEquals("sbb subject2", q.getSubject());
			
		}
	}

	

}
