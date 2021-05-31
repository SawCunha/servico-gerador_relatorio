package com.sawcunha.controlerelatorio.mapper;

import com.sawcunha.controlerelatorio.model.LogGeracaoRelatorio;
import com.sawcunha.controlerelatorio.model.dto.LogGeracaoRelatorioDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LogGeracaoRelatorioMapper {

    LogGeracaoRelatorioDTO logToLogDTO(LogGeracaoRelatorio logGeracaoRelatorio);
    List<LogGeracaoRelatorioDTO> logsToLogDTOs(List<LogGeracaoRelatorio> logsGeracaoRelatorio);
    LogGeracaoRelatorio logDTOToLog(LogGeracaoRelatorioDTO logGeracaoRelatorioDTO);

}
