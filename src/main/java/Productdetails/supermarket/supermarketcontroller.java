package Productdetails.supermarket;

import org.hibernate.boot.jaxb.Origin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.lang.model.util.Elements;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/supermarket")
@CrossOrigin(origins = "http://localhost:3000")
//  http://localhost:8081/supermarket

public class supermarketcontroller
{
  @Autowired
  supermarketservice serv;

  //  http://localhost:8081/create
    //after request mapping
    //    //http://localhost:8081/Supermarket/create
    @PostMapping("/create")
    public String creation(@RequestBody supermarketentity Productdetails)
    {
        return  serv.makecreate(Productdetails).getProductName()+"Has been added successfully";
    }

  //http://localhost:8081/Supermarket
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
