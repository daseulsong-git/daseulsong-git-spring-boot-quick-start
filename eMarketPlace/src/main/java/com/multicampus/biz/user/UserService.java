package com.multicampus.biz.user;

import java.util.List;

import com.multicampus.biz.common.SearchVO;

public interface UserService {
	
	public List<UserVO> getUserList(SearchVO searchVO) throws Exception;
	
	public UserVO getUser(String userId) throws Exception;
	
	public void addUser(UserVO userVO) throws Exception;
	
	public void updateUser(UserVO userVO) throws Exception;
	
}
