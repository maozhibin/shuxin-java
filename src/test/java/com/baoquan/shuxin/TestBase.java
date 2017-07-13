package com.baoquan.shuxin;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Desc:
 * Created by yongj on 7/11/2017,
 */
@RunWith(SpringJUnit4ClassRunner.class)        //此处调用Spring单元测试类
@WebAppConfiguration                        //调用javaWEB的组件，比如自动注入ServletContext Bean等等
@ContextConfiguration(locations = {"classpath:spring/application-context.xml", "classpath:spring/springmvc-servlet.xml"})//加载Spring配置文件
public class TestBase {
}
