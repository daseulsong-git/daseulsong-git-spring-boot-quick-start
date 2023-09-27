package com.multicampus.biz.user;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class UserVO {

	/* 회원 ID */
    private String userId;
    /* 회원명 */
    private String userName;
    /* 비밀번호 */
    private String password;
    /* 역할 */
    private String role;
    /* 주민번호 */
    private String ssn;
    /* 양력음력구분 */
    private String slYn;
    /* 생일 */
    private String birthDay;
    /* 휴대전화번호 */
    private String cellPhone;
    /* 주소 */
    private String addr;
    /* 이메일 */
    private String email;
    /* 이메일수신여부 */
    private String emailYn;
    /* 이미지파일 */
    private String imageFile;
    /* 등록일시 */
    private java.sql.Timestamp regDate = new java.sql.Timestamp(new java.util.Date().getTime());
    
    // 파일 업로드 변수
    MultipartFile uploadFile;
}

