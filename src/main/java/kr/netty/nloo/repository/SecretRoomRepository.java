package kr.netty.nloo.repository;

import kr.netty.nloo.model.SecretRoom;

public interface SecretRoomRepository {
	
	public SecretRoom selectSecretRoom(Long secretRoomSequene);
	public Integer updateUseStats(Long secretRoomSequene);
	public Integer updateUnuseStats(Long secretRoomSequene);

}
