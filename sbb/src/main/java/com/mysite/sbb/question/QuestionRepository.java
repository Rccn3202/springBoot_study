package com.mysite.sbb.question;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Integer>{
  // Question 엔티티(테이블명)의 추상메소드(SQL문)를 쓰는 곳
  // <Question, Integer> Question엔티티의 @ID가 있는 컬럼의 타입	
//	Question findBySubject(String subject); // 부모 Jpa인터페이스에 없는 추상메소드를 개발자가 만들어 줌
	
	
    List<Question> findBySubject(String subject);
	// 추상메소드 만드는 것은 Jpa규칙에 따라야 한다. select에 해당되는 것은 findBy, where절은 Subject는 Question에 있는 엔티티명
	
	
	Question findByContentAndSubject(String content, String subject);
	
/*
	 select * from question
    where content like '스프링부트 JPA사용법' and
          subject like 'JPA 추상메소드 만들기' ;
-- Jpa로 고친다면  
-- 추상 메소드 선언 Question fcs =findByContentAndSubject( String content, String subject ) - QuestionRepository 선언
-- 메소드 호출 findByContentAndSubject( '스프링부트 JPA사용법','JPA 추상메소드 만들기'  ) - 비즈니스 부분(테스팅, 서비스)

*/
	List<Question> findByCreateDateBetween(LocalDateTime fromDate, LocalDateTime toDate);
	
	List<Question> findBySubjectLike(String subject);
	
	List<Question> findByContentLike(String string); 
	
	
	

	
}
