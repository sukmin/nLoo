package kr.netty.nloo.web;

import org.apache.ibatis.javassist.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
	
	private static Logger logger = LoggerFactory.getLogger(ExceptionController.class);

	@ExceptionHandler(NotFoundException.class)
	public String notFoundException(Exception e){
		logger.error("NotFoundException",e);
		return "error";
	}
	
}
