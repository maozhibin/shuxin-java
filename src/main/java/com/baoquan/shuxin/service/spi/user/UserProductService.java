package com.baoquan.shuxin.service.spi.user;

import java.util.List;
import java.util.Map;

public interface UserProductService {

	List<Map<String, Object>> queryByBuyTime(String stampTimeToday);

}
