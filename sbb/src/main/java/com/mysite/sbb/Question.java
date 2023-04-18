package com.mysite.sbb;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //자동으로 IDENTITY 값을 생성
	private Integer id; //글번호 @Id primary key라는 뜻, @GeteratedValues~는 auto_increment
	
	@Column(length = 200)
	private String subject; //제목
	
	@Column(columnDefinition = "TEXT")
	private String content; //내용
	
	
	private LocalDateTime createDate; //작성일
	
	@OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
	private List<Answer> answerList;
	
}
