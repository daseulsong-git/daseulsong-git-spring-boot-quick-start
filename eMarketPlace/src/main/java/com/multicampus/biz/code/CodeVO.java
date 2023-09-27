package com.multicampus.biz.code;

import lombok.Data;

@Data
public class CodeVO {
    private String codeType;
    private String code;
    private String codeName;
    private String codeDesc;
    private String regId;
    private java.sql.Timestamp regDate;		
}
