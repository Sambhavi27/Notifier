package com.notifier.dao;
import java.sql.*;
import java.util.*;

import com.notifier.entities.Notebook;
import com.notifier.entities.Notes;
public class NotesDao {

	Connection con;

	public NotesDao(Connection con) {
		
		this.con = con;
	}
	
	public ArrayList<Notebook> getAllNotebooks(){
		ArrayList<Notebook> list=new ArrayList<>() ;
		
		try {
			String q="select * from book";
			Statement st=this.con.createStatement();
			ResultSet set=st.executeQuery(q);
			while(set.next()) {
				int bid=set.getInt("bid");
				String name=set.getString("name");
				int notescount=set.getInt("notescount");
				
				Notebook c=new Notebook(bid,name,notescount);
				list.add(c);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
		
	}
	public boolean saveNotes(Notes n) {
		boolean f=false;
		try {
			String q="insert into notes(name,status,tag,description,bookid,userid) values(?,?,?,?,?,?)";
			PreparedStatement pstmt=con.prepareStatement(q);
			pstmt.setString(1, n.getName());
			pstmt.setString(2,n.getStatus());
			pstmt.setString(3,n.getTag());
			pstmt.setString(4,n.getDescription());
			pstmt.setInt(5,n.getBookid());
			pstmt.setInt(6,n.getUserid());
			pstmt.executeUpdate();
			f=true;
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	
	public List<Notes> getAllNotes(){
		List<Notes> list=new ArrayList<>();
		try {
			PreparedStatement pstmt=con.prepareStatement("select * from notes");
			ResultSet set=pstmt.executeQuery();
			while(set.next()) {
				int nid=set.getInt("nid");
				String name=set.getString("name");
				Timestamp end=set.getTimestamp("end");
				Timestamp reminder=set.getTimestamp("reminder");
				Timestamp start=set.getTimestamp("start");
				String status=set.getString("status");
				String tag=set.getString("tag");
				String desc=set.getString("description");
				int bookid=set.getInt("bookid");
				int userid=set.getInt("userid");
				Notes n=new Notes(nid,name,null,null,null,status,tag,desc,bookid,userid);
				list.add(n);
			}
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return list;
		
	}
	public List<Notes> getNotesByBookId(int bookid){
     List<Notes> list=new ArrayList<>();
     try {
			PreparedStatement pstmt=con.prepareStatement("select * from notes where bookid=?");
			pstmt.setInt(1,bookid);
			ResultSet set=pstmt.executeQuery();
			while(set.next()) {
				int nid=set.getInt("nid");
				String name=set.getString("name");
				Timestamp end=set.getTimestamp("end");
				Timestamp reminder=set.getTimestamp("reminder");
				Timestamp start=set.getTimestamp("start");
				String status=set.getString("status");
				String tag=set.getString("tag");
				String desc=set.getString("description");
				
				int userid=set.getInt("userid");
				Notes n=new Notes(nid,name,null,null,null,status,tag,desc,bookid,userid);
				list.add(n);
			}
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return list;
		
	}
}
