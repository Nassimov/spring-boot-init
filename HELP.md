
sudo -u postgres psql

postgres=# CREATE USER nassim WITH PASSWORD 'izane';
GRANT CONNECT ON DATABASE users TO nassim;
GRANT USAGE ON SCHEMA public TO nassim;
GRANT SELECT, INSERT, UPDATE, DELETE ON ALL TABLES IN SCHEMA public TO nassim;
GRANT CREATE ON SCHEMA public TO nassim;

postgres=# GRANT CREATE ON DATABASE users TO nassim;  -- Ensure user has CREATE privileges on the database
GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA public TO nassim;  -- Grant all privileges on tables
GRANT ALL PRIVILEGES ON SCHEMA public TO nassim;  -- Grant all privileges on the public schema



ALTER ROLE nassim WITH SUPERUSER;








sudo nano /etc/postgresql/<version>/main/postgresql.conf

changer le port et
#listen_addresses = 'localhost'  -> listen_addresses = ''



psql -h localhost -d users -U nassim -p 5887

sudo systemctl restart postgresql





Swagger link http://localhost:8080/swagger-ui/index.html







add annotation , bean compononte configuration 