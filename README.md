# Docker-App

1.Create a docker network: <br />
docker network create -d bridge --subnet 10.0.0.1/24 my-network <br />
2. Run postgres on this network: <br />
docker run -d --net my-network -p 6000:5432  -v /var/lib/postgresql/data  --name postgres postgres:10 <br />
3. mvn clean install <br />
4. Build app image 
docker build --tag=rest-app --rm=true . <br />
5. Run app container on same network as postgres <br />
docker run -d --net my-network -p 5000:8080 rest-app <br />


In case app containers fails due to db connection, run docker network inspect my-network and update Docker file with correct IP address of the container that runs postgres.
