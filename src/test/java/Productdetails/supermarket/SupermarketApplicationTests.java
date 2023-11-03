package Productdetails.supermarket;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootTest
@RunWith(SpringRunner.class)
class SupermarketApplicationTests
{
 @MockBean
    supermarketRepository repo;

 @Autowired
    supermarketservice serv;

 @Test
         public void testcreate() {
     supermarketentity product1 = new supermarketentity(1, "Juice", "Fruti", "Mango juice", 40, 2);
     supermarketentity product2 = new supermarketentity(2, "chocolate", "cadbury", "dairy milk", 80, 1);


     Mockito.when(repo.save(product1)).thenReturn(product1);
     Mockito.when(repo.save(product2)).thenReturn(product2);

     Assert.assertSame("Juice",serv.makecreate(product1).getProductCategory());
 }
 @Test
    public void testlistall()
 {
     supermarketentity product1 = new supermarketentity(1, "Juice", "Fruti", "Mango juice", 40, 2);
     supermarketentity product2 = new supermarketentity(2, "chocolate", "cadbury", "dairy milk", 80, 1);

     Mockito.when(repo.findAll()).thenReturn(Stream.of(product1,product2).collect(Collectors.toList()));

     Assert.assertSame(2,serv.viewall().get(1).getProductcount());

     Assert.assertNotSame(3,serv.viewall().size());
 }
}
