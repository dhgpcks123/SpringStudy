package com.increpas.cls.util;

import java.util.ArrayList;

public class W3Color {
	private ArrayList<String> list;
	private ArrayList<String> textList;
	
	public W3Color() {
		list = new ArrayList<String>();
		textList = new ArrayList<String>();
		addList();
		addTextList();
	}
	
	public ArrayList<String> getList() {
		return list;
	}

	public void setList(ArrayList<String> list) {
		this.list = list;
	}

	public ArrayList<String> getTextList() {
		return textList;
	}

	public void setTextList(ArrayList<String> textList) {
		this.textList = textList;
	}

	public void addList() {
		list.add("w3-red");
		list.add("w3-pink");
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
	public void addTextList() {
		textList.add("w3-text-red");
		textList.add("w3-text-pink");
		textList.add("w3-text-purple");
		textList.add("w3-text-deep-purple");
		textList.add("w3-text-blue");
		textList.add("w3-text-cyan");
		textList.add("w3-text-aqua");
		textList.add("w3-text-teal");
		textList.add("w3-text-green");
		textList.add("w3-text-light-green");
		textList.add("w3-text-lime");
		textList.add("w3-text-yellow");
		textList.add("w3-text-amber");
		textList.add("w3-text-orange");
		textList.add("w3-text-deep-orange");
		textList.add("w3-text-black");
		textList.add("w3-text-dark-grey");
		textList.add("w3-text-grey");
		textList.add("w3-text-light-grey");
		textList.add("w3-text-blue-grey");
		textList.add("w3-text-brown");
		textList.add("w3-text-pale-red");
		textList.add("w3-text-sand");
		textList.add("w3-text-pale-yellow");
		textList.add("w3-text-khaki");
		textList.add("w3-text-pale-green");
		textList.add("w3-text-pale-blue");
		textList.add("w3-text-light-blue");
	}
}
