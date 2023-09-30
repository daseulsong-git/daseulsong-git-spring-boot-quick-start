package com.multicampus.biz.code;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CodeDAO {
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public List<CodeVO> getCodeList(String codeType) throws Exception {
		return mybatis.selectList("Code.getCodeList", codeType);
	}
}
