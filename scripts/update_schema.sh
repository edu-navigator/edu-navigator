CONTAINER_NAME="my_solr"
CORE_NAME="schools"
LOCAL_SCHEMA_PATH="../backend/config/solr/schools/managed-schema.xml"
CONTAINER_SCHEMA_PATH="var/solr/data/${CORE_NAME}/conf/managed-schema.xml"

# Copy the schema from local to Docker container
echo "Copying schema from $LOCAL_SCHEMA_PATH to the Solr container..."
docker cp "$LOCAL_SCHEMA_PATH" "$CONTAINER_NAME:$CONTAINER_SCHEMA_PATH"
# Check if the copy was successful
if [ $? -eq 0 ]; then
  echo "Schema updated successfully in the Solr container."

  # Restart the Solr container
  echo "Restarting Solr container..."
  docker restart "$CONTAINER_NAME"

  if [ $? -eq 0 ]; then
    echo "Solr container restarted successfully."
  else
    echo "Failed to restart Solr container."
  fi
else
  echo "Failed to copy the schema to the Solr container."
fi