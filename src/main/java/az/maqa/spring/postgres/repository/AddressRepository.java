package az.maqa.spring.postgres.repository;

import az.maqa.spring.postgres.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
