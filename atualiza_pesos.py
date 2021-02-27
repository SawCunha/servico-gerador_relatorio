import db_atualiza_peso, log, conf, sys, timeit, random
from datetime import datetime, timedelta
import multiprocessing, os, time 
import agendados
from multiprocessing import Pool, TimeoutError

def atualiza_pesos():
    