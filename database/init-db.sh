echo "Creating project database..."

psql -v ON_ERROR_STOP=1 --username postgres --dbname postgres <<-EOSQL
CREATE USER projectdb;
CREATE DATABASE projectdb;
GRANT ALL PRIVILEGES ON DATABASE projectdb TO projectdb;
EOSQL

echo "Done creating project database."
