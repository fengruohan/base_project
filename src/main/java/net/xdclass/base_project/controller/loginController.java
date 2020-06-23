package net.xdclass.base_project.controller;


import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import net.xdclass.base_project.domain.JsonData;
import net.xdclass.base_project.domain.User;
import net.xdclass.base_project.mapper.UserMapper;
import net.xdclass.base_project.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *@作者 小D课堂  小D
 */
@Controller
@RequestMapping("/api/v1/user")
public class loginController {
	
	
	@Autowired
	private UserService userService;

	@Autowired
	private UserMapper userMapper;
	
	@GetMapping("login1")
	public String admin(ModelMap modelMap){
		
		modelMap.addAttribute("name", "yyf");
		
		return "test";  //不用加后缀，在配置文件里面已经指定了后缀
	}
	
	
}
