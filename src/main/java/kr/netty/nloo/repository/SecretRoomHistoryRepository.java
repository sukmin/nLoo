package kr.netty.nloo.repository;

public interface SecretRoomHistoryRepository {
	
	public Integer insertSecretRoomHistory(Long secretRoomSequene);
	public Integer updateEndYmdt(Long historySequence);

}
