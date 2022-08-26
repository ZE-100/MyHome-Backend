package com.myhome.api.components.token.entity;

import com.myhome.api.components.account.entity.Account;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "token")
public class Token {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(name = "token")
	private String token;

	@Column(name = "createdAt")
	private Date createdAt;

	@Column(name = "deviceSalt")
	private Long deviceSalt; //TODO implement this. Hash of device

	@OneToOne(mappedBy = "token")
	private Account fkAccountId;
}


