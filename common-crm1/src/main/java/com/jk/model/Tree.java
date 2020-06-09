package com.jk.model;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import lombok.Data;

@Data
public class Tree implements Serializable {
	
	private Integer id;
	
	private String text;
	
	private String href;
	
	private Integer pid;
	
	private List<Tree> nodes;
	
	private Boolean selectable;
	
	private Boolean leaf;

	private Boolean checked;

<<<<<<< HEAD

	private Map<String,Boolean> state;


	public Tree(Integer id, String text, String href, Integer pid, List<Tree> nodes, Boolean selectable, Boolean leaf, Boolean checked, Map<String, Boolean> state) {
		this.id = id;
		this.text = text;
		this.href = href;
		this.pid = pid;
		this.nodes = nodes;
		this.selectable = selectable;
		this.leaf = leaf;
		this.checked = checked;
		this.state = state;
	}

	public Tree() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public String getText() {
		return text;
	}

	public String getHref() {
		return href;
	}

	public Integer getPid() {
		return pid;
	}

	public List<Tree> getNodes() {
		return nodes;
	}

	public Boolean getSelectable() {
		return selectable;
	}

	public Boolean getLeaf() {
		return leaf;
	}

	public Boolean getChecked() {
		return checked;
	}

	public Map<String, Boolean> getState() {
		return state;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setText(String text) {
		this.text = text;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public void setNodes(List<Tree> nodes) {
		this.nodes = nodes;
	}

	public void setSelectable(Boolean selectable) {
		this.selectable = selectable;
	}

	public void setLeaf(Boolean leaf) {
		this.leaf = leaf;
	}

	public void setChecked(Boolean checked) {
		this.checked = checked;
	}

	public void setState(Map<String, Boolean> state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Tree{" +
				"id=" + id +
				", text='" + text + '\'' +
				", href='" + href + '\'' +
				", pid=" + pid +
				", nodes=" + nodes +
				", selectable=" + selectable +
				", leaf=" + leaf +
				", checked=" + checked +
				", state=" + state +
				'}';
	}
=======
>>>>>>> origin/master
}
