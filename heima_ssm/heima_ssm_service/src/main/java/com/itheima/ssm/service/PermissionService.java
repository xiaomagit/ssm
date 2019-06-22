package com.itheima.ssm.service;

import com.itheima.ssm.domain.Permission;

import java.util.List;

public interface PermissionService {

    /**
     * 添加资源权限信息
     * @param permission
     * @throws Exception
     */
    public void save(Permission permission) throws Exception;

    /**
     * 查询所有资源权限信息
     * @return
     * @throws Exception
     */
    public List<Permission> findAll() throws Exception;

}
