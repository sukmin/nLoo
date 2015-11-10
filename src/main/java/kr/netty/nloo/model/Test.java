package kr.netty.nloo.model;

import org.apache.ibatis.type.Alias;

@Alias("test")
public class Test {

	private Long sequence;
	private String message;

	public Test() {

	}

	public Test(Long sequence, String message) {
		this.sequence = sequence;
		this.message = message;
	}

	public Long getSequence() {
		return sequence;
	}

	public void setSequence(Long sequence) {
		this.sequence = sequence;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
