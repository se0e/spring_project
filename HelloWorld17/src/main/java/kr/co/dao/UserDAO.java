package kr.co.dao;

import kr.co.domain.LoginDTO;
import kr.co.domain.UserVO;

public interface UserDAO {
	void updatePoint(String userId,int userPoint);
	public UserVO login(LoginDTO dto);

}
