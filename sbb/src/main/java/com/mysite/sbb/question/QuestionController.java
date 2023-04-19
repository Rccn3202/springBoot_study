package com.mysite.sbb.question;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class QuestionController {

	
		@Autowired
		QuestionRepository questionRepository;
	
		@GetMapping("/question/list")
		public String list(Model model) {
			List<Question> questionList=this.questionRepository.findAll(); //select * from question;
			model.addAttribute("viewData",questionList); //modelandView랑 비슷
			
			return "question_list"; //템플릿 파일
		}
}
