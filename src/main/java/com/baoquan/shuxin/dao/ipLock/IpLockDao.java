package com.baoquan.shuxin.dao.ipLock;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.baoquan.shuxin.model.ipLock.IpLock;

@Repository
public interface IpLockDao {

	Integer ipLockTotal();

	List<IpLock> ipLockList(Map<String, Object> map);

	void debLockingIp(IpLock IpLock);

	IpLock findById(Integer id);
	
}