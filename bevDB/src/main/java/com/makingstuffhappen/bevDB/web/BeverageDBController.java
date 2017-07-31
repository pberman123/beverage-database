package com.makingstuffhappen.bevDB.web;

import com.makingstuffhappen.bevDB.entity.Beverage;
import com.makingstuffhappen.bevDB.repository.BeverageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by philip on 6/14/17.
 */
@Controller
@EnableAutoConfiguration
public class BeverageDBController {

    @Autowired
    private BeverageRepository beverageRepo;

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String index(Model model) throws Exception {
        //for (String key : System.getenv().keySet()) {
        //    System.out.println(key + ":" + System.getenv(key));
        //}

        //addAppInstanceIndex(model);
        //getCFServices(model);

        return "index";
    }

    /*@ResponseBody
    public String home() {
        return "Hello World of Beverages";
    }*/



    /**
     * Action to get a list of all beverages.
     *
     * @param model
     *            The model for this action.
     * @return The path to the view.
     */
    @RequestMapping(value = "/beverages", method = RequestMethod.GET)
    public String beverages(Model model) throws Exception{

        Iterable<Beverage> beverages = beverageRepo.findAll();

        model.addAttribute("beverages", beverages);
        //this is for CF
        //addAppInstanceIndex(model);
        return "beverages";
    }

    /**
     * Action to get add a beverage. Includes both POST & GET method scenarios
     *
     * @param model
     *            The model for this action.
     * @return The path to the view.
     */
    @RequestMapping(value = "/addBeverage", method = RequestMethod.GET)
    public String addAttendee() {
        return "addBeverage";
    }

    @RequestMapping(value = "/addBeverage", method = RequestMethod.POST)
    public String addBeverage(@RequestParam("bevType") String bevType, @RequestParam("name") String name,
                              @RequestParam("year") String year, @RequestParam("location") String location, Model model) throws Exception {

        Beverage beverage = new Beverage();
        beverage.setBevType(bevType);
        beverage.setName(name);
        beverage.setYear(year);
        beverage.setLocation(location);


        beverageRepo.save(beverage);

        return this.beverages(model);
    }

}
