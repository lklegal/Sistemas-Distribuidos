from xmlrpc.server import SimpleXMLRPCServer
from xmlrpc.server import SimpleXMLRPCRequestHandler
import datetime

class RequestHandler(SimpleXMLRPCRequestHandler):
   rpc_paths = ('/RPC2',)

with SimpleXMLRPCServer(('10.0.84.190', 21212),requestHandler=RequestHandler) as server:
   server.register_introspection_functions()

strings = []

def ArmazenarString(mensagem):
    if type(mensagem) == str:
        strings.push(mensagem)
        return 1
    return -1

def RecuperarMensagens():
    return strings

def RecuperarIP():
    return server.server_address[0]

def RecuperarDataHora():
    horas = ""
    minutos = ""

    if datetime.datetime.now().hour < 10:
        horas = "0" + str(datetime.datetime.now().hour)
    else:
        horas = str(datetime.datetime.now().hour)

    if datetime.datetime.now().minute < 10:
        minutos = "0" + str(datetime.datetime.now().minute)
    else:
        minutos = str(datetime.datetime.now().minute)

    return str(datetime.datetime.now().date()) + " " + horas + ":" + minutos

server.register_function(ArmazenarString, "ArmazenarString")
server.register_function(RecuperarMensagens, "Recuperarmensagens")
server.register_function(RecuperarIP, "RecuperarIP_Servidor")
server.register_function(RecuperarDataHora, "RecuperarDataHora")

server.serve_forever()

