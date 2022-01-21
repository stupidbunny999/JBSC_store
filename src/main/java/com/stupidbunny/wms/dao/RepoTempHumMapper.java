package com.stupidbunny.wms.dao;

import com.stupidbunny.wms.domain.RepoTempHumDO;
import com.stupidbunny.wms.domain.RepoTempHumDTO;

import java.util.List;


@org.springframework.stereotype.Repository
public interface RepoTempHumMapper {


	List<RepoTempHumDTO> selectAll();

	List<RepoTempHumDTO> selectByID(Integer repositoryID);

	void insert(RepoTempHumDO repoTempHumDO);

}
