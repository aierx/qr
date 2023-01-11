package icu.aierx.boot.dao;

import icu.aierx.boot.model.AtxPage;
import icu.aierx.boot.model.PageVO;
import icu.aierx.boot.model.UserVO;

import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author leiwenyong
 * @since 2022-08-03
 */
@Repository
public interface UserDao {
	
	@AtxPage
	List<UserVO> selectAll(PageVO pageVO);
	
	int insert(UserVO userVO);
	
	UserVO queryByUserName( String username);
}
