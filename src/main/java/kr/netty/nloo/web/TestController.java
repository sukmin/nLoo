package kr.netty.nloo.web;

import java.util.List;

import kr.netty.nloo.model.Test;
import kr.netty.nloo.service.TestService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
	
	private static Logger logger = LoggerFactory.getLogger(TestController.class);
	
	@Autowired
	private TestService testService;
	
	@RequestMapping("/test")
	@ResponseBody
	public List<Test> test(){
		logger.info("i need money");
		return testService.getAll();
	}

}
