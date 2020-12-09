package com.increpas.cls.vo;

import java.text.*;

import com.increpas.cls.util.*;

import java.sql.*;

public class ReBoardVO {
	private int rno, bno, ano, mno, upno, step, nowPage;
	private String body, sdate, id, avatar;
	private Date wdate;
	private Time wtime;
	
	private PageUtil page;
	
	public int getNowPage() {
		return nowPage;
	}
	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}
	public PageUtil getPage() {
		return page;
	}
	public void setPage(PageUtil page) {
		this.page = page;
	}
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public int getUpno() {
		return upno;
	}
	public void setUpno(int upno) {
		this.upno = upno;
	}
	public int getStep() {
		return step;
	}
	public void setStep(int step) {
		this.step = step;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getSdate() {
		return sdate;
	}
	public void setSdate() {
		SimpleDateFormat form1 = new SimpleDateFormat("yyyy/MM/dd ");
		SimpleDateFormat form2 = new SimpleDateFormat("HH:mm");
		sdate = form1.format(wdate) + form2.format(wtime);
	}
	public void setSdate(String sdate) {
		this.sdate = sdate;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public Date getWdate() {
		return wdate;
	}
	public void setWdate(Date wdate) {
		this.wdate = wdate;
	}
	public Time getWtime() {
		return wtime;
	}
	public void setWtime(Time wtime) {
		this.wtime = wtime;
		setSdate();
	}
	@Override
	public String toString() {
		return "ReBoardVO : rno=" + rno + ", bno=" + bno + ", ano=" + ano + ", mno=" + mno + ", upno=" + upno + ", step="
				+ step + ", body=" + body + ", sdate=" + sdate + ", id=" + id + ", avatar=" + avatar + ", wdate="
				+ wdate + ", wtime=" + wtime;
	}
}
