import requests
import json

url = "http://localhost:8080/projekt/webresources/restservices.products"
headers = {'accept' : 'application/json'}
r = requests.get(url,headers=headers)
print(r.text)
'''
#print(r.status_code)
#print(r.text)
print(r.headers)

url2 = "http://localhost:8080/projekt/webresources/restservices.products/1"
dr = requests.delete(url2)
print(dr.headers)
'''