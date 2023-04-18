package com.mysite.sbb;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer, Integer> 
//Answer 엔티티에서 처리할 추상메소드 (SQL문) 쓰는 곳
//JpaRepository가 기본적인 추상메소드는 지원해주는데 없는 추상메소드는 개발자가 만들어야한다
{

}
