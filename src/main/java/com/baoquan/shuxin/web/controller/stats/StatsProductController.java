package com.baoquan.shuxin.web.controller.stats;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.baoquan.shuxin.service.spi.product.StatsProductService;

@Controller
@RequestMapping("statsProduct")
public class StatsProductController {
	@Inject
	private StatsProductService statsProductService;
	
}
