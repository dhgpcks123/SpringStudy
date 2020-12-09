package com.increpas.cls.vo;

import java.text.*;
import java.sql.*;

public class SurveyVO {
	private int sno, qno, sano, mno, upno, cnt;
	private int[] aqno;
	private double per;
	private String sbody, qbody, id, sdate, ssdate, sedate;
	private Date startdate, enddate, sadate;
	private Time startTime, endTime, saTime;
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public int getQno() {
		return qno;
	}
	public void setQno(int qno) {
		this.qno = qno;
	}
	public int getSano() {
		return sano;
	}
	public void setSano(int sano) {
		this.sano = sano;
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
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public int[] getAqno() {
		return aqno;
	}
	public void setAqno(int[] aqno) {
		this.aqno = aqno;
	}
	public double getPer() {
		return per;
	}
	public void setPer(double per) {
		this.per = per;
	}
	public String getSbody() {
		return sbody;
	}
	public void setSbody(String sbody) {
		this.sbody = sbody;
	}
	public String getQbody() {
		return qbody;
	}
	public void setQbody(String qbody) {
		this.qbody = qbody;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSdate() {
		return sdate;
	}
	public void setSdate() {
		sdate = strForm(sadate, saTime);
	}
	public void setSdate(String sdate) {
		this.sdate = sdate;
	}
	public String getSsdate() {
		return ssdate;
	}
	public void setSsdate() {
		ssdate = strForm(startdate, startTime);
	}
	public void setSsdate(String ssdate) {
		this.ssdate = ssdate;
	}
	public String getSedate() {
		return sedate;
	}
	public void setSedate() {
		sedate = strForm(enddate, endTime);
	}
	public void setSedate(String sedate) {
		this.sedate = sedate;
	}
	public Date getStartdate() {
		return startdate;
	}
	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}
	public Date getEnddate() {
		return enddate;
	}
	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}
	public Date getSadate() {
		return sadate;
	}
	public void setSadate(Date sadate) {
		this.sadate = sadate;
	}
	public Time getStartTime() {
		return startTime;
	}
	public void setStartTime(Time startTime) {
		this.startTime = startTime;
		setSsdate();
	}
	public Time getEndTime() {
		return endTime;
	}
	public void setEndTime(Time endTime) {
		this.endTime = endTime;
		setSedate();
	}
	public Time getSaTime() {
		return saTime;
	}
	public void setSaTime(Time saTime) {
		this.saTime = saTime;
		setSdate();
	}
	public String strForm(Date d, Time t) {
		SimpleDateFormat form1 = new SimpleDateFormat("yyyy/MM/dd ");
		SimpleDateFormat form2 = new SimpleDateFormat("HH:mm");
		return form1.format(d) + form2.format(t);
	}
}
