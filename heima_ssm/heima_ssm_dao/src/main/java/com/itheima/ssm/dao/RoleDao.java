package com.itheima.ssm.dao;

import com.itheima.ssm.domain.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface RoleDao {

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
