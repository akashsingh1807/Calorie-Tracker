#!/bin/bash

BASE_URL="https://calorie-tracker-backend-878280965690.us-central1.run.app/api/v1"
TIMESTAMP=$(date +%s)
EMAIL="testuser_${TIMESTAMP}@example.com"
PASSWORD="password123"

echo "=== 1. Auth: Signup ==="
SIGNUP_RES=$(curl -s -X POST "${BASE_URL}/auth/signup" -H "Content-Type: application/json" -d "{\"name\": \"Prod Test User\", \"email\": \"${EMAIL}\", \"password\": \"${PASSWORD}\"}")
echo "Signup Result: $SIGNUP_RES"
TOKEN=$(echo "$SIGNUP_RES" | grep -o '"token":"[^"]*' | cut -d'"' -f4)

if [ -z "$TOKEN" ]; then
  echo "Error: Failed to get token. Signup failed."
  exit 1
fi

HEADER="Authorization: Bearer $TOKEN"

# Use a public image URL for testing production
IMAGE_URL="https://upload.wikimedia.org/wikipedia/commons/c/c8/Samosa_in_plate.jpg"

echo "=== 2. AI: Detect Food from URL (Production) ==="
DETECTION_RES=$(curl -s -X POST "${BASE_URL}/ai/detect-food" \
  -H "$HEADER" \
  -H "Content-Type: application/json" \
  -d "{
    \"imageUrl\": \"${IMAGE_URL}\"
  }")

echo "Detection Result: $DETECTION_RES"
