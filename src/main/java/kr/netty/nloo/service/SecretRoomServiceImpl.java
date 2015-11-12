package kr.netty.nloo.service;

import java.util.Objects;

import kr.netty.nloo.model.SecretRoom;
import kr.netty.nloo.repository.SecretRoomHistoryRepository;
import kr.netty.nloo.repository.SecretRoomRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SecretRoomServiceImpl implements SecretRoomService {

	private static Logger logger = LoggerFactory.getLogger(SecretRoomServiceImpl.class);

	@Autowired
	private SecretRoomRepository secretRoomRepository;

	@Autowired
	private SecretRoomHistoryRepository secretRoomHistoryRepository;

	@Override
	public Result use(Long secretRoomSequene) {

		SecretRoom room = secretRoomRepository.selectSecretRoom(secretRoomSequene);

		// 존재하지 않는 화장실일 경우를 방어
		if (Objects.isNull(room)) {
			return Result.NOT_EXIST;
		}

		// 현재 싸고있다면 진행하지 않음
		if (room.isUsed()) {
			logger.info(" {} 번 화장실은 이미 사용중", secretRoomSequene);
			return Result.ALREADY;
		}

		// 현재 싸고 있는 놈이 없다면 사용상태로 등록
		int changedRowCount = secretRoomRepository.updateUseStats(secretRoomSequene);
		if (changedRowCount == 1) {
			secretRoomHistoryRepository.insertSecretRoomHistory(secretRoomSequene);
			logger.info(" {} 번 화장실은 사용중으로 등록", secretRoomSequene);
			return Result.SUCCESS;
		} else {
			logger.info(" {} 번 화장실은 이미 사용중.조회후 등록 사이에 다른 사람이 등록한 경우", secretRoomSequene);
			return Result.ALREADY;
		}
	}

	@Override
	public Result unuse(Long secretRoomSequene) {

		SecretRoom room = secretRoomRepository.selectSecretRoom(secretRoomSequene);

		// 존재하지 않는 화장실일 경우를 방어
		if (Objects.isNull(room)) {
			return Result.NOT_EXIST;
		}

		// 현재 싸고있지 않다면 진행하지 않음
		if (room.isUnused()) {
			logger.info(" {} 번 화장실은 사용중이 아니므로, 사용중지상태로 바꿀 수 없습니다.", secretRoomSequene);
			return Result.NOT_USED;
		}

		// 현재 싸고 있는 놈이 있다면 미사용상태로 등록
		int changedRowCount = secretRoomRepository.updateUnuseStats(secretRoomSequene);
		if (changedRowCount == 1) {
			secretRoomHistoryRepository.updateEndYmdt(room.getCurrentHistorySequence());
			logger.info(" {} 번 화장실은 사용중으로 등록", secretRoomSequene);
			return Result.SUCCESS;
		} else {
			logger.info(" {} 번 화장실은 이미 사용중이 아님.조회후 등록 사이에 다른 사람이 등록한 경우", secretRoomSequene);
			return Result.NOT_USED;
		}
	}

}
