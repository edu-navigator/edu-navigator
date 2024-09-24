#!/bin/bash

# Configuration
KEYCLOAK_URL="http://localhost:8080"
ADMIN_USERNAME="admin"   # Replace with your admin username
ADMIN_PASSWORD="admin"   # Replace with your admin password
REALM_NAME="my_new_realm"
CLIENT_NAME="my_new_client"

# Function to get an access token
get_access_token() {
    TOKEN_RESPONSE=$(curl -s -X POST "$KEYCLOAK_URL/realms/master/protocol/openid-connect/token" \
        -H "Content-Type: application/x-www-form-urlencoded" \
        -d "username=$ADMIN_USERNAME" \
        -d "password=$ADMIN_PASSWORD" \
        -d 'grant_type=password' \
        -d 'client_id=admin-cli')

    echo $(echo $TOKEN_RESPONSE | jq -r .access_token)
}

# Get the access token
ACCESS_TOKEN=$(get_access_token)
echo ACCESS_TOKEN
# Create the realm
curl -X POST "$KEYCLOAK_URL/admin/realms" \
    -H "Authorization: Bearer $ACCESS_TOKEN" \
    -H "Content-Type: application/json" \
    -d '{
        "realm": "'"$REALM_NAME"'",
        "enabled": true
    }'

# Create the client
curl -X POST "$KEYCLOAK_URL/admin/realms/$REALM_NAME/clients" \
    -H "Authorization: Bearer $ACCESS_TOKEN" \
    -H "Content-Type: application/json" \
    -d '{
        "clientId": "'"$CLIENT_NAME"'",
        "enabled": true,
        "protocol": "openid-connect",
        "publicClient": true,
        "redirectUris": ["*"]
    }'

echo "Realm '$REALM_NAME' and client '$CLIENT_NAME' created successfully."
