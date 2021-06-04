package com.sawcunha.controlerelatorio.mapper;

import com.sawcunha.controlerelatorio.model.ConfiguracaoSMTP;
import com.sawcunha.controlerelatorio.model.dto.ConfiguracaoSMTPDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ConfiguracaoSMTPMapper {

    ConfiguracaoSMTPDTO configuracaoToConfiguracaoDTO(ConfiguracaoSMTP configuracaoSMTP);
    List<ConfiguracaoSMTPDTO> configuracoesToConfiguracoesDTO(List<ConfiguracaoSMTP> configuracoesSMTP);
    ConfiguracaoSMTP configuracaoDTOToConfiguracao(ConfiguracaoSMTPDTO configuracaoSMTPDTO);

}
