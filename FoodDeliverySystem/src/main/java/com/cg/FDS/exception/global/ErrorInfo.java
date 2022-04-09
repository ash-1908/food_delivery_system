package com.cg.FDS.exception.global;

import java.time.LocalDateTime;

public class ErrorInfo {

	LocalDateTime now;
	String msg;
	String url;
	
	public ErrorInfo() {
		super();
	}
	
	
	public ErrorInfo(LocalDateTime now, String msg, String url) {
		super();
		this.now = now;
		this.msg = msg;
		this.url = url;
	}


	public LocalDateTime getNow() {
		return now;
	}
	public void setNow(LocalDateTime now) {
		this.now = now;
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
		return "ErrorInfo [now=" + now + ", msg=" + msg + ", url=" + url + "]";
	}
	
}
