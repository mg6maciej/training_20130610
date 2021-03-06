package com.cybercom.feeds.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
@NamedQueries({
	@NamedQuery(name=Feed.FIND_ALL, query="from Feed")
})
public class Feed {

	final static public String FIND_ALL = "Feed.findAll";
	
	@Id
	@GeneratedValue
	private long id;
	

	private String title;
	private String link;
	
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	private List<Item> items;

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public Feed() {
		
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}
	
	public void addItem(Item item) {
		if (this.items == null) {
			this.items = new ArrayList<Item>();
		}
		this.items.add(item);
	}
	
	public void addItems(List<Item> items) {
		if (items == null) {
			items = new ArrayList<Item>();
		}
		this.items.addAll(items);
	}	

	private Feed(Builder builder) {
		this.title = builder.title;
		this.link = builder.link;
		this.items = builder.items;
	}

	public static class Builder {
		private String title;
		private String link;
		private List<Item> items;

		public Builder withTitle(String title) {
			this.title = title;
			return this;
		}

		public Builder withLink(String link) {
			this.link = link;
			return this;
		}

		public Builder withItems(List<Item> items) {
			this.items = items;
			return this;
		}

		public Feed build() {
			return new Feed(this);
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!getClass().isAssignableFrom(obj.getClass()))
			return false;
		Feed other = (Feed) obj;
		if (items == null) {
			if (other.items != null)
				return false;
		} else if (!items.equals(other.items))
			return false;
		if (link == null) {
			if (other.link != null)
				return false;
		} else if (!link.equals(other.link))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

}
