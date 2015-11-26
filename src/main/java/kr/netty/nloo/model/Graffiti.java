package kr.netty.nloo.model;

import java.util.Date;


import org.apache.ibatis.type.Alias;

@Alias("graffiti")
public class Graffiti {

	private Long sequence;
	private Long sectionSequence;
	private String comment;
	private Long likeCount;
	private Long unlikeCount;
	private String url;
	private String urlType;
	private Date regYmdt;
	private Date modifyYmdt;

	public Long getSequence() {
		return sequence;
	}

	public void setSequence(Long sequence) {
		this.sequence = sequence;
	}

	public Long getSectionSequence() {
		return sectionSequence;
	}

	public void setSectionSequence(Long sectionSequence) {
		this.sectionSequence = sectionSequence;
	}


	public Long getUseCount() {
		return likeCount;
	}

	public void setUseCount(Long useCount) {
		this.likeCount = useCount;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Long getLikeCount() {
		return likeCount;
	}

	public void setLikeCount(Long likeCount) {
		this.likeCount = likeCount;
	}

	public Long getUnlikeCount() {
		return unlikeCount;
	}

	public void setUnlikeCount(Long unlikeCount) {
		this.unlikeCount = unlikeCount;
	}

	public Date getRegYmdt() {
		return regYmdt;
	}

	public void setRegYmdt(Date regYmdt) {
		this.regYmdt = regYmdt;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUrlType() {
		return urlType;
	}

	public void setUrlType(String urlType) {
		this.urlType = urlType;
	}

	public Date getModifyYmdt() {
		return modifyYmdt;
	}

	public void setModifyYmdt(Date modifyYmdt) {
		this.modifyYmdt = modifyYmdt;
	}


}
