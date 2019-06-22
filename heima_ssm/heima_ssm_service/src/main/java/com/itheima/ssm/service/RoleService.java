package com.itheima.ssm.service;

import com.itheima.ssm.domain.Role;

import java.util.List;

public interface RoleService {

    /**
     * 添加角色
     * @param role
     * @throws Exception
     */
    public void save(Role role) throws Exception;

    /**
     * 查询所有角色信息
     * @return
     * @throws Exception
     */
    public List<Role> findAll() throws Exception;

}
