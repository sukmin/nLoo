package kr.netty.nloo.web;

import kr.netty.nloo.model.CommonResponse;
import kr.netty.nloo.model.SecretRoom;
import kr.netty.nloo.service.SecretRoomService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SecretRoomController {

	@Autowired
	private SecretRoomService secretRoomService;

	@RequestMapping("/secret-room/use")
	@ResponseBody
	public CommonResponse useSecrertRoom(@RequestParam("secretRoomSequence") Long secretRoomSequence){
		SecretRoomService.Result result =  secretRoomService.use(secretRoomSequence);
		return new CommonResponse(result);
	}

	@RequestMapping("/secret-room/unuse")
	@ResponseBody
	public CommonResponse unuseSecrertRoom(@RequestParam("secretRoomSequence") Long secretRoomSequence){
		SecretRoomService.Result result =  secretRoomService.unuse(secretRoomSequence);
		return new CommonResponse(result);
	}


	@RequestMapping(value="/admin/secretRooms", method=RequestMethod.GET)
	public String showForm(ModelMap model){
		List<SecretRoom> secretRooms = secretRoomService.getAllSecretRooms();
		model.addAttribute("secretRooms", secretRooms);
		SecretRoom secretRoom = new SecretRoom();
		secretRoom.setSequence(1L);
		model.addAttribute("secretRoom", secretRoom);
		return "admin/secretRoom";
	}

	@RequestMapping(value="/admin/secretRoom/add", method=RequestMethod.POST)
	public ModelAndView add(@ModelAttribute(value="secretRoom") SecretRoom secretRoom,BindingResult result){
//		validator.validate(user, result);
		ModelAndView mv = new ModelAndView("admin/secretRoom");
		if(!result.hasErrors()){
			secretRoomService.saveSecretRoom(secretRoom);
			secretRoom = new SecretRoom();
			mv.addObject("secretRoom", secretRoom);
		}
		mv.addObject("secretRooms", secretRoomService.getAllSecretRooms());
		return mv;
	}

	@RequestMapping(value="/admin/secretRoom/update", method=RequestMethod.POST)
	public ModelAndView update(@ModelAttribute(value="secretRoom") SecretRoom secretRoom,BindingResult result){
//		validator.validate(user, result);
		ModelAndView mv = new ModelAndView("admin/secretRoom");
		if(!result.hasErrors()){
			secretRoomService.updateSecretRoom(secretRoom);
			secretRoom = new SecretRoom();
			mv.addObject("secretRoom", secretRoom);
		}
		mv.addObject("secretRooms", secretRoomService.getAllSecretRooms());
		return mv;
	}

	@RequestMapping(value="/admin/secretRoom/delete", method=RequestMethod.POST)
	public ModelAndView delete(@ModelAttribute(value="secretRoom") SecretRoom secretRoom,BindingResult result){
//		validator.validate(user, result);
		ModelAndView mv = new ModelAndView("admin/secretRoom");
		if(!result.hasErrors()){
			secretRoomService.deleteSecretRoom(secretRoom.getSequence());
			secretRoom = new SecretRoom();
			mv.addObject("secretRoom", secretRoom);
		}
		mv.addObject("secretRooms", secretRoomService.getAllSecretRooms());
		return mv;
	}
}
