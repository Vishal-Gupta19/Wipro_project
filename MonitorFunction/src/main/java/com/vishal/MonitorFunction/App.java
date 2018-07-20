package com.vishal.MonitorFunction;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class App {
	
	private int id;
	private String name;
	private String type;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "App [id=" + id + ", name=" + name + ", type=" + type + "]";
	}

}
