package com.nepal.beans;

import java.time.Year;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@Table(name="education_detail", 
uniqueConstraints={@UniqueConstraint(columnNames={"education_detail_id"})})
public class EducationDetail {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="education_detail_id", nullable=false, unique=true, length=11)
	private Long id;

	@Column(name="institution_name", length=40, nullable=false)
	private String institutionName;

	@Column(name="location", length=40, nullable=false)
	private String location;

	@Column(name="graduated_year", length=4, nullable=false)
	private Long graduateYear;

	/*@OneToMany(fetch = FetchType.LAZY, mappedBy = "educationDetail")
	private Set<Consultant> consultants = new HashSet<Consultant>();*/

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
	 * @return the institutionName
	 */
	public String getInstitutionName() {
		return institutionName;
	}

	/**
	 * @param institutionName the institutionName to set
	 */
	public void setInstitutionName(String institutionName) {
		this.institutionName = institutionName;
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
	 * @return the graduateYear
	 */
	public Long getGraduateYear() {
		return graduateYear;
	}

	/**
	 * @param graduateYear the graduateYear to set
	 */
	public void setGraduateYear(Long graduateYear) {
		this.graduateYear = graduateYear;
	}

	/**
	 * @return the consultants
	 */
	/*public Set<Consultant> getConsultants() {
		return consultants;
	}

	*//**
	 * @param consultants the consultants to set
	 *//*
	public void setConsultants(Set<Consultant> consultants) {
		this.consultants = consultants;
	}*/

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "EducationDetail [id=" + id + ", institutionName="
				+ institutionName + ", location=" + location
				+ ", graduateYear=" + graduateYear + ", consultants="
				/*+ consultants */+ "]";
	}






}
