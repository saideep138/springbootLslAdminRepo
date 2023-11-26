package com.lsl.packageoftsal.hiberanatepack.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name="paymentdetails")
public class PaymentEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="payid")
	private Long payid;

	@Column(name="amount")
	private Long amount;

	@Column(name="paytype")
	private String paytype;

	public PaymentEntity(Long amount, String paytype) {
		super();
		this.amount = amount;
		this.paytype = paytype;
	}

	public Long getPayid() {
		return payid;
	}

	public void setPayid(Long payid) {
		this.payid = payid;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public String getPaytype() {
		return paytype;
	}

	public void setPaytype(String paytype) {
		this.paytype = paytype;
	}

}
