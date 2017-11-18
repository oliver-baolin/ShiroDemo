package com.maven.web.service;

import com.maven.web.model.UserInfo;

public interface UserInfoService {

	Integer insert(UserInfo userInfo);  
	  
    Integer delete(Long uid);  
  
    UserInfo select(Long uid);
	
    /** 从缓存中获取 */  
    UserInfo getUserInfo(Long uid);  
}
