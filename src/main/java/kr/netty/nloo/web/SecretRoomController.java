package kr.netty.nloo.web;

import kr.netty.nloo.model.CommonResponse;
import kr.netty.nloo.model.CommonResponseCode;
import kr.netty.nloo.service.SecretRoomService;
import kr.netty.nloo.service.SecretRoomServiceResult;

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
		
		SecretRoomServiceResult result =  secretRoomService.use(secretRoomSequence);
		
		if( result == SecretRoomServiceResult.SUCCESS ){
			return new CommonResponse(CommonResponseCode.SECRET_ROOM_SUCCESS);
		} else if( result == SecretRoomServiceResult.ALREADY ){
			return new CommonResponse(CommonResponseCode.SECRET_ROOM_ALREADY);
		} else if( result == SecretRoomServiceResult.NOT_EXIST ){
			return new CommonResponse(CommonResponseCode.SECRET_ROOM_NOT_EXIST);
		} else{
			return new CommonResponse(CommonResponseCode.SECRET_ROOM_INTERNAL_ERROR);
		}
	}
	
	@RequestMapping("/unuse")
	@ResponseBody
	public CommonResponse unuseSecrertRoom(@RequestParam("secretRoomSequence") Long secretRoomSequence){
		
		SecretRoomServiceResult result =  secretRoomService.unuse(secretRoomSequence);
		
		if( result == SecretRoomServiceResult.SUCCESS ){
			return new CommonResponse(CommonResponseCode.SECRET_ROOM_SUCCESS);
		} else if( result == SecretRoomServiceResult.NOT_USED ){
			return new CommonResponse(CommonResponseCode.SECRET_ROOM_NOT_USED);
		} else if( result == SecretRoomServiceResult.NOT_EXIST ){
			return new CommonResponse(CommonResponseCode.SECRET_ROOM_NOT_EXIST);
		} else{
			return new CommonResponse(CommonResponseCode.SECRET_ROOM_INTERNAL_ERROR);
		}
	}

}
