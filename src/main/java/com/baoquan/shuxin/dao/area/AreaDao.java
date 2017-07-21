package com.baoquan.shuxin.dao.area;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.baoquan.shuxin.model.area.Area;

@Repository
public interface AreaDao {

	List<Area> findProvince();

	List<Area> findByPid(int id);

}