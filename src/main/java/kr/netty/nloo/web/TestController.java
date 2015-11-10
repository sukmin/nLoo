package kr.netty.nloo.web;

import java.util.List;

import kr.netty.nloo.model.Test;
import kr.netty.nloo.service.TestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
	
	@Autowired
	private TestService testService;
	
	@RequestMapping("/test")
	@ResponseBody
	public List<Test> test(){
		return testService.getAll();
	}

}
