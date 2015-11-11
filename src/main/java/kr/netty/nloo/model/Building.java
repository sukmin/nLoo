package kr.netty.nloo.model;

import org.apache.ibatis.type.Alias;

@Alias("building")
public class Building {

	private Long sequence;
	private String name;

	public Long getSequence() {
		return sequence;
	}

	public void setSequence(Long sequence) {
		this.sequence = sequence;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
