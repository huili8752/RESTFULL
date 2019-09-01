package com.lihui.restfull.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lihui.restfull.bean.User;
import com.lihui.restfull.service.UserService;

/**
 * Title: UserRestController Description: 用户数据操作接口 Version:1.0.0
 * 
 * @author pancm
 */
@RestController
@RequestMapping(value = "/api/")
public class UserRestController {
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public boolean addUser(@RequestBody User user) {
		System.out.println("开始新增..." + user.getName());
		return userService.addUser(user);
	}

	@RequestMapping(value = "/user", method = RequestMethod.PUT)
	public boolean updateUser(User user) {
		System.out.println("开始更新....");
		return userService.updateUser(user);
	}

	@RequestMapping(value = "/user", method = RequestMethod.DELETE)
	public boolean deleteUSer(@RequestParam(value = "id", required = true) int userId) {
		System.out.println("开始删除....");
		return userService.deleteUser(userId);
	}

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public User findByUserName(@RequestParam(value = "name", required = true) String username) {
		System.out.println("开始查询....");
		return userService.findUserByName(username);
	}

	@RequestMapping(value = "/userAll", method = RequestMethod.GET)
	public List<User> findByUserAge() {
		System.out.println("开始查询所有数据....");
		return userService.findAll();
	}

}
