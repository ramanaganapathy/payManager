/**
 * 
 */
package org.ramana.mvc.payManager.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * @author ramana
 *
 */
@Entity
@Table(name="TIMEDETAIL")
public class TimeDetail {

	@Id
	@Column(name="TDID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer timeDetailId;
	
	@NotNull
	private Date workDate;
	/**
	 * hours made as double to support 15 min,30 min etc
	 */
	@NotNull
	private Double workedHours;
	
	private Double bonusHours;
	
	@ManyToOne
	private Project project;
	

	/**
	 * @return the timeDetailId
	 */
	public Integer getTimeDetailId() {
		return timeDetailId;
	}

	/**
	 * @param timeDetailId the timeDetailId to set
	 */
	public void setTimeDetailId(Integer timeDetailId) {
		this.timeDetailId = timeDetailId;
	}

	/**
	 * @return the workDate
	 */
	public Date getWorkDate() {
		return workDate;
	}

	/**
	 * @param workDate the workDate to set
	 */
	public void setWorkDate(Date workDate) {
		this.workDate = workDate;
	}

	/**
	 * @return the workedHours
	 */
	public Double getWorkedHours() {
		return workedHours;
	}

	/**
	 * @param workedHours the workedHours to set
	 */
	public void setWorkedHours(Double workedHours) {
		this.workedHours = workedHours;
	}

	/**
	 * @return the project
	 */
	public Project getProject() {
		return project;
	}

	/**
	 * @param project the project to set
	 */
	public void setProject(Project project) {
		this.project = project;
	}
	
	/**
	 * @return the bonusHours
	 */
	public Double getBonusHours() {
		return bonusHours;
	}

	/**
	 * @param bonusHours the bonusHours to set
	 */
	public void setBonusHours(Double bonusHours) {
		this.bonusHours = bonusHours;
	}

	/**
	 * @return the calculatedPay
	 */
	public Double getCalculatedPay() {
//		@Formula(value = "")
		double calculatedPay = 0.0;
		if(this.project!=null)
		{
			calculatedPay=this.project.getProjectRate()*this.workedHours;
		}
		if(this.bonusHours != null && this.bonusHours.doubleValue()>0.0)
		{
			if(this.project.getBonusRate()==null)
			{
				this.project.setBonusRate(this.project.getProjectRate());
			}
			calculatedPay=calculatedPay+this.bonusHours*this.project.getBonusRate();
		}
			return calculatedPay;
	}
	
	
}
