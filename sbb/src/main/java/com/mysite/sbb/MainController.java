package com.mysite.sbb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
	
	@GetMapping("/sbb")	//요청은 get방식으로 /sbb 를 요청한다
	@ResponseBody //응답은 문자열로 한다
	public String index() {
		System.out.println("안녕하신가");
		return "안녕하신가";
	}
	
}
