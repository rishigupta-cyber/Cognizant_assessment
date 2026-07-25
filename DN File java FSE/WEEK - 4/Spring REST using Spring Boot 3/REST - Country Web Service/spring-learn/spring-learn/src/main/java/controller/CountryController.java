package com.cognizant.spring_learn.controller;

import com.cognizant.spring_learn.Country;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryController {

    private static final Logger logger = LoggerFactory.getLogger(CountryController.class);

    @RequestMapping("/country")
    public Country getCountryIndia() {
        logger.info("Start of getCountryIndia() method");

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Country india = (Country) context.getBean("india");

        logger.info("End of getCountryIndia() method");

        return india;
    }
}