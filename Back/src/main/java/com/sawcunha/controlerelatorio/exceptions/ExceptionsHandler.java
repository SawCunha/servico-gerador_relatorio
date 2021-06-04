package com.sawcunha.controlerelatorio.exceptions;

import com.sawcunha.controlerelatorio.mapper.MessageErroMapper;
import com.sawcunha.controlerelatorio.model.MessageErro;
import com.sawcunha.controlerelatorio.model.dto.MessageErroDTO;
import com.sawcunha.controlerelatorio.repository.MessageErroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionsHandler extends ResponseEntityExceptionHandler {

    @Autowired
    private MessageErroRepository messageErroRepository;

    @Autowired
    private MessageErroMapper messageErroMapper;

    @ExceptionHandler(NotFoundException.class)
    protected ResponseEntity<MessageErroDTO> handleSecurity(NotFoundException e){
        MessageErroDTO messageErroDTO = getMensageErro(e.getIdentifier());
        return ResponseEntity.status(messageErroDTO.getStatus()).body(messageErroDTO);
    }

    @Transactional(readOnly = true)
    MessageErroDTO getMensageErro(Integer identificador){
        return messageErroMapper.mensagemToMensagemDTO(
                messageErroRepository.findByIdentifier(identificador)
                        .orElse(new MessageErro()));
    }

}
