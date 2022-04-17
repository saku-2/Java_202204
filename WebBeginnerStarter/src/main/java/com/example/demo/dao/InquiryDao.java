package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.Inquiry;

public interface InquiryDao {

	void insertInqury(Inquiry inquiry);
	
	List<Inquiry> getAll();
}
