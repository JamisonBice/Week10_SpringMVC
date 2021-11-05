package bice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import bice.beans.Computer;
import bice.repository.ComputerRepository;

/**
 * @author Jamison Bice - jdbice CIS175 - Fall 2021 Sep 4, 2021
 */
@Controller
public class WebController {
	@Autowired
	ComputerRepository repo;

	@GetMapping({ "/", "viewAll" })
	public String viewAllComputers(Model model) {
		if (repo.findAll().isEmpty()) {
			return addNewComputer(model);
		}
		model.addAttribute("computers", repo.findAll());
		return "results";
	}

	@GetMapping("/inputComputer")
	public String addNewComputer(Model model) {
		Computer c = new Computer();
		model.addAttribute("newComputer", c);
		return "input";
	}

	@PostMapping("/inputComputer")
	public String addNewComputer(@ModelAttribute Computer c, Model model) {
		repo.save(c);
		return viewAllComputers(model);
	}

	@GetMapping("/edit/{id}")
	public String showUpdateComputer(@PathVariable("id") long id, Model model) {
		Computer c = repo.findById(id).orElse(null);
		model.addAttribute("newComputer", c);
		return "input";
	}

	@PostMapping("/update/{id}")
	public String reviseComputer(Computer c, Model model) {
		repo.save(c);
		return viewAllComputers(model);
	}

	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id") long id, Model model) {
		Computer c = repo.findById(id).orElse(null);
		repo.delete(c);
		return viewAllComputers(model);
	}
	
}

