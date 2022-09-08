package com.example.controller;


import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.example.Farmer;
import com.example.repository.FarmerRepository;
import com.example.service.FarmerService;;



@RestController
public class FarmerController {
	@Autowired
FarmerService  farmerservice;
	
@GetMapping("/farmers/list")
@ResponseBody
private List<Farmer> allFarmers(){      
    return farmerservice.findallFarmers();
}  	
	
	
	
	@GetMapping("/search")
	public ModelAndView viewAddFarmer() {
		ModelAndView mod=new ModelAndView("all-farmers");
		return mod;
	}

	@PostMapping("/farmer/addnewfarmer_v3")
    @ResponseBody
    public String addNewFarmer_V3(@RequestBody @Valid Farmer farmer, BindingResult br) {
        if (br.hasErrors()) {
        	System.out.println("in failed");
        	 return "{\"message\":\"Failed to add new Farmer\"}";
        	 
        } else {
        		System.out.println("in excuti");
        	farmerservice.addFarmer(farmer);
           
            return "{\"message\":\"New farmer added successfully\"}";
        }
    }

}
