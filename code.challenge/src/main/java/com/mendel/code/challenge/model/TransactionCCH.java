package com.mendel.code.challenge.model;

public class TransactionCCH {
	
	private Long idTransaction;
	private String type;
	private double amount;	
    private Long parent_id;
	
    public TransactionCCH() {
		super();
	}
    public TransactionCCH(TransactionCCH cch) {
    			super();
    			this.idTransaction = cch.getIdTransaction();
    			this.type = cch.getType();
    			this.amount = cch.getAmount();
    			this.parent_id = cch.getParent_id();
	}
	public TransactionCCH(Long idTransaction, String type, double amount, Long parent_id) {
		super();
		this.idTransaction = idTransaction;
		this.type = type;
		this.amount = amount;
		this.parent_id = parent_id;
	}
	public Long getIdTransaction() {
		return idTransaction;
	}
	public void setIdTransaction(Long idTransaction) {
		this.idTransaction = idTransaction;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Long getParent_id() {
		return parent_id;
	}
	public void setParent_id(Long parent_id) {
		this.parent_id = parent_id;
	}
    
}
