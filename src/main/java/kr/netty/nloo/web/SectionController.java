package kr.netty.nloo.web;

import kr.netty.nloo.model.CommonResponse;
import kr.netty.nloo.model.SectionInfo;
import kr.netty.nloo.model.SectionViewInfo;
import kr.netty.nloo.service.SectionService;

import org.apache.ibatis.javassist.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/section")
@Controller
public class SectionController {

	private static Logger logger = LoggerFactory.getLogger(SectionController.class);

	@Autowired
	private SectionService sectionService;

	@RequestMapping("/{sectionSequence}")
	public String view(@PathVariable("sectionSequence") Long sectionSequence, Model model) throws NotFoundException {
		SectionViewInfo sectionViewInfo = sectionService.getViewInfo(sectionSequence);
		model.addAttribute("viewInfo", sectionViewInfo);
		return "section";
	}
	
	@RequestMapping("/info")
	@ResponseBody
	public SectionInfo info(@RequestParam("sectionSequence") Long sectionSequence){
		return sectionService.getInfo(sectionSequence);
	}
	
	@RequestMapping("/knock")
	@ResponseBody
	public CommonResponse knock(@RequestParam("sectionSequence") Long sectionSequence){
		SectionService.Result result = sectionService.knock(sectionSequence);
		return new CommonResponse(result);
	}

}
