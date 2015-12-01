package kr.netty.nloo.web;

import kr.netty.nloo.model.Section;
import kr.netty.nloo.model.CommonResponse;
import kr.netty.nloo.model.Graffiti;
import kr.netty.nloo.model.SectionInfo;
import kr.netty.nloo.model.SectionViewInfo;
import kr.netty.nloo.service.GraffitiService;
import kr.netty.nloo.service.SectionService;

import java.util.List;

import org.apache.ibatis.javassist.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SectionController {

	private static Logger logger = LoggerFactory.getLogger(SectionController.class);

	@Autowired
	private SectionService sectionService;

	@Autowired
	private GraffitiService graffitiService;

	@RequestMapping("/section/{sectionSequence}")
	public String view(@PathVariable("sectionSequence") Long sectionSequence, Model model) throws NotFoundException {
		SectionViewInfo sectionViewInfo = sectionService.getViewInfo(sectionSequence);
		model.addAttribute("viewInfo", sectionViewInfo);

		List<Graffiti> graffitis = graffitiService.getAllGraffitis(sectionSequence);
		model.addAttribute("graffitis", graffitis);
		Graffiti graffiti = new Graffiti();
		graffiti.setSequence(1L);
		model.addAttribute("graffiti", graffiti);

		return "section";
	}

	@RequestMapping("/section/info")
	@ResponseBody
	public SectionInfo info(@RequestParam("sectionSequence") Long sectionSequence){
		return sectionService.getInfo(sectionSequence);
	}

	@RequestMapping("/section/knock")
	@ResponseBody
	public CommonResponse knock(@RequestParam("sectionSequence") Long sectionSequence){
		SectionService.Result result = sectionService.knock(sectionSequence);
		Long keyMessage = sectionService.getKnockCount(sectionSequence);
		return new CommonResponse(result, keyMessage.toString());
	}

	@RequestMapping(value="/graffiti/user-add", method=RequestMethod.POST)
	@ResponseBody
	public CommonResponse graffitiAdd(@ModelAttribute(value="graffiti") Graffiti graffiti){
		GraffitiService.Result result = graffitiService.saveGraffitiUser(graffiti);
		return new CommonResponse(result);
	}

	@RequestMapping(value="/graffiti/user-like", method=RequestMethod.POST)
	@ResponseBody
	public CommonResponse graffitiLike(@ModelAttribute(value="graffiti") Graffiti graffiti){
		GraffitiService.Result result = graffitiService.updateGraffitiLike(graffiti.getSequence());
		return new CommonResponse(result);
	}

	@RequestMapping(value="/graffiti/user-unlike", method=RequestMethod.POST)
	@ResponseBody
	public CommonResponse graffitiUnlike(@ModelAttribute(value="graffiti") Graffiti graffiti){
		GraffitiService.Result result = graffitiService.updateGraffitiUnlike(graffiti.getSequence());
		return new CommonResponse(result);
	}


	@RequestMapping(value="/admin/sections", method=RequestMethod.GET)
	public String showForm(ModelMap model){
		List<Section> sections = sectionService.getAllSections();
		model.addAttribute("sections", sections);
		Section section = new Section();
		section.setSequence(1L);
		model.addAttribute("section", section);
		return "admin/section";
	}

	@RequestMapping(value="/admin/section/add", method=RequestMethod.POST)
	public ModelAndView add(@ModelAttribute(value="section") Section section,BindingResult result){
//		validator.validate(user, result);
		ModelAndView mv = new ModelAndView("admin/section");
		if(!result.hasErrors()){
			sectionService.saveSection(section);
			section = new Section();
			mv.addObject("section", section);
		}
		mv.addObject("sections", sectionService.getAllSections());
		return mv;
	}

	@RequestMapping(value="/admin/section/update", method=RequestMethod.POST)
	public ModelAndView update(@ModelAttribute(value="section") Section section,BindingResult result){
//		validator.validate(user, result);
		ModelAndView mv = new ModelAndView("admin/section");
		if(!result.hasErrors()){
			sectionService.updateSection(section);
			section = new Section();
			mv.addObject("section", section);
		}
		mv.addObject("sections", sectionService.getAllSections());
		return mv;
	}

	@RequestMapping(value="/admin/section/delete", method=RequestMethod.POST)
	public ModelAndView delete(@ModelAttribute(value="section") Section section,BindingResult result){
//		validator.validate(user, result);
		ModelAndView mv = new ModelAndView("admin/section");
		if(!result.hasErrors()){
			sectionService.deleteSection(section.getSequence());
			section = new Section();
			mv.addObject("section", section);
		}
		mv.addObject("sections", sectionService.getAllSections());
		return mv;
	}
}
