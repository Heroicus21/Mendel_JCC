package com.mendel.code.challenge.service;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.DefaultRowSorter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	 * @return TransactionCCH
	 */
	@PutMapping(value = "/{transaction_id}")
	private TransactionCCH add(@PathVariable Long transaction_id) {
		
		TransactionCCH t= new TransactionCCH();
		t.setIdTransaction(transaction_id);		
		transactionsList.add(t);
		
		return t;
	}
	
	/**
	 * 
	 * @param TransactionCCH
	 * @return TransactionCCH
	 */
	@PostMapping(value = "/add")
	private TransactionCCH add(@RequestBody TransactionCCH cch) {
				
		transactionsList.add(cch);
		
		return cch;
	}
	
	/**
	 * 
	 * @param type
	 * @return ArrayList<Long>
	 */
	@GetMapping(value = "/type/{type}")
	private ArrayList<Long> getTransactionByType(@PathVariable String type) {
		
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
	 * @return SumWrapper
	 */
	@GetMapping(value = "/sum/{transaction_id}")
	private SumWrapper sum(@PathVariable Long transaction_id) {
		double d=0; 
		for (TransactionCCH transactionCCH : transactionsList) {
			if (transactionCCH.getParent_id()==transaction_id) {
				d=d+transactionCCH.getAmount();
			}
		}
		if (d==0) {
			throw new RuntimeException("No se encontro ningun registro");
		}
		 
		return new SumWrapper(d);
	}

	/**
	 * 
	 * @param transaction_id
	 * @return String
	 */
	@GetMapping(value = "/prueba")
	private String prueba() {
		
		return "Hola mundo";
	}
	
	/**
	 * 
	 * @return ArrayList<TransactionCCH>
	 */
	@GetMapping(value = "/listar")
	private ArrayList<TransactionCCH> listar() {
		
		return transactionsList;
	}
	
	/**
	 * 
	 * @param 
	 * @return ArrayList<TransactionCCH>
	 */
	@GetMapping(value = "/carga")
	private ArrayList<TransactionCCH> cargar() {
		
		TransactionCCH cch= new TransactionCCH();
		TransactionCCH cch1= new TransactionCCH(2L,"CAR",200,1L);
		TransactionCCH cch2= new TransactionCCH(3L,"CAR",350,1L);
		TransactionCCH cch3= new TransactionCCH(4L,"CAR",100,1L);
		TransactionCCH cch4= new TransactionCCH(5L,"CAR",800,1L);
		cch.setAmount(200);
		cch.setIdTransaction(1L);
		cch.setType("CAR");
		
		transactionsList.add(cch);
		transactionsList.add(cch1);
		transactionsList.add(cch2);
		transactionsList.add(cch3);
		transactionsList.add(cch4);
		return transactionsList;
	}
	
}
