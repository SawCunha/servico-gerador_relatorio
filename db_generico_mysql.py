# -*- coding: utf-8 -*-

import log
import mysql.connector as myc


def connect_db(host='localhost', database='information_schema', port=3306, user='root', password=''):
    try:
        log.log.info('- Abrindo conexão com o host "%s", porta "%s" e banco de dados "%s"' % (str(host), str(port), str(database)))
        return myc.connect(host=host, database=database, port=port, user=user, password=password, charset='utf8', use_unicode=True)
    except Exception as e:
        log.log.error('Falha ao conectar no banco de dados: %s' % e)

def close_connect_db(cnx):
    try:
        cnx.close()
        log.log.info('- Fechando a conexao com o banco de dados...')
    except Exception as e:
        log.log.error('Falha ao finalizar a conexao com o banco de dados: %s' % e)

def consulta_varios(cnx, sql, dados):
    try:
        cur = cnx.cursor(dictionary=True)
        cur.execute(sql, dados)
        dados = cur.fetchall()
        cur.close()
        return dados
    except Exception as e:
        log.log.error('Falha ao realizar uma consulta no banco de dados: %s' % e)

def consulta_um(cnx, sql, dados):
    try:
        cur = cnx.cursor(dictionary=True)
        cur.execute(sql, dados)
        dado = cur.fetchone()
        cur.close()
        return dado
    except Exception as e:
        log.log.error('Falha ao realizar uma consulta no banco de dados: %s' % e)