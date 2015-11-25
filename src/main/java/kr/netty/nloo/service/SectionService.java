package kr.netty.nloo.service;

import java.util.List;

import org.apache.ibatis.javassist.NotFoundException;

import kr.netty.nloo.model.Section;
import kr.netty.nloo.model.SectionInfo;
import kr.netty.nloo.model.SectionViewInfo;

public interface SectionService {

	public SectionInfo getInfo(Long sectionSequence);
	public SectionViewInfo getViewInfo(Long sectionSequence) throws NotFoundException;
	public Result knock(Long sectionSequence);


	public List<Section> getAllSections();

	public void saveSection(Section building);

	public void updateSection(Section building);

	public void deleteSection(Long sequence);

	public enum Result {
		SUCCESS("S001", "성공하였습니다."),// 성공
		NOT_EXIST("S002", "화장실이 없습니다.");// 해당 sectionSequence에 해당하는 화장실이 없음.

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
