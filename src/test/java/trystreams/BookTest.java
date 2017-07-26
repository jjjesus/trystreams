package trystreams;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import junit.framework.TestCase;

public class BookTest extends TestCase
{
    public BookTest( String testName )
    {
        super( testName );
    }

    @Test
    public void testBooks()
    {
        List<Book> bookList = new ArrayList<Book>();
        Book book1 = new Book("James Joyce", "Ulysses", "Penguin");
        Book book2 = new Book("JRR Tolkein", "The Two Towers", "Doubleday");
        Book book3 = new Book("Marcus Aurelius", "Meditations", "Simon");
        bookList.add(book1);
        bookList.add(book2);
        bookList.add(book3);
        
        List<PublishingHouse> publisherList = new ArrayList<PublishingHouse>();
        PublishingHouse publisher1 = new PublishingHouse("Penguin", "Dublin");
        PublishingHouse publisher2 = new PublishingHouse("Doubleday", "London");
        PublishingHouse publisher3 = new PublishingHouse("Simon", "New York");
        publisherList.add(publisher1);
        publisherList.add(publisher2);
        publisherList.add(publisher3);
        
        
        Stream.of(bookList)
        	.forEach(System.out::println);
        Stream.of(publisherList)
    	.forEach(System.out::println);

        List<String> publishingCities = publisherList.stream()
        		.map(PublishingHouse::getCity).collect(Collectors.toList());
        Stream.of(publishingCities)
        	.forEach(System.out::println);
        
        Optional<Book> result = bookList.stream()
        	      .filter(b -> b.getTitle() == "Meditations")
        	      .findAny();
        
        if (result.isPresent()) {
        	String author = result.get().getAuthor();
        	System.out.println("The author of Meditations is: " + author);
        }
    }
}
