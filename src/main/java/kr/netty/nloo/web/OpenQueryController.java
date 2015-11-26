package kr.netty.nloo.web;


import java.util.List;
import java.util.Map;

import kr.netty.nloo.service.OpenQueryService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/admin")
@Controller
public class OpenQueryController {

	private static Logger logger = LoggerFactory.getLogger(OpenQueryController.class);

	@Autowired
	private OpenQueryService openQueryService;

	/**
	 * 데이터 베이스 테이블 목록 조회
	 * TODO database 명칭 파라미터 처리하기(현재는 고정)
	 * @param model
	 * @return
	 */
	@RequestMapping("/tables")
	public String tables(Model model){
		model.addAttribute("tables", openQueryService.getTables());
		return "admin/tables";
	}

	@RequestMapping("/table-info/{tableName}")
	public String tableInfo(@PathVariable("tableName") String tableName, Model model){

		model.addAttribute("tableInfo", openQueryService.getTableInfo(tableName));
		return "admin/tableInfo";
	}

	/**
	 * 전체 테이블 정보를 조회하여 model class를 생성한다
	 * TODO database, tableName 선택가능하도록 개선
	 * @param model
	 * @return
	 */
	@RequestMapping("/make-model-class")
	public String makeModelClass(Model model){

		List<Map<String, String>> list = openQueryService.getTables();
		for(Map<String, String> m : list) {
			String tableName = m.get("TABLE_NAME");
			openQueryService.getTableInfo(tableName);

			logger.debug(tableName + "...");
		}

		model.addAttribute("tables", list);

		return "admin/tables";
	}

	/**
	 * model class와 기본 select query 를 조회한다
	 * - camelCase 적용
	 *
	 * @param tableName
	 * @param model
	 * @return
	 */
	@RequestMapping("/model-and-query/{tableName}")
	public String modelAndQuery(@PathVariable("tableName") String tableName, Model model){

		model.addAttribute("resultMap", openQueryService.getModelAndQuery(tableName));

		return "admin/modelAndQuery";
	}

}
