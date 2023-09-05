package com.example.plastic.bottle.bin.with.iot.Controller;

import java.text.DecimalFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.plastic.bottle.bin.with.iot.Models.Data;
import com.example.plastic.bottle.bin.with.iot.Repository.DataRepository;

@RestController
public class Controller {

    @Autowired
    DataRepository dataRepo;

    @PostMapping("/bin")
    public String handleData(@RequestBody Data data, Model model) {

        DecimalFormat decimalFormat = new DecimalFormat("#.00");

        System.out.println(decimalFormat.format(Math.abs(data.getDistance_1() - 52)));
        System.out.println(decimalFormat.format(Math.abs(data.getDistance_2() - 53)));
        String a = decimalFormat.format(Math.abs(data.getDistance_1() - 52));
        String b = decimalFormat.format(Math.abs(data.getDistance_2() - 53));

        double c = Double.parseDouble(a);
        double d = Double.parseDouble(b);
        data.setDistance_1(c);
        data.setDistance_2(d);

        data.setSensor_id(2);
        dataRepo.save(data);
        return "received";
    }

    @GetMapping("/bin")
    public ModelAndView show(Model model) {

        List<Data> data = dataRepo.findAll();

        model.addAttribute("data", data);
        return new ModelAndView("bin");
    }

}
