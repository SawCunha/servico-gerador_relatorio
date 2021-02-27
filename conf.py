# -*- coding: utf-8 -*-

import os
import log
import configparser as cp

def open_conf():
    conf = cp.ConfigParser()
    path_conf = os.path.join(log.path, 'conf.cfg')
    conf.read(r'%s' % path_conf)
    return conf
