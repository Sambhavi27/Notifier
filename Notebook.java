package com.notifier.entities;

public class Notebook {

	private int bid;
	private String name;
	private int notescount;
	public Notebook(int bid, String name, int notescount) {
		
		this.bid = bid;
		this.name = name;
		this.notescount = notescount;
	}
	public Notebook() {
		
	}
	public Notebook(String name, int notescount) {
		
		this.name = name;
		this.notescount = notescount;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNotescount() {
		return notescount;
	}
	public void setNotescount(int notescount) {
		this.notescount = notescount;
	}
	
}
