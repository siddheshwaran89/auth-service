package com.user.auth.entiry;

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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Role", schema = "useractivityschema")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "roleId", nullable = false)
	@JdbcTypeCode(Types.VARCHAR)
	private UUID roleId;

	@Column(name = "roleName")
	private String roleName;
	
	@Column(name = "roleDescription")
	private String roleDescription;
	
	
	@Column(name = "isActive")
	private boolean isActive;
	
	@CreatedDate
	@Column(name = "createdAt")
	private LocalDateTime createdAt;
	
	@LastModifiedDate
	@Column(name = "updatedAt")
	private LocalDateTime updatedAt;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "role")
	@Builder.Default
	private Set<Admin> admin = new HashSet<>();
	
	
	@OneToMany(fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.ALL, mappedBy = "role")
	@JsonIgnore
	@Builder.Default
	private Set<PagePermission> pagePermission = new HashSet<>();
	
	
	

	
}
