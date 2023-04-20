package com.mysite.sbb.thymeleafStudy;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ItemDto {
	private Long id;
	  private String itemNm;
	  private Integer price;
	  private String itemDetail;
	  private String sellStartCd;
	  private LocalDateTime regTime;
	  private LocalDateTime updateTime;
}
