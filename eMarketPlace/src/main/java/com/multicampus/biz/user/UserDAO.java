package com.multicampus.biz.user;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.multicampus.biz.common.SearchVO;

@Repository
public class UserDAO {
	
	@Autowired
	private SqlSessionTemplate myBatis;
	
	public void addUser(UserVO userVO) throws Exception {
		myBatis.insert("User.addUser", userVO);
	}

	public void updateUser(UserVO userVO) throws Exception {
		myBatis.update("User.updateUser", userVO);
	}
	
	public UserVO getUser(String userId) throws Exception {
		return (UserVO) myBatis.selectOne("User.getUser", userId);
	}
	
	public List<UserVO> getUserList(SearchVO searchVO) throws Exception {
		if(searchVO.getSearchCondition() == null) searchVO.setSearchCondition("0");
		if(searchVO.getSearchKeyword() == null) searchVO.setSearchKeyword("");
		
		UserVO userVO = new UserVO();
		if(searchVO.getSearchCondition().equals("") || searchVO.getSearchCondition().equals("0")) 
			userVO.setUserId(searchVO.getSearchKeyword());
		else 
			userVO.setUserName(searchVO.getSearchKeyword());		
		
		return myBatis.selectList("User.getUserList", userVO);
	}
}
