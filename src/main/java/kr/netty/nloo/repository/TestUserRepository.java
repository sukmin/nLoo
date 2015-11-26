package kr.netty.nloo.repository;

import java.util.List;

import kr.netty.nloo.model.User;

public interface TestUserRepository {

	public List<User> getAllUser();

	public void saveUser(User user);

	public void updateUser(User user);

	public void deleteUser(String id);

}
