package kr.netty.nloo.web;

import kr.netty.nloo.service.BuildingService;

import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BuildingController {
	
	@Autowired
	private BuildingService buildingService;
	
	@RequestMapping(value={"/","/index"})
	public String index(Model model) throws NotFoundException{
		
		return "building";
	}

}
