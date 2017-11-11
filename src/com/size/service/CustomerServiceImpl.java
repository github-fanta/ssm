package com.size.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.size.mapper.BaseDictMapper;
import com.size.mapper.CustomerMapper;
import com.size.pojo.BaseDict;
import com.size.pojo.Customer;
import com.size.pojo.QueryVo;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private BaseDictMapper baseDictMapper;
	@Autowired
	private CustomerMapper customerMapper;

	@Override
	public List<BaseDict> findDictByCode(String typeCode) {
		
		List<BaseDict> itemList = baseDictMapper.findDictByCode(typeCode);
		if (itemList != null && itemList.size() > 0) {
			
			return itemList;
		}
		return null;
	}

	@Override
	public List<Customer> findCustomerByVo(QueryVo vo) {
		
		List<Customer> custList = customerMapper.findCustomerByVo(vo);
		return custList;
	}

	@Override
	public Integer findCustomerCount() {
		Integer count = customerMapper.findCustomerCount();
		return count;
	}

	@Override
	public Customer findCustomerById(String cust_id) {
		
		return customerMapper.findCustomerById(cust_id);
	}

	@Override
	public void saveCustomer(Customer customer) {
		customerMapper.saveCustomer(customer);
	}

	@Override
	public void deleteCustomerById(String id) {
		customerMapper.deleteCustomerById(id);
	}

	
}
