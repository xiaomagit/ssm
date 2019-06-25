package com.itheima.ssm.dao;

import com.itheima.ssm.domain.Permission;
import com.itheima.ssm.domain.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface RoleDao {

    /**
     * 为角色添加资源权限信息
     * @param roleId
     * @param permissionId
     * @throws Exception
     */
    @Insert("insert into role_permission (roleId,permissionId) values (#{roleId},#{permissionId})")
    public void addPermissionToRole(@Param("roleId") String roleId, @Param("permissionId") String permissionId) throws Exception;

    /**
     * 查询该角色不拥有的权限
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Select("select * from permission where id not in (select permissionId from role_permission where roleId = #{id})")
    public List<Permission> findRoleByIdAndAllPermission(String id) throws Exception;

    /**
     * 根据permissionId查询对应的角色信息
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Select("select * from role where id in (select roleId from role_permission where permissionId = #{id})")
    public List<Role> findRoleByPermissionId(String id) throws Exception;

    /**
     * 查询角色详情
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Select("select * from role where id = #{id}")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "roleName", property = "roleName"),
            @Result(column = "roleDesc", property = "roleDesc"),
            @Result(column = "id", property = "permissions", javaType = List.class, many = @Many(select = "com.itheima.ssm.dao.PermissionDao.findPermissionByRoleId")),
            @Result(column = "id", property = "users", javaType = List.class, many = @Many(select = "com.itheima.ssm.dao.UserDao.findUserByRoleId"))
    })
    public Role findById(String id) throws Exception;

    /**
     * 添加角色
     *
     * @param role
     * @throws Exception
     */
    @Insert("insert into role (roleName,roleDesc) values (#{roleName},#{roleDesc})")
    public void save(Role role) throws Exception;

    /**
     * 查询所有角色信息
     *
     * @return
     * @throws Exception
     */
    @Select("select * from role")
    public List<Role> findAll() throws Exception;

    /**
     * 根据id查询角色信息
     *
     * @param userId
     * @return
     * @throws Exception
     */
    @Select("select * from role where id in (select roleId from users_role where userId = #{userId})")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "roleName", property = "roleName"),
            @Result(column = "roleDesc", property = "roleDesc"),
            @Result(column = "id",
                    property = "permissions",
                    javaType = List.class,
                    many = @Many(select = "com.itheima.ssm.dao.PermissionDao.findPermissionByRoleId"))
    })
    public List<Role> findRoleByUserId(String userId) throws Exception;

}
