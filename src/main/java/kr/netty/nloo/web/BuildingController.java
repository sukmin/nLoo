package kr.netty.nloo.web;

import kr.netty.nloo.service.BuildingService;

import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BuildingController {

	@Autowired
	private BuildingService buildingService;

	@RequestMapping(value={"/","/index","/index/{sequence}"})
	public String index(@PathVariable("sequence") Long sequence,Model model) throws NotFoundException{
		if(sequence == null) {
			sequence = 1L;
		}
		model.addAttribute("viewInfo", buildingService.getViewInfo(sequence));
		return "building";
	}

}
