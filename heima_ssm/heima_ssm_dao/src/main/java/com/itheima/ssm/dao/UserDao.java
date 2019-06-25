package com.itheima.ssm.dao;

import com.itheima.ssm.domain.Role;
import com.itheima.ssm.domain.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserDao {

    /**
     * 给用户添加角色
     * @param userId
     * @param roleId
     * @throws Exception
     */
    @Insert("insert into users_role (userId,roleId) values (#{userId},#{roleId})")
    public void addRoleToUser(@Param("userId") String userId, @Param("roleId") String roleId) throws Exception;

    /**
     * 查询用户没有的角色
     *
     * @param userId
     * @return
     */
    @Select("select * from role where id not in (select roleId from users_role where UserId = #{userId})")
    public List<Role> findUserByIdAndAllRole(String userId) throws Exception;

    /**
     * 根据角色id查询对应的用户信息
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Select("select * from users where id in (select userId from users_role where roleId = #{id})")
    public List<UserInfo> findUserByRoleId(String id) throws Exception;

    /**
     * 根据用户id查询用户的详细信息
     *
     * @param id
     * @return
     */
    @Select("select * from users where id=#{id}")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "username", property = "username"),
            @Result(column = "email", property = "email"),
            @Result(column = "password", property = "password"),
            @Result(column = "phoneNum", property = "phoneNum"),
            @Result(column = "status", property = "status"),
            @Result(column = "id",
                    property = "roles",
                    javaType = List.class,
                    many = @Many(select = "com.itheima.ssm.dao.RoleDao.findRoleByUserId"))
    })
    public UserInfo findById(String id);

    /**
     * 根据用户名查询用户信息
     *
     * @param username
     * @return
     * @throws Exception
     */
    @Select("select * from users where username=#{username}")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "username", property = "username"),
            @Result(column = "email", property = "email"),
            @Result(column = "password", property = "password"),
            @Result(column = "phoneNum", property = "phoneNum"),
            @Result(column = "status", property = "status"),
            @Result(column = "id",
                    property = "roles",
                    javaType = List.class,
                    many = @Many(select = "com.itheima.ssm.dao.RoleDao.findRoleByUserId"))
    })
    public UserInfo findByUsername(String username) throws Exception;

    /**
     * 查询所有用户信息
     *
     * @return
     * @throws Exception
     */
    @Select("select * from users")
    public List<UserInfo> findAll() throws Exception;

    /**
     * 添加用户
     *
     * @param userInfo
     * @throws Exception
     */
    @Insert("insert into users (username,email,password,phoneNum,status) values (#{username},#{email},#{password},#{phoneNum},#{status})")
    public void save(UserInfo userInfo) throws Exception;

}
