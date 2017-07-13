package com.baoquan.shuxin.service.spi.ipLock;

import com.baoquan.shuxin.bean.Page;
import com.baoquan.shuxin.model.ipLock.IpLock;

public interface IpLockService {

	Page<IpLock> ipLockList(Page<IpLock> page);

	void debLockingIp(IpLock ipLock);

	IpLock findById(Integer id);

}
