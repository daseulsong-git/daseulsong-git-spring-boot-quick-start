package com.multicampus.biz.purchase;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class DeliveryCompanyVO {

	/* 배송업체 번호 */
	private String dlvyCompNo;
	/* 배송업체명 */
	private String dlvyCompName;
	/* 사업자 번호 */
	private String businessNo;	
	/* 배송업체 설명 */
	private String dlvyCompDesc;
	/* 사용 여부 */
	private String useYn;
	/* 등록자 ID */
	private String regId;
	/* 등록일시 */
	private Timestamp regDate;
	/* 수정자 ID */
	private String modifyId;
	/* 수정일시 */
	private Timestamp modifyDate;
}
