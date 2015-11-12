package kr.netty.nloo.service;

public interface SecretRoomService {
	
	public Result use(Long secretRoomSequene);
	public Result unuse(Long secretRoomSequene);
	
	public enum Result {
		SUCCESS("SR001", "성공하였습니다."),// 신청하려고 하였는데 이미 다른 사람이 이용중
		ALREADY("SR002", "이미 사용중입니다."),// 수행작업을 성공
		NOT_EXIST("SR003", "존재하지 않는 화장실입니다."),// 존재하지 않는 화장실칸일 경우
		NOT_USED("SR004", "화장실이 사용 상태가 아닙니다."),// 사용종료 요청을 하였는데, 이미 사용종료가 된 경우
		DB_ERROR("SR005", "내부 오류로 실패하였습니다."); // 수행중 DB오류때문에 작업실패
		
		private String code;
		private String message;
		
		private Result(String code, String message) {
			this.code = code;
			this.message = message;
		}

		public String getCode() {
			return code;
		}

		public String getMessage() {
			return message;
		}
	}

}
