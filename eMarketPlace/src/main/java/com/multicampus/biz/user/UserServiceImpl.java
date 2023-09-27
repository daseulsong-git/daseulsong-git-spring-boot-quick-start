package com.multicampus.biz.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multicampus.biz.common.SearchVO;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO userDAO;
	
	public List<UserVO> getUserList(SearchVO searchVO) throws Exception {
		return userDAO.getUserList(searchVO);
	}

	public UserVO getUser(String userId) throws Exception {
		return userDAO.getUser(userId);
	}

	public void addUser(UserVO userVO) throws Exception {
		userDAO.addUser(userVO);
	}

	public void updateUser(UserVO userVO) throws Exception {
		userDAO.updateUser(userVO);	
	}

//	public boolean checkDuplication(String userId) throws Exception {
//		int count = userDAO.checkDuplication(userId);
//		return (count == 0) ? false : true;
//	}	
}
