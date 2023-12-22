package com.user.auth.entiry;

import java.sql.Types;
import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.JdbcTypeCode;
import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "NewUserLoginActivity", schema = "useractivityschema")

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class NewUserLoginActivity {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "messageId", nullable = false)
	@JdbcTypeCode(Types.VARCHAR)
	private UUID messageId;

	@Column(name = "mobileNumber")
	private String mobileNumber;
	
	@Column(name = "emailAddress")
	private String emailAddress;
	
	@Column(name = "otp")
	private String otp;
	
	@CreatedDate
	@Column(name = "createdAt")
	private LocalDateTime createdAt;
	
	@Column(name = "validTime")
	private LocalDateTime validTime;

	
}
