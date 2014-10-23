package com.springmvc.Controller;

import com.springmvc.Bean.Beer;
import com.springmvc.Bean.BeerImpl;
import com.springmvc.Bean.BeerStyle;
import com.springmvc.Bean.RawMaterial;
import com.springmvc.DAO.BeerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class MainController {

    @Autowired
    private BeerDAO beerDAO;

//    @RequestMapping(value="testi", method = RequestMethod.GET)
//    public String testi(){
//        return "test";
//    }

    @RequestMapping(method = RequestMethod.GET)
	public String showIndexPage(ModelMap model) {

        List<BeerStyle> bs = beerDAO.findAllBeerStyles();

//        System.out.println("-----------");
//        for(int i = 0; i < bs.size(); i++){
//            System.out.println(bs.get(i).getBeerStyle());
//
//            for(int j = 0; j < bs.get(i).getBeer().size(); j++){
//                System.out.println(bs.get(i).getBeer().get(j));
//
//                for(int k = 0; k < bs.get(i).getBeer().get(i).getRawMaterial().size(); k++){
//                    System.out.println(bs.get(i).getBeer().get(i).getRawMaterial().get(k).getRawMaterial());
//
//                }
//            }
//
//        }
        model.addAttribute("bs", bs);
        return "index";
	}

    @RequestMapping(value="fetchColumnTwo", method = RequestMethod.GET)
    public @ResponseBody
    List<Beer> fetchColumnTwo(@RequestParam(value="variable") Integer variable){

        System.out.println("CONTROLLER: " + variable);


        List<Beer> bisselista = new ArrayList<Beer>();

        Beer kalja1 = new BeerImpl();
        kalja1.setId(1);
        kalja1.setName("Olvi");
        kalja1.setProcess("Olvin process");

        Beer kalja2 = new BeerImpl();
        kalja2.setId(2);
        kalja2.setName("Koff");
        kalja2.setProcess("Koffin process");

        bisselista.add(kalja1);
        bisselista.add(kalja2);

//        String s = "Response: " + variable;
        return bisselista;
    }
}