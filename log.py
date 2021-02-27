# -*- coding: utf-8 -*-

import os
import logging as log
from logging.handlers import TimedRotatingFileHandler

path = os.path.abspath(os.path.dirname(__file__))


def log_config(level=10, arquivo="servico_geradorrelatorios.log"):
    log_formatter = log.Formatter('%(asctime)s %(levelname)-8s %(message)s')
    root_logger = log.getLogger()
    root_logger.setLevel(level)

    path_logs = os.path.join(path, 'logs/{}'.format(arquivo))
    timed_rotating_file_handler = TimedRotatingFileHandler(path_logs, when='D', interval=1)
    timed_rotating_file_handler.setFormatter(log_formatter)
    root_logger.addHandler(timed_rotating_file_handler)

    console_handler = log.StreamHandler()
    console_handler.setFormatter(log_formatter)
    root_logger.addHandler(console_handler)
