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
@Table(name = "UserAddress", schema = "useractivityschema")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserAddress {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "addressId", nullable = false)
	@JdbcTypeCode(Types.VARCHAR)
	private UUID addressId;

	
	@Column(name = "type")
	private String type;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "country")
	private String country;
	
	@Column(name = "state")
	private String state;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "street")
	private String street;
	
	@Column(name = "building")
	private String building;
	
	@Column(name = "floor")
	private String floor;
	
	@Column(name = "apartmentNo")
	private String apartmentNo;
	
	@Column(name = "zipCode")
	private String zipCode;
	
	
	@Column(name = "landmark")
	private String landmark;
	
	
	@Column(name = "latitude")
	private String latitude;
	
	@Column(name = "longitude")
	private String longitude;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "userID")
	private User user;
	
	
	
}
