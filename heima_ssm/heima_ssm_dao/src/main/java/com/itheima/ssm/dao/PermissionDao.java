package com.itheima.ssm.dao;

import com.itheima.ssm.domain.Permission;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PermissionDao {

    /**
     * 添加资源权限信息
     * @param permission
     * @throws Exception
     */
    @Insert("insert into permission (permissionName,url) values (#{permissionName},#{url})")
    public void save(Permission permission) throws Exception;

    /**
     * 查询所有资源权限信息
     * @return
     * @throws Exception
     */
    @Select("select * from permission")
    public List<Permission> findAll() throws Exception;

    /**
     * 根据id查询权限资源信息
     * @param id
     * @return
     */
    @Select("select * from permission where id in (select permissionId from role_permission where roleId =#{id})")
    public List<Permission> findPermissionByRoleId(String id) throws Exception;

}
