package com.stupidbunny.wms.common.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.stupidbunny.wms.common.service.Interface.RepoTempHumService;
import com.stupidbunny.wms.common.util.ExcelUtil;
import com.stupidbunny.wms.dao.RepoTempHumMapper;
import com.stupidbunny.wms.domain.RepoTempHumDO;
import com.stupidbunny.wms.domain.RepoTempHumDTO;
import com.stupidbunny.wms.exception.RepoTempHumServiceException;
import com.stupidbunny.wms.util.aop.UserOperation;
import org.apache.ibatis.exceptions.PersistenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wenka on 2021/5/30.
 */
@Service
public class RepoTempHumServiceImpl implements RepoTempHumService {

    @Autowired
    RepoTempHumMapper repoTempHumMapper;
    @Autowired
    private ExcelUtil excelUtil;

    @Override
    public Map<String, Object> selectById(Integer repositoryId, int offset, int limit) throws RepoTempHumServiceException{
        // 初始化结果集
        Map<String, Object> resultSet = new HashMap<>();
        List<RepoTempHumDTO> repositories;
        long total = 0;
        boolean isPagination = true;

        // validate
        if (offset < 0 || limit < 0)
            isPagination = false;
        //query
        try {
            if (isPagination) {
                PageHelper.offsetPage(offset, limit);
                repositories = repoTempHumMapper.selectByID(repositoryId);
                if (repositories != null) {
                    PageInfo<RepoTempHumDTO> pageInfo = new PageInfo<>(repositories);
                    total = pageInfo.getTotal();
                } else
                    repositories = new ArrayList<>();
            } else {
                repositories = repoTempHumMapper.selectByID(repositoryId);
                if (repositories != null)
                    total = repositories.size();
                else
                    repositories = new ArrayList<>();
            }
        } catch (PersistenceException e) {
            throw new RepoTempHumServiceException(e);
        } catch (Exception e1){
            e1.printStackTrace();
            throw new RepoTempHumServiceException(e1);
        }

        resultSet.put("data", repositories);
        resultSet.put("total", total);
        return resultSet;
    }

    @Override
    public Map<String, Object> selectAll(int offset, int limit) throws RepoTempHumServiceException{
        // 初始化结果集
        Map<String, Object> resultSet = new HashMap<>();
        List<RepoTempHumDTO> repositories;
        long total = 0;
        boolean isPagination = true;

        // validate
        if (offset < 0 || limit < 0)
            isPagination = false;
        //query
        try {
            if (isPagination) {
                PageHelper.offsetPage(offset, limit);
                repositories = repoTempHumMapper.selectAll();
                if (repositories != null) {
                    PageInfo<RepoTempHumDTO> pageInfo = new PageInfo<>(repositories);
                    total = pageInfo.getTotal();
                } else
                    repositories = new ArrayList<>();
            } else {
                repositories = repoTempHumMapper.selectAll();
                if (repositories != null)
                    total = repositories.size();
                else
                    repositories = new ArrayList<>();
            }
        } catch (PersistenceException e) {
            e.printStackTrace();
            throw new RepoTempHumServiceException(e);
        } catch (Exception e1){
            e1.printStackTrace();
            throw new RepoTempHumServiceException(e1);
        }

        resultSet.put("data", repositories);
        resultSet.put("total", total);
        return resultSet;
    }

    @UserOperation(value = "添加仓库温湿度信息")
    @Override
    public boolean addRepoTempHumRecord(RepoTempHumDO repoTempHumDO) throws RepoTempHumServiceException {
        // 插入一条新的记录
        if (repoTempHumDO != null) {
            try {
                // 有效性验证
                if (repoTempHumCheck(repoTempHumDO)){
                    repoTempHumMapper.insert(repoTempHumDO);
                    return true;
                }
            } catch (PersistenceException e) {
                throw new RepoTempHumServiceException(e);
            } catch (Exception e1){
                e1.printStackTrace();
                throw new RepoTempHumServiceException(e1);
            }
        }
        return false;
    }

    @UserOperation(value = "导出仓库温湿度信息")
    @Override
    public File exportRecord(List<RepoTempHumDTO> rows) {
        if (rows == null)
            return null;

        // 导出为文件
        return excelUtil.excelWriter(RepoTempHumDTO.class, rows);
    }

    private boolean  repoTempHumCheck(RepoTempHumDO repoTempHumDO) {
        return repoTempHumDO.getRepoID() != null && repoTempHumDO.getRepoAdminID() != null && repoTempHumDO.getTemp() != null && repoTempHumDO.getHum() != null && repoTempHumDO.getCreateTime() != null;
    }
}
