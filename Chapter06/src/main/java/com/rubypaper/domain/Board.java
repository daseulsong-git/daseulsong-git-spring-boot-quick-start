package com.rubypaper.domain;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;
import lombok.Data;
import lombok.ToString;

@Data
@Entity 
public class Board {  
	@Id 				
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int seq;
	private String title;
	@Column(updatable = false)
	private String writer;
	private String content;	
	@Column(updatable = false)
	private Date regDate = new Date();
	@Column(updatable = false)
	private int cnt;
	
	//파일 업로드 관련 변수
	@Transient
	private MultipartFile upload;
}







