# second-level
Aplicación de ejemplo donde toco distintos usos de spring.

  - JPA + Cache level 2 con ehcache. PostgreSQL
  - Aspectos
  - Externalización de propiedades con Spring Cloud Config y Vault
  
# Desplegar la Aplicacion

  - docker run --name postgres -p 5432:5432 -e POSTGRES_PASSWORD=pass -d postgres
  - docker cp ./data_second_level/dump_data.sql postgres:/root/dump_data.sql
  - /usr/bin/psql -d postgres -U postgres -f dump_data.sql
  
  Con esto tenemos postgres levantado
  
  - docker run -d --name vault--cap-add=IPC_LOCK -e VAULT_DEV_ROOT_TOKEN_ID=myroot -e VAULT_ADDR=http://localhost:8200 -e VAULT_TOKEN=myroot vault
  - docker exec -it vault sh
  - vault login myroot
  - vault kv put secret/second-level spring.datasource.password=pass spring.datasource.username=postgres
  
  Con esto tenemos levantado vault
  
  - Iniciamos config-second-level
  - Iniciamos second-level
  
  
