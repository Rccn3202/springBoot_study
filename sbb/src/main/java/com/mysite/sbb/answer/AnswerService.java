package com.mysite.sbb.answer;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.mysite.sbb.question.Question;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AnswerService {

	public final AnswerRepository answerRepository; //생성자 주입
	
	public void create(Question q, String content) {
		Answer answer=new Answer();
		answer.setContent(content);
		answer.setCreateDate(LocalDateTime.now());
		answer.setQuestion(q);
		this.answerRepository.save(answer);
	}

	
}
