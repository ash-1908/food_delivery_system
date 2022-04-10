package com.cg.FDS.exception.global;

import java.time.LocalDateTime;

public class ErrorInfo {

	LocalDateTime time;
	String msg;
	String url;

	public ErrorInfo() {
		super();
	}

	public ErrorInfo(LocalDateTime time, String msg, String url) {
		super();
		this.time = time;
		this.msg = msg;
		this.url = url;
	}

	public LocalDateTime getNow() {
		return time;
	}

	public void setNow(LocalDateTime time) {
		this.time = time;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "ErrorInfo [time=" + time + ", msg=" + msg + ", url=" + url + "]";
	}

}
