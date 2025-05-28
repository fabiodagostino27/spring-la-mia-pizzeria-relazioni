package org.lessons.java.spring_la_mia_pizzeria_crud.controller;

import org.lessons.java.spring_la_mia_pizzeria_crud.model.Pizza;
import org.lessons.java.spring_la_mia_pizzeria_crud.model.Sale;
import org.lessons.java.spring_la_mia_pizzeria_crud.repo.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/sales")
public class SaleController {
    @Autowired
    private SaleRepository repository;

    @PostMapping("/create")
    public String store(@Valid @ModelAttribute("sale") Sale sale, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "/sales/create";
        }

        repository.save(sale);

        return "redirect:/pizzas";
    }
}
