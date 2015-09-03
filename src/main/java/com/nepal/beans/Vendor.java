package com.nepal.beans;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="vendor", 
uniqueConstraints={@UniqueConstraint(columnNames={"vendor_id", "location"})})
public class Vendor {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="vendor_id", nullable=false, unique=true)
	private Long id;

	@Column(name="vendor_name", length=30, nullable=false)
	private String vendorName;

	@Column(name="location", length=40, unique=true, nullable=false)
	private String location;

	@ManyToMany(mappedBy="vendors", fetch = FetchType.EAGER)
	private Set<Consultant> consultants = new HashSet<Consultant>();

	@OneToMany(mappedBy = "vendor", fetch = FetchType.EAGER)
	private Set<VendorContact> vendorContact;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the vendorName
	 */
	public String getVendorName() {
		return vendorName;
	}

	/**
	 * @param vendorName the vendorName to set
	 */
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * @return the vendorContact
	 */
	public Set<VendorContact> getVendorContact() {
		return vendorContact;
	}

	/**
	 * @param vendorContact the vendorContact to set
	 */
	public void setVendorContact(Set<VendorContact> vendorContact) {
		this.vendorContact = vendorContact;
	}

	/**
	 * @return the consultants
	 */
	public Set<Consultant> getConsultants() {
		return consultants;
	}

	/**
	 * @param consultants the consultants to set
	 */
	public void setConsultants(Set<Consultant> consultants) {
		this.consultants = consultants;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Vendor [id=" + id + ", vendorName=" + vendorName
				+ ", location=" + location + ", consultants=" + consultants
				+ ", vendorContact=" + vendorContact + "]";
	}

}
