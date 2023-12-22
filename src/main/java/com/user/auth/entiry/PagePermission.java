package com.user.auth.entiry;

import java.sql.Types;
import java.util.UUID;

import org.hibernate.annotations.JdbcTypeCode;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "PagePermission", schema = "useractivityschema")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PagePermission {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "pagePermissionId", nullable = false)
	@JdbcTypeCode(Types.VARCHAR)
	private UUID pagePermissionId;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "pageMenuConfigInfo")
	@Builder.Default
	private PageMenuConfigInfo pageMenuConfigInfo = new PageMenuConfigInfo();
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "permission")
	@Builder.Default
	private Permission permission = new Permission();
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "role")
	private Role role;

}
