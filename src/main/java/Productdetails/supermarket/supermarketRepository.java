package Productdetails.supermarket;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface supermarketRepository extends CrudRepository<supermarketentity,Integer>
{

}
