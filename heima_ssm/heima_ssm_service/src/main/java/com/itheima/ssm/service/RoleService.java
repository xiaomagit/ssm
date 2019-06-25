package com.itheima.ssm.service;

import com.itheima.ssm.domain.Permission;
import com.itheima.ssm.domain.Role;

import java.util.List;

public interface RoleService {

    /**
     * 给角色添加资源权限
     * @param roleId
     * @param permissionIds
     * @throws Exception
     */
    public void addPermissionToRole(String roleId, String[] permissionIds) throws Exception;

    /**
     * 根据id查询该角色不具有的资源权限
     * @param id
     * @return
     * @throws Exception
     */
    public List<Permission> findRoleByIdAndAllPermission(String id) throws Exception;

    /**
     * 根据id查询角色详情信息
     * @param id
     * @return
     * @throws Exception
     */
    public Role findById(String id) throws Exception;

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
