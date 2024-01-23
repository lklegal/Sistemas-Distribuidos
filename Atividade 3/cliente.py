import xmlrpc.client

s = xmlrpc.client.ServerProxy('http://10.0.84.190:21212')

s.ArmazenarString("Hmmmmmm")
print(s.Recuperarmensagens())
print(s.RecuperarIP_Servidor())
print(s.RecuperarDataHora())

