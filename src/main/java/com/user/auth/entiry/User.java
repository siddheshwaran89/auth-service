package com.user.auth.entiry;

import java.sql.Date;
import java.sql.Types;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.hibernate.annotations.JdbcTypeCode;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "User", schema = "useractivityschema", indexes = {
		@Index(name = "User_mobileNumber", columnList = "mobileNumber", unique = true),
		@Index(name = "User_userName", columnList = "userName", unique = true),
		@Index(name = "User_emailAddress", columnList = "emailAddress", unique = true) })

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "userId", nullable = false)
	@JdbcTypeCode(Types.VARCHAR)
	private UUID userId;

	@Column(name = "mobileNumber")
	private String mobileNumber;

	@Column(name = "userName")
	private String userName;

	@Column(name = "firstName")
	private String firstName;

	@Column(name = "lastName")
	private String lastName;

	@Column(name = "password")
	private String password;

	@Column(name = "dateOfBirth")
	private Date dateOfBirth;

	@Column(name = "gender")
	private String gender;

	@Column(name = "emailAddress")
	private String emailAddress;

	@Column(name = "isActive")
	private boolean isActive;

	@Column(name = "photoUri")
	private String photoUri;

	@Lob
	@Column(name = "UploadFile")
	private byte[] uploadedFile;

	@Column(name = "referralCode")
	private String referralCode;

	@Column(name = "userType")
	private String userType;

	@CreatedDate
	@Column(name = "createdAt")
	private LocalDateTime createdAt;

	@LastModifiedDate
	@Column(name = "updatedAt")
	private LocalDateTime updatedAt;

	@LastModifiedDate
	@Column(name = "lastLoginIn")
	private LocalDateTime lastLoginIn;

	@OneToMany(fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.ALL, mappedBy = "user")
	@JsonIgnore
	@Builder.Default
	private Set<UserAddress> userAddress = new HashSet<>();

}
