package 
com.baoquan.shuxin.service.impl.config;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import com.baoquan.shuxin.bean.Page;
import com.baoquan.shuxin.dao.config.ConfigDao;
import com.baoquan.shuxin.model.config.Config;
import com.baoquan.shuxin.service.spi.config.ConfigService;

@Named
public class ConfigServiceImpl implements ConfigService{
	@Inject
	private ConfigDao configDao;

	@Override
	public Page<Config> configList(Page<Config> page) {
		Map<String, Object> map = new HashMap<>();
		map.put("page", page);
		Integer total = configDao.configTotal();
		page.setTotalRecordCount(total);
		List<Config> list = configDao.configList(map);
		page.setResult(list);
		return page;
	}

	@Override
	public void updateConfig(Config config) {
		configDao.updateConfig(config);
	}

	@Override
	public void insertConfig(Config config) {
		configDao.insertConfig(config);
	}

	@Override
	public Config findByIdConfig(Integer id) {
		return configDao.findByIdConfig(id);
	}

	@Override
	public void deleteConfig(Config config) {
		configDao.deleteConfig(config);
	}

}
