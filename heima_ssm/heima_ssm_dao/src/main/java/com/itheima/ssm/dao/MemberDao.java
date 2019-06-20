package com.itheima.ssm.dao;

import com.itheima.ssm.domain.Member;
import org.apache.ibatis.annotations.Select;

public interface MemberDao {

    /**
     * 根据id查询会员信息
     * @param id
     * @return
     */
    @Select("select * from member where id=#{id}")
    public Member findById(String id) throws Exception;

}
