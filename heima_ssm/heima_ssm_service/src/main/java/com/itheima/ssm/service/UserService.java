package com.itheima.ssm.service;

import com.itheima.ssm.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    /**
     * 查询用户详细信息
     * @param id
     * @return
     */
    public UserInfo findById(String id);

    /**
     * 查询用户所有信息
     * @return
     * @throws Exception
     */
    public List<UserInfo> findAll() throws Exception;

    /**
     * 添加用户
     * @param userInfo
     * @throws Exception
     */
    public void save(UserInfo userInfo) throws Exception;

}
