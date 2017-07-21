package com.baoquan.shuxin.service.spi.area;

import java.util.List;

import com.baoquan.shuxin.model.area.Area;

/**
 * Created by Administrator on 2017/7/20.
 */
public interface AreaService {

    List<Area> findProvince();

	List<Area> findByPid(int id);
}
