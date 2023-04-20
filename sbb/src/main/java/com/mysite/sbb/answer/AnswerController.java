package com.mysite.sbb.answer;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	public String createAnswer(@PathVariable("id") Integer id, @RequestParam String content, Model model) {
		System.out.println("id의 값은 ==> " +id);
		System.out.println("content의 값은 ==> " +content);
		
		
		Question q = this.questionService.getQuestion(id);
		System.out.println(q.getId()+"!!!!");
		this.answerService.create(q, content); //답변게시판의 자료를 저장하기 위해 서비스에 질문게시판 레코드정보(q)와 답글내용(content)를 보낸다
		return String.format("redirect:/question/detail/%s", id);
	}
	
	
	
	
}
