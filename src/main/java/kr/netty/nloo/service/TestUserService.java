package kr.netty.nloo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.netty.nloo.model.User;
import kr.netty.nloo.repository.TestUserRepository;

@Service
public class TestUserService {


	@Autowired
	private TestUserRepository systemRepository;

	public List<User> getAllUser() {
		return systemRepository.getAllUser();
	}

	public void saveUser(User user) {
		systemRepository.saveUser(user);

	}

	public void updateUser(User user) {
		systemRepository.updateUser(user);

	}

	public void deleteUser(String id) {
		systemRepository.deleteUser(id);
	}
}