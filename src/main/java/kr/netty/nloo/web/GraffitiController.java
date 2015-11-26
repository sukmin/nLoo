package kr.netty.nloo.web;

import kr.netty.nloo.model.Graffiti;
import kr.netty.nloo.service.GraffitiService;

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
public class GraffitiController {

	private static Logger logger = LoggerFactory.getLogger(GraffitiController.class);

	@Autowired
	private GraffitiService graffitiService;


	@RequestMapping(value="/admin/graffitis", method=RequestMethod.GET)
	public String showForm(ModelMap model){
		List<Graffiti> graffitis = graffitiService.getAllGraffitis(0L);
		model.addAttribute("graffitis", graffitis);
		Graffiti graffiti = new Graffiti();
		graffiti.setSequence(1L);
		model.addAttribute("graffiti", graffiti);
		return "admin/graffiti";
	}

	@RequestMapping(value="/admin/graffiti/add", method=RequestMethod.POST)
	public ModelAndView add(@ModelAttribute(value="graffiti") Graffiti graffiti,BindingResult result){
//		validator.validate(user, result);
		ModelAndView mv = new ModelAndView("admin/graffiti");
		if(!result.hasErrors()){
			graffitiService.saveGraffiti(graffiti);
			graffiti = new Graffiti();
			mv.addObject("graffiti", graffiti);
		}
		mv.addObject("graffitis", graffitiService.getAllGraffitis(0L));
		return mv;
	}

	@RequestMapping(value="/admin/graffiti/update", method=RequestMethod.POST)
	public ModelAndView update(@ModelAttribute(value="graffiti") Graffiti graffiti,BindingResult result){
//		validator.validate(user, result);
		ModelAndView mv = new ModelAndView("admin/graffiti");
		if(!result.hasErrors()){
			graffitiService.updateGraffiti(graffiti);
			graffiti = new Graffiti();
			mv.addObject("graffiti", graffiti);
		}
		mv.addObject("graffitis", graffitiService.getAllGraffitis(0L));
		return mv;
	}

	@RequestMapping(value="/admin/graffiti/delete", method=RequestMethod.POST)
	public ModelAndView delete(@ModelAttribute(value="graffiti") Graffiti graffiti,BindingResult result){
//		validator.validate(user, result);
		ModelAndView mv = new ModelAndView("admin/graffiti");
		if(!result.hasErrors()){
			graffitiService.deleteGraffiti(graffiti.getSequence());
			graffiti = new Graffiti();
			mv.addObject("graffiti", graffiti);
		}
		mv.addObject("graffitis", graffitiService.getAllGraffitis(0L));
		return mv;
	}
}
