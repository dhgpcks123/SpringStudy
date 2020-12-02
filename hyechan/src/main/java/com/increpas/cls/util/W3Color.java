package com.increpas.cls.util;

import java.util.ArrayList;

public class W3Color {
	private ArrayList<String> list;
	
	public W3Color() {
		list = new ArrayList<String>();
		addList();
	}
	
	public ArrayList<String> getList() {
		return list;
	}

	public void setList(ArrayList<String> list) {
		this.list = list;
	}

	public void addList() {
		list.add("w3-red");
		list.add("w3-pink");
		list.add("w3-purple");
		list.add("w3-purple");
		list.add("w3-deep-purple");
		list.add("w3-blue");
		list.add("w3-cyan");
		list.add("w3-aqua");
		list.add("w3-teal");
		list.add("w3-green");
		list.add("w3-light-green");
		list.add("w3-lime");
		list.add("w3-yellow");
		list.add("w3-amber");
		list.add("w3-orange");
		list.add("w3-deep-orange");
		list.add("w3-black");
		list.add("w3-dark-grey");
		list.add("w3-grey");
		list.add("w3-light-grey");
		list.add("w3-blue-grey");
		list.add("w3-brown");
		list.add("w3-pale-red");
		list.add("w3-sand");
		list.add("w3-pale-yellow");
		list.add("w3-khaki");
		list.add("w3-pale-green");
		list.add("w3-pale-blue");
		list.add("w3-light-blue");
	}
}
