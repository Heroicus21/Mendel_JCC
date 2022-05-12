package com.mendel.code.challenge.service;

import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mendel.code.challenge.model.TransactionCCH;
import com.mendel.code.challenge.model.TransactionType;
import com.mendel.code.challenge.wrapper.SumWrapper;

@RestController
@RequestMapping("/transactions")
public class Transactions {

	public static ArrayList<TransactionCCH> transactionsList= new ArrayList<TransactionCCH>();
	
	/**
	 * 
	 * @param transaction_id
	 * @return
	 */
	@PutMapping(value = "/{transaction_id}")
	private TransactionCCH add(@PathVariable Long transaction_id) {
		
		TransactionCCH t= new TransactionCCH();
		t.setIdTransaction(transaction_id);
		
		return t;
	}
	
	/**
	 * 
	 * @param type
	 * @return
	 */
	@GetMapping(value = "/type/{$type}")
	private ArrayList<Long> getTransactionByType(@RequestBody String type) {
		
		ArrayList<Long> transactionByTypeList= new ArrayList<Long>();
		for (TransactionCCH transactionCCH : transactionsList) {
			if (transactionCCH.getType().equals(type)) {
				transactionByTypeList.add(transactionCCH.getIdTransaction());
			}
		}
		
		return transactionByTypeList;
	} 

	/**
	 * 
	 * @param transaction_id
	 * @return
	 */
	@GetMapping(value = "/sum/{$transaction_id}")
	private SumWrapper sum(@RequestBody Long transaction_id) {
		double d=0; 
		for (TransactionCCH transactionCCH : transactionsList) {
			if (transactionCCH.getParent_id()==transaction_id) {
				d=d+transactionCCH.getAmount();
			}
		}		
		 
		return new SumWrapper(d);
	}

	/**
	 * 	
	 * @param transaction
	 * @return
	 
		@PutMapping(value = "/addTransaction")
		private TransactionCCH add(@RequestBody TransactionCCH transaction) {
			
			TransactionCCH t= new TransactionCCH(transaction);
			transactionsList.add(t);
			
			return t;
		}
	*/
}
