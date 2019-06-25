package com.itheima.ssm.service;

import com.itheima.ssm.domain.Role;
import com.itheima.ssm.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    /**
     * 给用户添加角色
     * @param userId
     * @param roleIds
     * @throws Exception
     */
    public void addRoleToUser(String userId, String[] roleIds) throws Exception;

    /**
     * 查询用户不具有的角色
     * @param userId
     * @return
     */
    public List<Role> findUserByIdAndAllRole(String userId) throws Exception;

    /**
     * 查询用户详细信息
     * @param id
     * @return
     */
    public UserInfo findById(String id) throws Exception;

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
