package com.stupidbunny.wms.common.service.Interface;

import com.stupidbunny.wms.domain.RepoTempHumDO;
import com.stupidbunny.wms.domain.RepoTempHumDTO;
import com.stupidbunny.wms.exception.RepoTempHumServiceException;

import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * Created by wenka on 2021/5/30.
 */
public interface RepoTempHumService {

    Map<String, Object> selectById(Integer repositoryId,int offset, int limit) throws RepoTempHumServiceException;

    Map<String, Object> selectAll(int offset, int limit) throws RepoTempHumServiceException;

    boolean addRepoTempHumRecord(RepoTempHumDO repoTempHumDO) throws RepoTempHumServiceException;

    public File exportRecord(List<RepoTempHumDTO> rows);
}
