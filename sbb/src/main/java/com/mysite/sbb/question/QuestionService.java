package com.mysite.sbb.question;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.context.config.ConfigDataLocationNotFoundException;
import org.springframework.stereotype.Service;

import com.mysite.sbb.DataNotFoundException;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class QuestionService {
	
	private final QuestionRepository questionRepository;
	
	public List<Question> getList() {
		return this.questionRepository.findAll();
	}
	
	//select * from question where id=2;
	public Question getQuestion(Integer id) throws DataNotFoundException {
		Optional<Question> question = this.questionRepository.findById(id);
		if(question.isPresent()) {
			return question.get();
		}else {
			throw new DataNotFoundException("question not found"); //사용자정의 예외 
		}
	
	}

	
	
	
	
	
	
	
	
	
	

}