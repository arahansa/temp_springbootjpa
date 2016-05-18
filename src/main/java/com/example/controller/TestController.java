package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.ArticlePageInfo;
import com.example.domain.TestDomain;
import com.example.repository.TestDomainRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class TestController {

	@Bean
	public InitializingBean initializingBean(){
		return () -> {
			List<TestDomain> testDomains = new ArrayList<>(500);
			for (int i = 0; i < 500; i++) {
				testDomains.add(new TestDomain("강용"+i, "인천"+i, "설명"+i));
			}
			testDomainRepository.save(testDomains);
		};
	}
	
	@Autowired
	private TestDomainRepository testDomainRepository;
	
	private static final String ID = "id";
	public static int sizeDefault = 10;
	
	@RequestMapping(value = "/")
	public String index(Model model) {
		return page(1, model);
	}
	
	@RequestMapping("/page/{page}")
	public String page(@PathVariable int page, Model model){
		Sort sort = new Sort(Direction.DESC, ID);
		Pageable pageable = new PageRequest(page-1, sizeDefault, sort);
		Page<TestDomain> pageBoard =testDomainRepository.findAll(pageable);
		
		ArticlePageInfo<TestDomain> articlePageInfo = new ArticlePageInfo<TestDomain>(pageBoard);
		model.addAttribute("list", articlePageInfo);
		return "index";
	}
	
	@RequestMapping("/create")
	public String save(TestDomain testDomain){
		log.debug("domain : {}" , testDomain);
		testDomainRepository.save(testDomain);
		return "redirect:/";
	}
	
}
