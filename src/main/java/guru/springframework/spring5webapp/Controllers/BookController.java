package guru.springframework.spring5webapp.Controllers;



import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class BookController {


    private final BookRepository bookrepository;

    public BookController(BookRepository bookrepository) {
        this.bookrepository = bookrepository;
    }

    @RequestMapping("/books")
    public String getBooks(Model model){

        model.addAttribute("books",bookrepository.findAll());
        return "books/list";
    }

    @RequestMapping("/yedhu")
    public String getyedhu()
    {
        return "yedhu";
    }
}
