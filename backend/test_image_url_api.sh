#!/bin/bash

BASE_URL="http://localhost:8081/api/v1"
TIMESTAMP=$(date +%s)
EMAIL="testuser_${TIMESTAMP}@example.com"
PASSWORD="password123"

echo "=== 1. Auth: Signup ==="
SIGNUP_RES=$(curl -s -X POST "${BASE_URL}/auth/signup" -H "Content-Type: application/json" -d "{\"name\": \"Test User\", \"email\": \"${EMAIL}\", \"password\": \"${PASSWORD}\"}")
TOKEN=$(echo "$SIGNUP_RES" | grep -o '"token":"[^"]*' | cut -d'"' -f4)

HEADER="Authorization: Bearer $TOKEN"

IMAGE_URL="https://upload.wikimedia.org/wikipedia/commons/c/c8/Samosa_in_plate.jpg"

echo "=== 3. AI: Detect Food from URL (Public Samosa Image) ==="
DETECTION_RES=$(curl -s -X POST "${BASE_URL}/ai/detect-food" \
  -H "$HEADER" \
  -H "Content-Type: application/json" \
  -d "{
    \"imageUrl\": \"${IMAGE_URL}\"
  }")

echo "Detection Result: $DETECTION_RES"
