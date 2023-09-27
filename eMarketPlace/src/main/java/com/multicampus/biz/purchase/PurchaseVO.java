package com.multicampus.biz.purchase;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class PurchaseVO {

	/* 상품번호 */
	private String prodNo;
	/* 상품명 */
	private String prodName;
	/* 판매자ID */
	private String sellerId;
	/* 카테고리 관리번호 */
	private String categoryNo;
	/* 카테고리 이름 */
	private String categoryName;
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
	/* 거래상태코드명 */
	private String tranStatusCodeName;
	/* 등록일시 */
	private Timestamp regDate = new java.sql.Timestamp(new java.util.Date().getTime());
	
	/* 거래번호 */
    private String tranNo;
    /* 상품번호 */
    //private String prodNo;
    /* 판매자ID */
    //private String sellerId;
    /* 구매자ID */
    private String buyerId;
	/* 구매자명 */
	private String buyerName;
    /* 영수증발급여부 */
    private String receiptYn;
    /* 결제방식 */
    private String paymentOption;
    /* 결제방식명 */
    private String paymentOptionName;
    /* 수령자ID */
    private String receiverId;
    /* 수령자명 */
    private String receiverName;
    /* 수령자전화번호 */
    private String receiverPhone;
    /* 배송희망일자 */
    private String dlvyExpectDay;
    /* 배송주소 */
    private String dlvyAddr;
    /* 배송업체번호 */
    private String dlvyCompNo;
    /* 배송업체명 */
    private String dlvyCompName;
    /* 배송요청사항 */
    private String dlvyRequest;
    /* 거래상태코드 */
    //private String tranStatusCode;
    /* 주문일시 */
    private java.sql.Timestamp orderDate = new java.sql.Timestamp(new java.util.Date().getTime());
    /* 배송일시 */
    private java.sql.Timestamp dlvyDate = new java.sql.Timestamp(new java.util.Date().getTime());	
}
