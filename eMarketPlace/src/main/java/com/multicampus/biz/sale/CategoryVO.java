package com.multicampus.biz.sale;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class CategoryVO {
	
	/* 카테고리 번호 */
	private String categoryNo;

	/* 카테고리명 */
	private String categoryName;

	/* 카테고리 설명 */
	private String categoryDesc;

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
