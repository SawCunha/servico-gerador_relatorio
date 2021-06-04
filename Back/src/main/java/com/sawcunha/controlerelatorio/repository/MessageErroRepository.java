package com.sawcunha.controlerelatorio.repository;

import com.sawcunha.controlerelatorio.model.MessageErro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MessageErroRepository extends JpaRepository<MessageErro, Long> {

    Optional<MessageErro> findByIdentifier(Integer identifier);

}
