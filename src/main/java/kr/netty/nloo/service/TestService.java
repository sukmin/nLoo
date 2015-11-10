package kr.netty.nloo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.netty.nloo.model.Test;
import kr.netty.nloo.repository.TestRepository;

@Service
public class TestService {
	
	@Autowired
	private TestRepository testRepository;
	
	public List<Test> getAll(){
		return testRepository.selectAll();
		
	}

}
