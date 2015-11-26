package kr.netty.nloo.service;

import java.util.List;

import kr.netty.nloo.model.Graffiti;
import kr.netty.nloo.repository.GraffitiRepository;
import kr.netty.nloo.service.SectionService.Result;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GraffitiServiceImpl implements GraffitiService {

	private static final Logger logger = LoggerFactory.getLogger(GraffitiServiceImpl.class);

	@Autowired
	private GraffitiRepository graffitiRepository;


	@Override
	public List<Graffiti> getAllGraffitis(Long sectionSequence) {
		return graffitiRepository.selectAllGraffitis(sectionSequence);
	}

	@Override
	public void saveGraffiti(Graffiti graffiti) {
		graffitiRepository.saveGraffiti(graffiti);
	}

	@Override
	public Result saveGraffitiUser(Graffiti graffiti) {
		graffiti.setUrlType("NA");
		int check = graffitiRepository.saveGraffiti(graffiti);
		if(check == 1){
			return Result.SUCCESS;
		}else{
			return Result.FAIL;
		}
	}

	@Override
	public Result updateGraffitiLike(Long sequence) {

		int check = graffitiRepository.updateGraffitiLike(sequence);
		if(check == 1){
			return Result.SUCCESS;
		}else{
			return Result.FAIL;
		}
	}

	@Override
	public Result updateGraffitiUnlike(Long sequence) {

		int check = graffitiRepository.updateGraffitiUnlike(sequence);
		if(check == 1){
			return Result.SUCCESS;
		}else{
			return Result.FAIL;
		}
	}

	@Override
	public void updateGraffiti(Graffiti graffiti) {
		graffitiRepository.updateGraffiti(graffiti);
	}

	@Override
	public void deleteGraffiti(Long sequence) {
		graffitiRepository.deleteGraffiti(sequence);
	}


}
