package com.iu.s1;

import java.util.List;

public class DummyDTO {
	private Long id;
	private String title;
	private String body;
	private Long userId;
	private String [] tags;
	private Long reactions;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String[] getTags() {
		return tags;
	}
	public void setTags(String[] tags) {
		this.tags = tags;
	}
	public Long getReactions() {
		return reactions;
	}
	public void setReactions(Long reactions) {
		this.reactions = reactions;
	}
	
}
