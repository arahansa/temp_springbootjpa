package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.domain.TestDomain;
import com.example.repository.TestDomainRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller 
@RequestMapping("/rest")
public class RestTestController {

	@Autowired
	private TestDomainRepository testDomainRepository;
	
	@RequestMapping(value = "/list")
	@ResponseBody
	public List<TestDomain> list(Model model) {
		List<TestDomain> findAll = testDomainRepository.findAll();
		return findAll;
	}
	
	@RequestMapping("/craete")
	@ResponseBody
	public TestDomain create(TestDomain testDomain){
		log.debug("testDoamin : {}" , testDomain);
		return testDomainRepository.save(testDomain);
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public String update(TestDomain testDomain){
		testDomainRepository.save(testDomain);
		return "redirect:list";
	}
	
	@RequestMapping("/delete")
	public String delete(Long id){
		testDomainRepository.delete(id);
		return "redirect:list";
	}
	
	
}
