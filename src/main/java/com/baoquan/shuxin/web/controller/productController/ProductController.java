package com.baoquan.shuxin.web.controller.productController;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.baoquan.shuxin.service.spi.product.ProductService;

@Controller
@RequestMapping("product")
public class ProductController {
	@Inject
	private ProductService productService;
	
}
