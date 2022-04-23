package com.example.demo.controller;

public class TableForm {

	private Integer id;
	
    private String name;

    private String contents;
    
    public TableForm(Integer id, String name, String contents) {
    	this.id = id;
    	this.name = name;
    	this.contents = contents;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }
}