package com.rubypaper.domain;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.TableGenerator;
import lombok.Data;

@Data
@Entity 				// 필수
//@Table(name = "BOARD")// 옵션

// 1. @SequenceGenerator(name="BOARD_SEQ_GENERATOR"
//					,sequenceName = "BOARD_SEQUENCE"
//					,initialValue = 1
//					,allocationSize = 1)

@TableGenerator(name="BOARD_SEQ_GENERATOR", table="", initialValue = 0, allocationSize =1)
public class Board {  
	@Id 				// 필수(PK 컬럼과 매핑된 변수 지정)
//	1. @GeneratedValue(strategy = GenerationType.SEQUENCE
//					,generator = "BOARD_SEQ_GENERATOR") 	// 옵션
	@GeneratedValue//(strategy = GenerationType.TABLE, generator = "BOARD_SEQ_GENERATOR") 	// 옵션
	private int seq;
	private String title;
	private String writer;
	private String content;
	private Date regDate;
	private int cnt;
	private String password;
}







