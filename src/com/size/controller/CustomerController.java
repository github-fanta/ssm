package com.size.controller;

import java.util.List;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.size.pojo.BaseDict;
import com.size.pojo.Customer;
import com.size.pojo.QueryVo;
import com.size.service.CustomerService;

import cn.itcast.utils.Page;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	

	@Value("${dict.source}")
	private String source;
	@Value("${dict.industry}")
	private String industry;
	@Value("${dict.level}")
	private String level;
	
	@RequestMapping("/list")
	public String showIndex(HttpServletRequest request, QueryVo vo, Model model) {
		 
		String currentPage = request.getParameter("currentPage");
		System.out.println(currentPage);
		if (currentPage != null) {
			vo.setPage(Integer.parseInt(currentPage));
		}
		
		if (vo.getStart() == null) {
			vo.setStart(1);
		}
		vo.setStart((vo.getPage()-1)*vo.getSize());
		
		List<Customer> custList = customerService.findCustomerByVo(vo);
		Integer totalCount = customerService.findCustomerCount();
		
		Page<Customer> page = new Page<Customer>();
		page.setPage(vo.getPage());
		page.setRows(custList);
		page.setSize(vo.getSize());
		page.setTotal(totalCount);
		model.addAttribute("page", page);
		
		List<BaseDict> listSource = customerService.findDictByCode(source);
		model.addAttribute("fromType", listSource);
		model.addAttribute("custSource", vo.getCustSource());

		List<BaseDict> industrySource = customerService.findDictByCode(industry);
		model.addAttribute("industrySource", industrySource);
		model.addAttribute("custIndustry", vo.getCustIndustry());
		
		List<BaseDict> levellList = customerService.findDictByCode(level);
		model.addAttribute("levellList", levellList);
		model.addAttribute("custLevel", vo.getCustLevel());
		
		model.addAttribute("custName", vo.getCustName());
		return "list";
	}
	
	@RequestMapping("/edit/{cust_id}")
	public String  edit(@PathVariable("cust_id") String cust_id, Model model) {
		Customer editCustomer = customerService.findCustomerById(cust_id);
		
		model.addAttribute("editCustomer", editCustomer);
		return "edit";
	}
	
	@RequestMapping("/update")
	public String update(Customer customer) {
		customerService.saveCustomer(customer);
		return "redirect:list";
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable("id") String id) {
		customerService.deleteCustomerById(id);
		return "redirect:/customer/list";
	}
	
}
