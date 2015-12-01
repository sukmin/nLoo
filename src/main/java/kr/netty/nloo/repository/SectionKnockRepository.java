package kr.netty.nloo.repository;

public interface SectionKnockRepository {

	public int insertKnock(Long sectionSequence);

	public Long selectKnockCount(Long sectionSequence);

}
