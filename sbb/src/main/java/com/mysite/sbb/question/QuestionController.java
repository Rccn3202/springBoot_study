package com.mysite.sbb.question;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@RequestMapping(value="/question")
@RequiredArgsConstructor
@Controller
public class QuestionController {

	
//		@Autowired
//		QuestionRepository questionRepository;
	
	
		public final QuestionService questionService; //서비스 역할을 담당하는 객체를 Di함
	
		@GetMapping("/list")
		public String list(Model model) {
			//아래의 일을 service 클래스에게 넘겼다.
//			List<Question> questionList=this.questionRepository.findAll(); //select * from question;
			List<Question> questionList=this.questionService.getList();
			model.addAttribute("questionList",questionList); //modelandView랑 비슷
			
			return "question_list"; //템플릿 파일
		}
		
		@GetMapping(value="/detail/{id}")
		public String detail(@PathVariable("id") Integer id, Model model) {
			Question question=this.questionService.getQuestion(id);
			model.addAttribute("question",question);
			return "question_detail";
			
		}
		
}
