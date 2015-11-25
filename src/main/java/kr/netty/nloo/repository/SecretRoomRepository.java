package kr.netty.nloo.repository;

import java.util.List;

import kr.netty.nloo.model.SecretRoom;
import kr.netty.nloo.model.SecretRoomInfo;

public interface SecretRoomRepository {

	public SecretRoom selectSecretRoom(Long secretRoomSequene);
	public Integer updateUseStats(Long secretRoomSequene);
	public Integer updateUnuseStats(Long secretRoomSequene);

	public List<SecretRoomInfo> selectSecretRoomInfo(Long sectionSequence);


	public List<SecretRoom> selectAllSecretRooms();

	public void saveSecretRoom(SecretRoom secretRoom);

	public void updateSecretRoom(SecretRoom secretRoom);

	public void deleteSecretRoom(Long sequence);
}
