package kr.netty.nloo.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.netty.nloo.model.Building;
import kr.netty.nloo.model.Test;
import kr.netty.nloo.service.OpenQueryService;
import kr.netty.nloo.service.SystemService;
import kr.netty.nloo.service.TestService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

	private static Logger logger = LoggerFactory.getLogger(TestController.class);

	@Autowired
	private TestService testService;


	@Autowired
	private OpenQueryService openQueryService;

	@RequestMapping("/test")
	@ResponseBody
	public List<Test> test(){
		logger.info("i need money");
		return testService.getAll();
	}

	@RequestMapping("/test-jsp")
	public String testJsp(Model model){
		model.addAttribute("hello", "안녕");
		return "test";
	}

	@RequestMapping("/tables")
	public String tables(Model model){
		model.addAttribute("tables", openQueryService.getTables());
		return "tables";
	}


	@RequestMapping("/make-model-class")
	public String makeModelClass(Model model){

		List<Map<String, String>> list = openQueryService.getTables();
		for(Map<String, String> m : list) {
			String tableName = m.get("TABLE_NAME");
			openQueryService.getTableInfo(tableName);

			logger.debug(tableName + "...");
		}

		model.addAttribute("tables", list);

		return "tables";
	}

	@RequestMapping("/table-info/{tableName}")
	public String tableInfo(@PathVariable("tableName") String tableName, Model model){

		model.addAttribute("tableInfo", openQueryService.getTableInfo(tableName));
		return "tableInfo";
	}


	@RequestMapping("/model-and-query/{tableName}")
	public String modelAndQuery(@PathVariable("tableName") String tableName, Model model){

		model.addAttribute("resultMap", openQueryService.getModelAndQuery(tableName));

		return "modelAndQuery";
	}

	@Autowired
	private SystemService systemService;

//	@ResponseBody
	@RequestMapping(value="/admin/buildings", method=RequestMethod.POST)
	public String addBuilding(@ModelAttribute Building building, Model model){
		int buildingSeq = systemService.insertBuild(building);
		logger.debug("buildingSeq : {}",buildingSeq);

		model.addAttribute("tables", openQueryService.getTables());
		return "tables";
	}


}
