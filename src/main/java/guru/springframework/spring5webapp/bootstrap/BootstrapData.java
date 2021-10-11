package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.model.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {


    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }




    @Override
    public void run(String... args) throws Exception {


        System.out.println("Started in Bootstrap");



        Author eric=new Author("eric","ivans");
        Book ddd= new Book("Domain Driven Design","123123");

        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);


        authorRepository.save(eric);
        bookRepository.save(ddd);


        Author rod=new Author("Rod","jhonson");
        Book noEJB=new Book("j2ee","565656");


        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);


        Publisher yedhu=new Publisher("yedhu","kanjirathingal","Thrissur","Kerala","680541");
        Publisher benny=new Publisher("benny","kanjirathingal","Thrissur","Kerala","680541");



        ddd.setPublisher(yedhu);
        yedhu.getBooks().add(ddd);
        noEJB.setPublisher(benny);
        benny.getBooks().add(noEJB);
        publisherRepository.save(yedhu);
        bookRepository.save(ddd);
        publisherRepository.save(benny);
        bookRepository.save(noEJB);




        System.out.println("No of Books="+bookRepository.count());
        System.out.println("Publisher Count"+ publisherRepository.count());
        System.out.println("yedhu number of books"+ yedhu.getBooks().size());




    }
}
