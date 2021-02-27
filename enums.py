from enum import Enum
class TipoBanco(Enum):
    MYSQL = 'MySQL'
    ORACLE = 'Oracle'
    POSTGRESQL = 'PostgreSQL'
    SQLSERVER = 'SQLServer'
    MARIADB = 'MariaDB'

class Status(Enum):
    NOVO = 'NOVO'
    EM_ANALISE = 'EM_ANALISE'
    GERANDO = 'GERANDO'
    ENVIANDO = 'ENVIANDO'
    FINALIZADO = 'FINALIZADO'
    ERRO = 'ERRO'
    ABORTADO = 'ABORTADO'

class Operador(Enum):
    MAIOR = '>'
    MAIOR_IGUAL = '>='
    IGUAL = '='
    MENOR = '<'
    MENOR_IGUAL = '<='

class TipoPesso(Enum):
    TABELA = 'TABELA'
    BANCO = 'BANCO'
    TEMPO = 'TEMPO'
    LINHAS = 'LINHAS'
    INNER_JOIN = 'INNER_JOIN'
    LEFT_JOIN = 'LEFT_JOIN'
    JOIN = 'JOIN'
    RIGHT_JOIN = 'RIGHT_JOIN'
    SUB_SELECT = 'SUB_SELECT'
    FULL_JOIN = 'FULL_JOIN'
    CROSS_JOIN = 'CROSS_JOIN'