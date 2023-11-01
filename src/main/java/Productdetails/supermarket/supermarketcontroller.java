package Productdetails.supermarket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

public class supermarketcontroller
{
  @Autowired
  supermarketservice serv;

  //  http://localhost:8081/create
    @PostMapping("/create")
    public String creation(@RequestBody supermarketentity Productdetails)
    {
        return  serv.makecreate(Productdetails).getProductName()+"Has been added successfully";
    }

    @GetMapping("/")
  public List<supermarketentity> listall()
    {
      return serv.viewall();
    }
    @PutMapping("/update")
  public String updating(@RequestBody supermarketentity productdetails)
    {
      supermarketentity temp=serv.makecreate(productdetails);
      return temp.getProductName()+"Has been updated successfully";
    }
    @GetMapping("/readone/{count}")
    public Optional<supermarketentity> showone(@PathVariable("count")int count)
    {
      return serv.readone(count);
    }
    @DeleteMapping("/Deleteone/{count}")
  public String deleteone(@PathVariable("count")int count)
    {
      return serv.removeone(count)+"deleted";
    }
}
