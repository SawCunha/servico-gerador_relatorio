# -*- coding: utf-8 -*-

import sys, conf

'''

CREATE TABLE `TB_ConfiguracaoEmail` (
            `IDConfiguracaoEmail` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
            `Descricao` VARCHAR(255) NOT NULL,
            `Usuario` varchar(255) NOT NULL,
            `Senha` varchar(255) NOT NULL,
            `Host` varchar(255) NOT NULL,
            `Porta` INT(20) UNSIGNED NOT NULL,
            `Remetente` VARCHAR(255) NOT NULL,
            `UtilizaTLS` TINYINT(1) NOT NULL DEFAULT 1,
            PRIMARY KEY (`IDConfiguracaoEmail`)
            ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `TB_ConfiguracaoGeracaoRelatorioBanco` (
            `IDConfiguracaoGeradorRelatorioBanco` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
            `IDConfiguracaoEmailDefault` BIGINT(20) UNSIGNED NOT NULL,
            `GeracaoSimultanea` TINYINT(1) NOT NULL DEFAULT 0,
            `NumeroGeracoesSimultanea` INT(5) UNSIGNED DEFAULT 1,
            `TipoBanco` ENUM('MySQL','Oracle','PostgreSQL','SQLServer','MariaDB') NOT NULL,
            `PesoMaximo` DOUBLE NOT NULL,
            `NumeroTentativa` INT(5) UNSIGNED DEFAULT 1,
            `IntervaloAtualizacaoPeso` INT(5) UNSIGNED DEFAULT 1,
            `DataAtualizacaoPeso` DATETIME DEFAULT NULL,
            `IntervaloAtualizacaoTabela` INT(5) UNSIGNED DEFAULT 7,
            `DataAtualizacaoTabela` DATETIME DEFAULT NULL,
            PRIMARY KEY (`IDConfiguracaoGeradorRelatorioBanco`),
            KEY `FK_ConfiguracaoGeradorRelatorio_IDConfiguracaoEmail` (`IDConfiguracaoEmailDefault`),
            CONSTRAINT `FK_ConfiguracaoGeradorRelatorio_IDConfiguracaoEmail` FOREIGN KEY (`IDConfiguracaoEmailDefault`)
            REFERENCES `TB_ConfiguracaoEmail` (`IDConfiguracaoEmail`)
            ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `TB_ConexaoBanco` (
            `IDConexaoBanco` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
            `Descricao` VARCHAR(255) NOT NULL,
            `Usuario` varchar(255) NOT NULL,
            `Senha` varchar(255) NOT NULL,
            `Banco` varchar(255) NOT NULL,
            `Host` varchar(255) NOT NULL,
            `Porta` INT(20) UNSIGNED NOT NULL,
            `TipoBanco` ENUM('MySQL','Oracle','PostgreSQL','SQLServer','MariaDB') NOT NULL,
            PRIMARY KEY (`IDConexaoBanco`)
            ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `TB_TabelaIgnoradaBanco` (
            `IDTabelaIgnoradaBanco` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
            `NomeTabela` VARCHAR(255) NOT NULL,
            `TipoBanco` ENUM('MySQL','Oracle','PostgreSQL','SQLServer','MariaDB') NOT NULL,
            PRIMARY KEY (`IDTabelaIgnoradaBanco`)
            ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `TB_Relatorio` (
            `IDRelatorio` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
            `IDConexaoBanco` BIGINT(20) UNSIGNED NOT NULL,
            `IDConfiguracaoEmail` BIGINT(20) UNSIGNED NOT NULL,
            `Descricao` VARCHAR(255) NOT NULL,
            `NomeRelatorio` VARCHAR(30) NOT NULL,
            `PermiteAgendar` TINYINT(1) NOT NULL DEFAULT 0,
            `Peso` DOUBLE NOT NULL,
            `SQL` LONGTEXT NOT NULL,
            `TempoCache` INT(20) UNSIGNED NOT NULL,
            PRIMARY KEY (`IDRelatorio`),
            KEY `FK_Relatorio_IDConexaoBanco` (`IDConexaoBanco`),
            CONSTRAINT `FK_Relatorio_IDConexaoBanco` FOREIGN KEY (`IDConexaoBanco`)
            REFERENCES `TB_ConexaoBanco` (`IDConexaoBanco`),
            KEY `FK_Relatorio_IDConfiguracaoEmail` (`IDConfiguracaoEmail`),
            CONSTRAINT `FK_Relatorio_IDConfiguracaoEmail` FOREIGN KEY (`IDConfiguracaoEmail`)
            REFERENCES `TB_ConfiguracaoEmail` (`IDConfiguracaoEmail`)
            ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `TB_AgendamentoRelatorio` (
            `IDAgendamentoRelatorio` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
            `IDRelatorio` BIGINT(20) UNSIGNED NOT NULL,
            `Descricao` VARCHAR(255) NOT NULL,
            `DiaSemana` VARCHAR(255) NOT NULL,
            `TodoDiaSemana` TINYINT(1) NOT NULL DEFAULT 1,
            `DiaDoMes` INT(2) UNSIGNED DEFAULT NULL,
            `Horario` TIME NOT NULL,
            `Destinario` MEDIUMTEXT NOT NULL,
            PRIMARY KEY (`IDAgendamentoRelatorio`),
            KEY `FK_AgendamentoRelatorio` (`IDRelatorio`),
            CONSTRAINT `FK_AgendamentoRelatorio_IDRelatorio` FOREIGN KEY (`IDRelatorio`) REFERENCES `TB_Relatorio`
            (`IDRelatorio`)
            ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `TB_ControleGeracaoRelatorio` (
            `IDControleGeracaoRelatorio` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
            `IDRelatorio` BIGINT(20) UNSIGNED NOT NULL,
            `NomeSolicitante` VARCHAR(255) NOT NULL,
            `EmailSolicitante` VARCHAR(255) NOT NULL,
            `DataCadastro` DATETIME NOT NULL,
            `DataInicio` DATETIME DEFAULT NULL,
            `DataFim` DATETIME DEFAULT NULL,
            `Status` ENUM('NOVO','EM_ANALISE','GERANDO','ENVIANDO','FINALIZADO','ERRO','ABORTADO') NOT NULL,
            `NomeArquivo` VARCHAR(255) NOT NULL,
            PRIMARY KEY (`IDControleGeracaoRelatorio`),
            KEY `FK_ControleGeracaoRelatorio_IDRelatorio` (`IDRelatorio`),
            CONSTRAINT `FK_ControleGeracaoRelatorio_IDRelatorio` FOREIGN KEY (`IDRelatorio`) REFERENCES `TB_Relatorio`
            (`IDRelatorio`)
            ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

### A definir os tipos
CREATE TABLE `TB_ParametroGeracaoRelatorio` (
            `IDParametroGeracaoRelatorio` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
            `IDControleGeracaoRelatorio` BIGINT(20) UNSIGNED NOT NULL,
            `NomeParametro` VARCHAR(255) NOT NULL,
            `TipoParametro` ENUM('INT','STRING','DATA') NOT NULL,
            `ValorParametro` MEDIUMTEXT NOT NULL,
            PRIMARY KEY (`IDParametroGeracaoRelatorio`),
            KEY `FK_ParametroGeracaoRelatorio_IDControleGeracaoRelatorio` (`IDControleGeracaoRelatorio`),
            CONSTRAINT `FK_ParametroGeracaoRelatorio_IDControleGeracaoRelatorio` FOREIGN KEY (`IDControleGeracaoRelatorio`)
            REFERENCES `TB_ControleGeracaoRelatorio`
            (`IDControleGeracaoRelatorio`)
            ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `TB_ConfiguracaoPeso` (
            `IDConfiguracaoPeso` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
            `TipoPesso` ENUM('TABELA','BANCO','TEMPO','LINHAS','INNER_JOIN','LEFT_JOIN','JOIN','RIGHT_JOIN','SUB_SELECT', 'FULL_JOIN', 'CROSS_JOIN') NOT NULL,
            `ValorUnico` TINYINT(1) NOT NULL DEFAULT 0,
            `ValorInicial` DOUBLE NOT NULL,
            `OperadorInicial` ENUM('>','>=','=','<','<=') NOT NULL,
            `ValorFinal` DOUBLE DEFAULT NULL,
            `OperadorFinal` ENUM('>','>=','=','<','<=') NOT NULL,
            `Peso` DOUBLE NOT NULL,
            PRIMARY KEY (`IDConfiguracaoPeso`)
            ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `TB_TabelaRelatorio` (
            `IDTabelaRelatorio` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
            `NomeTabela` VARCHAR(255) NOT NULL,
            `NomeBanco` VARCHAR(255) NOT NULL,
            `TipoBanco` ENUM('MySQL','Oracle','PostgreSQL','SQLServer','MariaDB') NOT NULL,
            `NumeroLinhas` BIGINT(20) UNSIGNED NOT NULL,
            PRIMARY KEY (`IDTabelaRelatorio`)
            ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `TB_LogDuracaoConsulta` (
            `IDLogDuracaoConsulta` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
            `IDRelatorio` BIGINT(20) UNSIGNED NOT NULL,
            `Duracao` INT(20) UNSIGNED NOT NULL,
            `DataLog` DATETIME NOT NULL,
            PRIMARY KEY (`IDLogDuracaoConsulta`)
            ) ENGINE=InnoDB DEFAULT CHARSET=utf8;


### A definir ainda 
CREATE TABLE `TB_LogGeracaoRelatorioAgendado` (
            `IDLogGeracaoRelatorio` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
            `IDAgendamentoRelatorio` BIGINT(20) UNSIGNED NOT NULL,
            `NomeArquivo` VARCHAR(255) NOT NULL,
            `DataLog` DATETIME DEFAULT NULL,
            PRIMARY KEY (`IDLogGeracaoRelatorio`)
            ) ENGINE=Archive DEFAULT CHARSET=utf8;

### A definir ainda os demais campos
CREATE TABLE `TB_CacheGeracaoRelatorio` (
            `UUID` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
            `IDControleGeracaoRelatorio` BIGINT(20) UNSIGNED DEFAULT NULL,
            `IDAgendamentoRelatorio` BIGINT(20) UNSIGNED DEFAULT NULL,
            `DataInicio` DATETIME DEFAULT NULL,
            `DataFim` DATETIME DEFAULT NULL,
            `DuracaoConsulta` INT(20) UNSIGNED NOT NULL,
            `Status` ENUM('NOVO','EM_ANALISE','GERANDO','ENVIANDO','FINALIZADO','ERRO','ABORTADO') NOT NULL,
            `Processado` TINYINT(1) NOT NULL DEFAULT 0,
            ) ENGINE=Memory DEFAULT CHARSET=utf8;

'''

def main():


if __name__ == '__main__':
    reload(sys)
    sys.setdefaultencoding('utf8')
    main()