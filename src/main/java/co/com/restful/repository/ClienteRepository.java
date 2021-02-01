package co.com.restful.repository;

import co.com.restful.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
   Optional<Cliente> findByIdentificacion(@Param("identificacion") String identificacion);
}
