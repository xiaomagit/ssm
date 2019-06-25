package com.itheima.ssm.service;

import com.itheima.ssm.domain.SysLog;

import java.util.List;

public interface SysLogService {

    /**
     * 添加日志
     * @param sysLog
     * @throws Exception
     */
    public void save(SysLog sysLog) throws Exception;

    /**
     * 查询所有日志信息
     * @return
     * @throws Exception
     */
    public List<SysLog> findAll() throws Exception;

}
