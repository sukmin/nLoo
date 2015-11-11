package kr.netty.nloo.service;

public interface SecretRoomService {
	
	public SecretRoomServiceResult use(Long secretRoomSequene);
	public SecretRoomServiceResult unuse(Long secretRoomSequene);

}
