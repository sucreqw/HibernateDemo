package com.sucre.hibernateDemo.entity;

import java.util.Date;
/**
 * 这是一个对应数据表的user类,POJO简单java类
 * @author sucre
 *
 */
public class User {
    private int id;
    private String token;
    private Date regday;
    private String regip;
    private String uid;
    private String nickname;
    private String psd;
    private String refresh_token;
    private Boolean isblock;
    private String cookie;
    private String avater;
    private Boolean ismanager;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Date getRegday() {
		return regday;
	}
	public void setRegday(Date regday) {
		this.regday = regday;
	}
	public String getRegip() {
		return regip;
	}
	public void setRegip(String regip) {
		this.regip = regip;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPsd() {
		return psd;
	}
	public void setPsd(String psd) {
		this.psd = psd;
	}
	public String getRefresh_token() {
		return refresh_token;
	}
	public void setRefresh_token(String refresh_token) {
		this.refresh_token = refresh_token;
	}
	public Boolean getIsblock() {
		return isblock;
	}
	public void setIsblock(Boolean isblock) {
		this.isblock = isblock;
	}
	public String getCookie() {
		return cookie;
	}
	public void setCookie(String cookie) {
		this.cookie = cookie;
	}
	public String getAvater() {
		return avater;
	}
	public void setAvater(String avater) {
		this.avater = avater;
	}
	public Boolean getIsmanager() {
		return ismanager;
	}
	public void setIsmanager(Boolean ismanager) {
		this.ismanager = ismanager;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", token=" + token + ", regday=" + regday + ", regip=" + regip + ", uid=" + uid
				+ ", nickname=" + nickname + ", psd=" + psd + ", refresh_token=" + refresh_token + ", isblock="
				+ isblock + ", cookie=" + cookie + ", avater=" + avater + ", ismanager=" + ismanager + "]";
	}
    
}
