package com.maven.web.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.maven.web.model.UserInfo;
import com.maven.web.service.UserInfoService;


@Controller
@RequestMapping("/redis")
public class RedisController {
	
	@Resource
	private UserInfoService userService;
	
	@ResponseBody
	@RequestMapping(value="/userInfo",method=RequestMethod.GET)
	public String getUserInfo(@RequestParam Long uid){
		UserInfo userInfo = userService.getUserInfo(uid);
		if(userInfo!=null){
			return "您要获取的用户名称是："+userInfo.getUserName();
		}
		return "获取用户信息失败";
	}

}
