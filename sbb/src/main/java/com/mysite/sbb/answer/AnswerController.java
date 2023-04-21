package com.mysite.sbb.answer;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mysite.sbb.question.Question;
import com.mysite.sbb.question.QuestionService;

import lombok.RequiredArgsConstructor;

@RequestMapping("/answer")
@RequiredArgsConstructor
@Controller
public class AnswerController {

	public final QuestionService questionService;
	public final AnswerService answerService;
	
	@PostMapping("/create/{id}")
	public String createAnswer(@PathVariable("id") Integer id,  @Valid AnswerForm answerForm, BindingResult bindingResult, Model model) {
		
		 Question question = this.questionService.getQuestion(id);
	        if (bindingResult.hasErrors()) {
	            model.addAttribute("question", question);
	            return "question_detail";
	        }
	        this.answerService.create(question, answerForm.getContent());//답변게시판의 자료를 저장하기 위해 서비스에 질문게시판 레코드정보(q)와 답글내용(content)를 보낸다
	        return String.format("redirect:/question/detail/%s", id);
	        
	}
	
	
	
	
}
