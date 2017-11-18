package com.maven.web.service.impl;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.maven.web.mapper.UserInfoMapper;
import com.maven.web.model.UserInfo;
import com.maven.web.redis.RedisService;
import com.maven.web.service.UserInfoService;
import com.maven.web.util.JsonUtils;

@Service
@Transactional
public class UserInfoServiceImpl implements UserInfoService {

	@Autowired  
    private UserInfoMapper userInfoMapper;  
	@Autowired
	private RedisService redisService;
	
	public static final String USER_INFO = "uid";
  
    public Integer insert(UserInfo userInfo) {  
        return userInfoMapper.insertSelective(userInfo);  
    }  
  
    public Integer delete(Long uid) {  
        return userInfoMapper.deleteByPrimaryKey(uid);  
    }  
  
    public UserInfo select(Long uid) {  
        return userInfoMapper.selectByPrimaryKey(uid);  
    }  
    
    public UserInfo getUserInfo(Long uid) {  
        String json = redisService.get(USER_INFO+uid);  
        if(json==null){  
            UserInfo userInfo = select(uid);  
            if(userInfo!=null){  
                redisService.put(USER_INFO+uid, userInfo, 1, TimeUnit.HOURS);  
            }  
            return userInfo;  
        }  
  
        return JsonUtils.fromJson(json, UserInfo.class);  
    }  
	
}
