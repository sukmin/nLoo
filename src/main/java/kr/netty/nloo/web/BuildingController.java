package kr.netty.nloo.web;

import kr.netty.nloo.model.Building;
import kr.netty.nloo.service.BuildingService;

import java.util.List;

import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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



	@RequestMapping(value="/admin/buildings", method=RequestMethod.GET)
	public String showForm(ModelMap model){
		List<Building> buildings = buildingService.getAllBuildings();
		model.addAttribute("buildings", buildings);
		Building building = new Building();
		building.setSequence(1L);
		model.addAttribute("building", building);
		return "admin/building";
	}

	@RequestMapping(value="/admin/building/add", method=RequestMethod.POST)
	public ModelAndView add(@ModelAttribute(value="building") Building building,BindingResult result){
//		validator.validate(user, result);
		ModelAndView mv = new ModelAndView("admin/building");
		if(!result.hasErrors()){
			buildingService.saveBuilding(building);
			building = new Building();
			mv.addObject("building", building);
		}
		mv.addObject("buildings", buildingService.getAllBuildings());
		return mv;
	}

	@RequestMapping(value="/admin/building/update", method=RequestMethod.POST)
	public ModelAndView update(@ModelAttribute(value="building") Building building,BindingResult result){
//		validator.validate(user, result);
		ModelAndView mv = new ModelAndView("admin/building");
		if(!result.hasErrors()){
			buildingService.updateBuilding(building);
			building = new Building();
			mv.addObject("building", building);
		}
		mv.addObject("buildings", buildingService.getAllBuildings());
		return mv;
	}

	@RequestMapping(value="/admin/building/delete", method=RequestMethod.POST)
	public ModelAndView delete(@ModelAttribute(value="building") Building building,BindingResult result){
//		validator.validate(user, result);
		ModelAndView mv = new ModelAndView("admin/building");
		if(!result.hasErrors()){
			buildingService.deleteBuilding(building.getSequence());
			building = new Building();
			mv.addObject("building", building);
		}
		mv.addObject("buildings", buildingService.getAllBuildings());
		return mv;
	}
}
