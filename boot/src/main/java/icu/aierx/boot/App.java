package icu.aierx.boot;

import icu.aierx.boot.dao.UserDao;
import icu.aierx.boot.model.PageVO;
import icu.aierx.boot.model.UserVO;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

/**
 * @author leiwenyong
 * @since 2022-08-03
 */
@SpringBootApplication
@MapperScan("icu.aierx.boot.dao")
public class App {
	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(App.class);
		UserDao bean = run.getBean(UserDao.class);
		PageVO pageVO = new PageVO(2, 2);
		List<UserVO> userVOS = bean.selectAll(pageVO);
		System.exit(1);
	}
}
