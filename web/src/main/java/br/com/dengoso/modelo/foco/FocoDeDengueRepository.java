package br.com.dengoso.modelo.foco;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FocoDeDengueRepository extends CrudRepository<FocoDeDengue, Long> {

}
