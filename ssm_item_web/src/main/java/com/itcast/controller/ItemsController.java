package com.itcast.controller;

import com.itcast.service.ItemsService;
import com.itcast.domain.Items;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/item")
public class ItemsController {

    @Autowired
    private ItemsService itemsService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Items> itemsList = itemsService.findAll();
        mv.addObject("itemsList",itemsList);
        mv.setViewName("itemsList");

        return mv;
    }
    @RequestMapping("/updateItems.do")
    public String updateItems(){
        itemsService.updateItems();
        return "redirect.findAll.do";
    }



}
