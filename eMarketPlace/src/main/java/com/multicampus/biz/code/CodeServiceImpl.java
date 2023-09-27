package com.multicampus.biz.code;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("codeService")
public class CodeServiceImpl implements CodeService {
	
	@Autowired
	private CodeDAO codeDAO;

	public List<CodeVO> getCodeList(String codeType) throws Exception {
		try {
			return codeDAO.getCodeList(codeType);
		} catch (Exception e) {
			throw new Exception("코드 목록이 없습니다.", e);
		}
	}
}
