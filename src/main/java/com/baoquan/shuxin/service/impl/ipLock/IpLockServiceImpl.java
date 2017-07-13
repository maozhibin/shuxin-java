package com.baoquan.shuxin.service.impl.ipLock;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import com.baoquan.shuxin.bean.Page;
import com.baoquan.shuxin.dao.ipLock.IpLockDao;
import com.baoquan.shuxin.model.ipLock.IpLock;
import com.baoquan.shuxin.service.spi.ipLock.IpLockService;
@Named
public class IpLockServiceImpl implements IpLockService{
	@Inject
	private IpLockDao ipLockDao;

	@Override
	public Page<IpLock> ipLockList(Page<IpLock> page) {
		Map<String, Object> map = new HashMap<>();
		map.put("page", page);
		Integer total = ipLockDao.ipLockTotal();
		page.setTotalRecordCount(total);
		List<IpLock> list = ipLockDao.ipLockList(map);
		page.setResult(list);
		return page;
	}

	@Override
	public void debLockingIp(IpLock ipLock) {
		ipLockDao.debLockingIp(ipLock);
	}

	@Override
	public IpLock findById(Integer id) {
		return ipLockDao.findById(id);
	}
}
