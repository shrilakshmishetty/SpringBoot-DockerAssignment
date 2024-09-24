!/bin/sh

# wait-for-db.sh

set -e
echo "Waiting for database connection..."
sleep 15

echo "Database is up - executing command"
exec "$@"
