/**
 * 
 */
package org.ramana.mvc.payManager.domain;


import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Project implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer projectId;

    @NotNull
    private Date startDate;

    
    private Date endDate;

	@NotNull
    private String projectName;

    @NotNull
    private String projectLocation;
    
    @NotNull
    private Double projectRate;

    @NotNull
    private Double BonusRate;
    
    @ManyToOne
    @JoinColumn(name="EID",referencedColumnName="EID")
    private Employee employee;
    
    @OneToMany(mappedBy="project")
    private List<PayDetail> payDetail;

	/**
	 * @return the projectId
	 */
	public Integer getProjectId() {
		return projectId;
	}

	/**
	 * @param projectId the projectId to set
	 */
	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	/**
	 * @return the signupDate
	 */
	public Date getSignupDate() {
		return startDate;
	}

	/**
	 * @param signupDate the signupDate to set
	 */
	public void setSignupDate(Date signupDate) {
		this.startDate = signupDate;
	}

	/**
	 * @return the projectName
	 */
	public String getProjectName() {
		return projectName;
	}

	/**
	 * @param projectName the projectName to set
	 */
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	/**
	 * @return the projectLocation
	 */
	public String getProjectLocation() {
		return projectLocation;
	}

	/**
	 * @param projectLocation the projectLocation to set
	 */
	public void setProjectLocation(String projectLocation) {
		this.projectLocation = projectLocation;
	}

	/**
	 * @return the projectRate
	 */
	public Double getProjectRate() {
		return projectRate;
	}

	/**
	 * @param projectRate the projectRate to set
	 */
	public void setProjectRate(Double projectRate) {
		this.projectRate = projectRate;
	}

	/**
	 * @return the employee
	 */
	public Employee getEmployee() {
		return employee;
	}

	/**
	 * @param employee the employee to set
	 */
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
    
    /**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * @return the bonusRate
	 */
	public Double getBonusRate() {
		return BonusRate;
	}

	/**
	 * @param bonusRate the bonusRate to set
	 */
	public void setBonusRate(Double bonusRate) {
		BonusRate = bonusRate;
	}
 

}

