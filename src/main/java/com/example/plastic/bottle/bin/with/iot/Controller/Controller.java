package com.example.plastic.bottle.bin.with.iot.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.plastic.bottle.bin.with.iot.Models.Data;
import com.example.plastic.bottle.bin.with.iot.Repository.DataRepository;

@RestController
public class Controller {

    @Autowired DataRepository dataRepo;

    
    @PostMapping("/bin")
    public String handleData(@RequestBody Data data,Model model){
        System.out.println(data.getDistance_1());
                        System.out.println(data.getDistance_2());

                dataRepo.save(data);
        return "received";
    }

    @GetMapping("/bin")
    public ModelAndView show(Model model){

        List<Data> data = dataRepo.findAll();

        model.addAttribute("data", data);
        return new ModelAndView("bin");
    }


}
