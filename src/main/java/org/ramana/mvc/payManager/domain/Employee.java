package org.ramana.mvc.payManager.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="EMPLOYEE")
public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="EID",nullable=false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

	@Column(name="JOIN_DATE",nullable=false)
	private Date joinDate;

	@Column(name="FIRST_NAME",nullable=false)
	private String firstName;

    @Column(name="LAST_NAME",nullable=false)
    private String lastName;
    
    @Column(name="JOB_TITLE",nullable=false)
    private String jobTitle;

    @NotNull
    @OneToMany(fetch=FetchType.EAGER)
    private Set<Project> projects; 
    
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

	/**
	 * @return the joinDate
	 */
	public Date getJoinDate() {
		return joinDate;
	}

	/**
	 * @param joinDate the joinDate to set
	 */
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	/**
	 * @return the jobTitle
	 */
	public String getJobTitle() {
		return jobTitle;
	}

	/**
	 * @param jobTitle the jobTitle to set
	 */
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	/**
	 * @return the projects
	 */
	public Set<Project> getProjects() {
		return projects;
	}

	/**
	 * @param projects the projects to set
	 */
	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}

    
}
