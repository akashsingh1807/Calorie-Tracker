#!/bin/bash

BASE_URL="http://localhost:8081/api/v1"
TIMESTAMP=$(date +%s)
EMAIL="testuser_${TIMESTAMP}@example.com"
PASSWORD="password123"

echo "=== 1. Auth: Signup ==="
SIGNUP_RES=$(curl -s -X POST "${BASE_URL}/auth/register" -H "Content-Type: application/json" -d "{\"name\": \"Test User\", \"email\": \"${EMAIL}\", \"password\": \"${PASSWORD}\"}")
echo "Signup result: $SIGNUP_RES"
echo ""

echo "=== 2. Auth: Login ==="
LOGIN_RES=$(curl -s -X POST "${BASE_URL}/auth/login" -H "Content-Type: application/json" -d "{\"email\": \"${EMAIL}\", \"password\": \"${PASSWORD}\"}")
TOKEN=$(echo "$LOGIN_RES" | grep -o '"token":"[^"]*' | cut -d'"' -f4)
echo "Extracted Token: $TOKEN"
echo ""

HEADER="Authorization: Bearer $TOKEN"

# Read samosa base64
DUMMY_IMAGE=$(cat samosa_base64.txt)

echo "=== 3. AI: Detect Food from Image (Samosas) ==="
DETECTION_RES=$(curl -s -X POST "${BASE_URL}/ai/detect-food" \
  -H "$HEADER" \
  -H "Content-Type: application/json" \
  -d "{
    \"imageUrl\": \"data:image/png;base64,${DUMMY_IMAGE}\"
  }")

echo "Detection Result: $DETECTION_RES"
