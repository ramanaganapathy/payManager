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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * @author ramana
 *
 */
@Entity
@Table(name="PAYDETAIL")
public class PayDetail {
	
	@Id
	@Column(name="PAYDETAILID",nullable=false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer payDetailId;
	
	@NotNull
	@Column(name="PAY_PRD_ST_DT",nullable=false)
	private Date payPeriodStartDate;
	
	@NotNull
	@Column(name="PAY_PRD_END_DT",nullable=false)
	private Date payPeriodEndDate;
	
	@NotNull
	@Column(name="PAY_DATE",nullable=false)
	private Date payDate;
	
	@NotNull
	@Column(name="PAY_AMOUNT",nullable=false)
	private Double payAmount;
	
	@NotNull
	@Column(name="PAY_HOURS",nullable=false)
	private Double payHours;

	@ManyToOne
	@JoinColumn(name="PROJECTID",referencedColumnName="PID")
	private Project project;
	
	@ManyToOne
	@JoinColumn(name="EMPLOYEEID",referencedColumnName="EID")
	private Employee employee;
	
	/**
	 * @return the payDetailId
	 */
	public Integer getPayDetailId() {
		return payDetailId;
	}

	/**
	 * @param payDetailId the payDetailId to set
	 */
	public void setPayDetailId(Integer payDetailId) {
		this.payDetailId = payDetailId;
	}

	/**
	 * @return the payPeriodStartDate
	 */
	public Date getPayPeriodStartDate() {
		return payPeriodStartDate;
	}

	/**
	 * @param payPeriodStartDate the payPeriodStartDate to set
	 */
	public void setPayPeriodStartDate(Date payPeriodStartDate) {
		this.payPeriodStartDate = payPeriodStartDate;
	}

	/**
	 * @return the payPeriodEndDate
	 */
	public Date getPayPeriodEndDate() {
		return payPeriodEndDate;
	}

	/**
	 * @param payPeriodEndDate the payPeriodEndDate to set
	 */
	public void setPayPeriodEndDate(Date payPeriodEndDate) {
		this.payPeriodEndDate = payPeriodEndDate;
	}

	/**
	 * @return the payDate
	 */
	public Date getPayDate() {
		return payDate;
	}

	/**
	 * @param payDate the payDate to set
	 */
	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}

	/**
	 * @return the payAmount
	 */
	public Double getPayAmount() {
		return payAmount;
	}

	/**
	 * @param payAmount the payAmount to set
	 */
	public void setPayAmount(Double payAmount) {
		this.payAmount = payAmount;
	}

	/**
	 * @return the payHours
	 */
	public Double getPayHours() {
		return payHours;
	}

	/**
	 * @param payHours the payHours to set
	 */
	public void setPayHours(Double payHours) {
		this.payHours = payHours;
	}

	
}
