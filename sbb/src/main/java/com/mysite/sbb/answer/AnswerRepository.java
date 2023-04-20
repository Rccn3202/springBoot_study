package com.mysite.sbb.answer;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer, Integer>{

	Optional<Answer> findByQuestionId(int questionId);
  //Answer 엔티티의 처리할 추상메소드 (SQL문) 쓰는 곳
	//JpaRepository가 기본적인 추상메소드는 지워내주는데 없는 추상메소드는 개발자가 만들어 쓴다.
	// List<Answer> findByAnswerContentOrSubject( );

	//List<Answer> findByContentLike(String string);





	List<Answer> findByIdIn(Integer[] integers);

	List<Answer> findByContentLike(String string);
}
