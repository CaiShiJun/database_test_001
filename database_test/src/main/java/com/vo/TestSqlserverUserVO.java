package com.vo;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "test_user")
//@Table(name = "test_user", schema = "public", catalog = "javatest")
public class TestSqlserverUserVO {
	
	private Integer id;
	private String name;
    private String birthday;
    @Id
    @Column(name = "id")
	public Integer getId() {
		return id;
    }
    public void setId(Integer id) {
		this.id = id;
    }
    @Basic
    @Column(name = "name")
	public String getName() {
	    return name;
	}
	public void setName(String name) {
		this.name = name;
	}
    @Basic
	@Column(name = "birthday")
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
}
