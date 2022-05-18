package mark1708.com.controllers;

import mark1708.com.service.GenresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/genres")
public class GenresPageController {

    private final GenresService genresService;

    @Autowired
    public GenresPageController(GenresService genresService) {
        this.genresService = genresService;
    }

    @GetMapping()
    public String viewPage(Model model){
        model.addAttribute("genreList", genresService.getParentGenresList());
        return "genres/index";
    }
}
