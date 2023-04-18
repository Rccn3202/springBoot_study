package com.mysite.sbb;

import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Integer> 
//Question 엔티티(테이블명)의 추상메소드(QAL문)를 쓰는 곳
//<저장소를 쓸 엔티티(Question), primary key 속성>
{
	
	
}
