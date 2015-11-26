package kr.netty.nloo.repository;

import java.util.List;

import kr.netty.nloo.model.Graffiti;

public interface GraffitiRepository {

	public List<Graffiti> selectAllGraffitis();

	public Integer saveGraffiti(Graffiti graffiti);

	public Integer updateGraffitiLike(Long sequence);
	public Integer updateGraffitiUnlike(Long sequence);
	public void updateGraffiti(Graffiti graffiti);

	public void deleteGraffiti(Long sequence);
}
