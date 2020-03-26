package assignment.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import assignment.bookstore.domain.Category;
import assignment.bookstore.domain.CategoryRepository;

@Controller
public class CategoryController {

	@Autowired
	CategoryRepository categoryRepository;
	
	@RequestMapping("/categorylist")
	public String categoryEndpoint(Model model) {
		model.addAttribute("all_categories", categoryRepository.findAll());
		return "categorylist";
	}
	
	@RequestMapping(value = "/add_category", method = RequestMethod.GET)
	public String addCategory(Model model) {
		model.addAttribute("category", new Category());
		return "add_category";
	}
	
	@RequestMapping(value = "/save_category", method = RequestMethod.POST)
	public String saveCategory(Category cat) {
		categoryRepository.save(cat);
		return "redirect:categorylist";
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/delete_category/{id}", method = RequestMethod.GET)
	public String deleteCategory(@PathVariable("id") Long catId, Model model) {
		categoryRepository.deleteById(catId);
		return "redirect:../categorylist";
	}
	
	@RequestMapping(value = "/edit_category/{id}", method = RequestMethod.GET)
	public String editBook(@PathVariable("id") Long catId, Model model) {
		model.addAttribute("category", categoryRepository.findById(catId));
		return "edit_category";
	}
}
