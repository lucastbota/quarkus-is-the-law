# security-openid-connect-quickstart Project
docker run --name keycloak -e KEYCLOAK_USER=admin -e KEYCLOAK_PASSWORD=admin -p 8180:8080 quay.io/keycloak/keycloak:latest

#1 realm
http://localhost:8180/auth/admin/master/console/#/create/realm
nome do realm: quarkus | enabled: ON

#2 client
http://localhost:8180/auth/admin/master/console/#/create/client/quarkus

#3 roles
http://localhost:8180/auth/admin/master/console/#/create/role/quarkus
crie uma role admin e uma role user

#4 usuários
http://localhost:8180/auth/admin/master/console/#/create/user/quarkus
crie um usuário chamado admin e outro user.

preencha as abas 'credentials' e 'roles' de acordo.