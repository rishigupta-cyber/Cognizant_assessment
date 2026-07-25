package com.cognizant.spring_learn.controller;

import com.cognizant.spring_learn.Country;
import com.cognizant.spring_learn.service.CountryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryController {

    private static final Logger logger = LoggerFactory.getLogger(CountryController.class);

    @Autowired
    private CountryService countryService;

    @RequestMapping("/country")
    public Country getCountryIndia() {
        logger.info("Start of getCountryIndia() method");

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Country india = (Country) context.getBean("india");

        logger.info("End of getCountryIndia() method");

        return india;
    }

    @GetMapping("/countries/{code}")
    public Country getCountry(@PathVariable String code) {
        logger.info("Start of getCountry() controller method");

        Country result = countryService.getCountry(code);

        logger.info("End of getCountry() controller method");

        return result;
    }
}