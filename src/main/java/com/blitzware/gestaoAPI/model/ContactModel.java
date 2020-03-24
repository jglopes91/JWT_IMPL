package com.blitzware.gestaoAPI.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "TB_CONTACT")
@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@NotEmpty
	@NotBlank
	@Column(name = "STR_PHONE_NUMER")
	private String phoneNumber;
	@NotNull
	@NotEmpty
	@NotBlank
	@Column(name = "STR_EMAIL")
	private String email;
	@NotNull
	@NotEmpty
	@NotBlank
	@Column(name = "STR_NAME")
	private String name;
	@Temporal(TemporalType.DATE)
	@Column(name = "DT_CREATED_AT")
	private Date createdAt;
	@OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY, orphanRemoval = false)
	private UserModel user;
}
