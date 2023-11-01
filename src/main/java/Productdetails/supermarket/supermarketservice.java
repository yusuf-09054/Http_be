package Productdetails.supermarket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class supermarketservice
{
     @Autowired //object creation
    supermarketRepository repo;

     public supermarketentity makecreate(supermarketentity productdetails)
     {
         return repo.save(productdetails);
     }

     public List<supermarketentity> viewall()
     {
         return (List<supermarketentity>) repo.findAll();
     }

     public Optional<supermarketentity> readone(int productcount)
     {
         return repo.findById(productcount);
     }

     public String removeone(int productcount)
     {
         supermarketentity temp=repo.findById(productcount).orElse(new supermarketentity());
         repo.delete(temp);

         return  temp.getProductName()+"Has been deleted successfully";
     }

}

