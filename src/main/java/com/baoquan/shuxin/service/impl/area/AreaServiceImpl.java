package com.baoquan.shuxin.service.impl.area;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.baoquan.shuxin.dao.area.AreaDao;
import com.baoquan.shuxin.model.area.Area;
import com.baoquan.shuxin.service.spi.area.AreaService;

/**
 * Created by Administrator on 2017/7/20.
 */
@Named
public class AreaServiceImpl implements AreaService {
    @Inject
    private AreaDao areaDao;

	@Override
	public List<Area> findProvince() {
		return areaDao.findProvince();
	}

	@Override
	public List<Area> findByPid(int id) {
		return areaDao.findByPid(id);
	}
}
