package com.multicampus.biz.sale;

import java.sql.Timestamp;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class ProductVO {
	/* 상품번호 */
	private String prodNo;
	/* 상품명 */
	private String prodName;
	/* 판매자ID */
	private String sellerId;
	/* 카테고리 관리번호 */
	private String categoryNo;
	/* 상품상세정보 */
	private String prodDetail;
	/* 제조일자 */
	private String manufactureDay;
	/* A/S 가능여부 */
	private String asYn;
	/* 판매수량 */
	private java.math.BigDecimal sellQuantity = new java.math.BigDecimal(0);
	/* 판매금액 */
	private java.math.BigDecimal sellAmount = new java.math.BigDecimal(0);
	/* 이미지파일 */
	private String imageFile;
	/* 거래상태코드 */
	private String tranStatusCode;
	/* 등록일시 */
	private Timestamp regDate = new java.sql.Timestamp(new java.util.Date().getTime());	
    /* 파일 업로드 변수 */
    MultipartFile uploadFile;
}
