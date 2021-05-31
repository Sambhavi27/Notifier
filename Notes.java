package com.notifier.entities;

import java.sql.Date;

public class Notes {
	private String name;
	private int nid;
	private Date start;
	private Date end;
	private Date reminder;
	private String status;
	private String tag;
	private String description;
	private int bookid;
	private int userid;
	public Notes() {
		
	}

	public Notes(int nid, String name, Date start, Date end, Date reminder, String status, String tag, String description,
			int bookid,int userid) {
		
		this.nid = nid;
		this.name=name;
		this.start = start;
		this.end = end;
		this.reminder = reminder;
		this.status = status;
		this.tag = tag;
		this.description = description;
		this.bookid = bookid;
		this.userid = userid;
	}
	public Notes(String name,String status, String tag, String description,
			int bookid,int userid) {
		
		
		this.name=name;
		
		this.status = status;
		this.tag = tag;
		this.description = description;
		this.bookid = bookid;
		this.userid = userid;
	}
	public Notes(String name,Date start, Date end, Date reminder, String status, String tag, String description, int bookid,int userid) {
		this.name=name;
		this.start = start;
		this.end = end;
		this.reminder = reminder;
		this.status = status;
		this.tag = tag;
		this.description = description;
		this.bookid = bookid;
		this.userid = userid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNid() {
		return nid;
	}

	public void setNid(int nid) {
		this.nid = nid;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public Date getReminder() {
		return reminder;
	}

	public void setReminder(Date reminder) {
		this.reminder = reminder;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getBookid() {
		return bookid;
	}

	public void setBookid(int bookid) {
		this.bookid = bookid;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}
	
	
	
}
