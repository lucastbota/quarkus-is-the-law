#1º Step
Na pasta raiz do projeto, execute os três comandos abaixo

openssl genrsa -out publicKey.pem
openssl pkcs8 -topk8 -inform PEM -in publicKey.pem -out privateKey.pem -nocrypt
openssl rsa -in publicKey.pem -pubout -outform PEM -out publicKey.


documentação
openssl genrsa -out rsaPrivateKey.pem 2048
openssl rsa -pubout -in rsaPrivateKey.pem -out publicKey.pem
openssl pkcs8 -topk8 -nocrypt -inform pem -in rsaPrivateKey.pem -outform pem -out privateKey.pem

#2º Step

Mova os arquivos gerados p/ a pasta resources