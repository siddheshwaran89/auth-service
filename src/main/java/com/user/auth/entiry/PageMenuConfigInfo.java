package com.user.auth.entiry;

import java.sql.Types;
import java.util.UUID;

import org.hibernate.annotations.JdbcTypeCode;

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
@Table(name = "PageMenuConfigInfo", schema = "useractivityschema")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PageMenuConfigInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "pageMenuConfigInfoId", nullable = false)
	@JdbcTypeCode(Types.VARCHAR)
	private UUID pageMenuConfigInfoId;

	@Column(name = "value")
	private String value;
	
	
}
