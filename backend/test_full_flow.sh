#!/bin/bash

BASE_URL="http://localhost:8081/api/v1"
TIMESTAMP=$(date +%s)
EMAIL="testuser_${TIMESTAMP}@example.com"
PASSWORD="password123"

echo "=== 1. Auth: Signup ==="
SIGNUP_RES=$(curl -s -X POST "${BASE_URL}/auth/register" -H "Content-Type: application/json" -d "{\"name\": \"Test User\", \"email\": \"${EMAIL}\", \"password\": \"${PASSWORD}\"}")
TOKEN=$(echo "$SIGNUP_RES" | grep -o '"token":"[^"]*' | cut -d'"' -f4)

HEADER="Authorization: Bearer $TOKEN"

# Use the samosa image we generated earlier
SAMOSA_IMAGE="/Users/akashsingh/.gemini/antigravity/brain/60d6446e-09ff-45d2-8bdf-c7213a6e323d/samosas_test_image_1778875333059.png"

echo "=== 2. Media: Upload Image ==="
UPLOAD_RES=$(curl -s -X POST "${BASE_URL}/media/upload" \
  -H "$HEADER" \
  -F "file=@${SAMOSA_IMAGE}")
IMAGE_URL=$(echo "$UPLOAD_RES" | grep -o '"imageUrl":"[^"]*' | cut -d'"' -f4)
echo "Uploaded Image URL: $IMAGE_URL"
echo ""

echo "=== 3. AI: Detect Food from S3 URL ==="
DETECTION_RES=$(curl -s -X POST "${BASE_URL}/ai/detect-food" \
  -H "$HEADER" \
  -H "Content-Type: application/json" \
  -d "{
    \"imageUrl\": \"${IMAGE_URL}\"
  }")

echo "Detection Result: $DETECTION_RES"
