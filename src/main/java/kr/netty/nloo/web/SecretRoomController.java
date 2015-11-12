package kr.netty.nloo.web;

import kr.netty.nloo.model.CommonResponse;
import kr.netty.nloo.model.CommonResponseCode;
import kr.netty.nloo.service.SecretRoomService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/secret-room")
@Controller
public class SecretRoomController {
	
	@Autowired
	private SecretRoomService secretRoomService;
	
	@RequestMapping("/use")
	@ResponseBody
	public CommonResponse useSecrertRoom(@RequestParam("secretRoomSequence") Long secretRoomSequence){
		
		SecretRoomService.Result result =  secretRoomService.use(secretRoomSequence);
		return new CommonResponse(result);
	}
	
	@RequestMapping("/unuse")
	@ResponseBody
	public CommonResponse unuseSecrertRoom(@RequestParam("secretRoomSequence") Long secretRoomSequence){
		
		SecretRoomService.Result result =  secretRoomService.unuse(secretRoomSequence);
		return new CommonResponse(result);
	}

}
