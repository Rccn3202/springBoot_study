package com.mysite.sbb.thymeleafStudy;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ThymleafExController {

	@GetMapping("/ex02")
	public String thymeleafEx02(@RequestParam(value="param1") String p1 ,
								@RequestParam(value="param2") String p2 ,
									Model model) {
		System.out.println(p1+"------"+p2+"get방식으로 자료 받음!!!!!");
		
		ItemDto itemDto = new ItemDto();
		itemDto.setItemDetail("상세 상세 설명");
		itemDto.setItemNm("테스트 상품1");
		itemDto.setPrice(10000);
		itemDto.setRegTime(LocalDateTime.now());
		model.addAttribute("itemDto", itemDto);
		model.addAttribute("p1",p1);
		model.addAttribute("p2",p2);
		return "thymeleafEx/thymeleafEx02";//templates 아래 이 이름의 패키지 안에 있는 html을 보여줘라
	}
	
	@GetMapping("/ex03")
	public String thymeleafEx03(Model model) {
		List <ItemDto> itemDtoList =new ArrayList<ItemDto>();
		for(int i=1; i<=10; i++) {
			ItemDto itemDto = new ItemDto();
			itemDto.setItemDetail("상품 상세 설명" + i);
			itemDto.setItemNm("테스트 상품" + i);
			itemDto.setPrice(10000 + i*10);
			itemDto.setRegTime(LocalDateTime.now());
			itemDtoList.add(itemDto);
		}
		model.addAttribute("itemDtoList", itemDtoList);
		return "thymeleafEx/thymeleafEx03";
	}  
	
	
}
