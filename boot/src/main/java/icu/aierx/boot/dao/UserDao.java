package icu.aierx.boot.dao;

import icu.aierx.boot.model.AtxPage;
import icu.aierx.boot.model.PageVO;
import icu.aierx.boot.model.UserVO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author leiwenyong
 * @since 2022-08-03
 */
@Repository
public interface UserDao {
	
	@Select("select  * from db_user")
	@AtxPage
 	List<UserVO> selectAll(PageVO pageVO);
	
	@Insert("insert into db_user (username) values(#{username})")
	int insert(UserVO userVO);
}
