package com.size.service;

import java.util.List;

import com.size.pojo.BaseDict;
import com.size.pojo.Customer;
import com.size.pojo.QueryVo;

public interface CustomerService {

	public List<BaseDict> findDictByCode(String typeCode);
	public List<Customer> findCustomerByVo(QueryVo vo);
	public Integer findCustomerCount();
	public Customer findCustomerById(String cust_id);
	public void saveCustomer(Customer customer);
	public void deleteCustomerById(String id);

}
