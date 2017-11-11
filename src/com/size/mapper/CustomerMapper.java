package com.size.mapper;

import java.util.List;

import com.size.pojo.Customer;
import com.size.pojo.QueryVo;

public interface CustomerMapper {

	public List<Customer> findCustomerByVo(QueryVo vo);
	public Integer findCustomerCount();
	public Customer findCustomerById(String cust_id);
	public void saveCustomer(Customer customer);
	public void deleteCustomerById(String id);
}
