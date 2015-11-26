package kr.netty.nloo.service;

import java.util.List;


import kr.netty.nloo.model.Graffiti;

public interface GraffitiService {

	public List<Graffiti> getAllGraffitis();

	public void saveGraffiti(Graffiti graffiti);

	public Result saveGraffitiUser(Graffiti graffiti);

	public Result updateGraffitiLike(Long sequence);

	public Result updateGraffitiUnlike(Long sequence);

	public void updateGraffiti(Graffiti graffiti);

	public void deleteGraffiti(Long sequence);


	public enum Result {
		SUCCESS("S001", "낙서는 정신건강에 도움이 됩니다. 다만 다른사람도 배려해주시길..."),// 성공
		FAIL("S002", "이상하네요.");// 해당 sectionSequence에 해당하는 화장실이 없음.

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
