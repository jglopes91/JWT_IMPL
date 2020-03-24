package com.blitzware.gestaoAPI.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "TB_USER")
@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@NotBlank
	@NotEmpty
	@Column(name = "STR_EMAIL", unique = true)
	private String email;
	@Lob
	@NotNull
	@NotEmpty
	@NotBlank
	@Column(name = "STR_PASSWORD")
	private String password;
	@NotNull
	@NotEmpty
	@NotBlank
	private String fullName;
	@Temporal(TemporalType.DATE)
	@Column(name = "DT_CREATED_AT")
	private Date createdAt = new Date();
	@OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	private RoleModel role;
	@Column(name = "isEnable")
	private boolean enable = true;

	public void setPassword(String password) {
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		this.password = passwordEncoder.encode(password);
	}
}
