package com.epam.bank.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.epam.bank.enums.Gender;

/**
 * Contains Customer Information
 * 
 * @author Nishant_Bansal
 */
@Entity
@Table(name = "user_spring_bank")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	@Column
	private String name;
	@Column
	private Gender gender;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "account_id")
	Account account;

	public String getName() {
		return name;
	}

	public Gender getGender() {
		return gender;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

}
