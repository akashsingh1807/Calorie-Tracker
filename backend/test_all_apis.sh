#!/bin/bash

BASE_URL="http://localhost:8081/api/v1"
TIMESTAMP=$(date +%s)
EMAIL="testuser_${TIMESTAMP}@example.com"
PASSWORD="password123"

echo "=== 1. Auth: Signup ==="
SIGNUP_RES=$(curl -s -w "\nHTTP_STATUS:%{http_code}" -X POST "${BASE_URL}/auth/signup" -H "Content-Type: application/json" -d "{\"name\": \"Test User\", \"email\": \"${EMAIL}\", \"password\": \"${PASSWORD}\"}")
echo "$SIGNUP_RES" | head -n 1
echo ""

echo "=== 2. Auth: Login ==="
LOGIN_RES=$(curl -s -X POST "${BASE_URL}/auth/login" -H "Content-Type: application/json" -d "{\"email\": \"${EMAIL}\", \"password\": \"${PASSWORD}\"}")
echo "$LOGIN_RES"
TOKEN=$(echo "$LOGIN_RES" | grep -o '"token":"[^"]*' | cut -d'"' -f4)
echo "Extracted Token: ${TOKEN:0:10}..."
echo ""

HEADER="Authorization: Bearer $TOKEN"

echo "=== 3. Users: Get Me ==="
curl -s -X GET "${BASE_URL}/users/me" -H "$HEADER"
echo -e "\n"

echo "=== 4. Water: Log Water ==="
curl -s -X POST "${BASE_URL}/water" -H "$HEADER" -H "Content-Type: application/json" -d '{"amountMl": 500}'
echo -e "\n"

echo "=== 5. Meals: Log Meal ==="
curl -s -X POST "${BASE_URL}/meals" -H "$HEADER" -H "Content-Type: application/json" -d '{"mealType": "BREAKFAST", "totalCalories": 350, "totalProtein": 15, "totalCarbs": 40, "totalFat": 10, "foodItems": []}'
echo -e "\n"

echo "=== 6. Fasting: Start Fast ==="
curl -s -X POST "${BASE_URL}/fasting/start" -H "$HEADER" -H "Content-Type: application/json" -d '{"goalHours": 16}'
echo -e "\n"

echo "=== 7. Analytics: Daily ==="
curl -s -X GET "${BASE_URL}/analytics/daily" -H "$HEADER"
echo -e "\n"

echo "=== 8. AI: Meal Suggestions ==="
curl -s -X POST "${BASE_URL}/ai/meal-suggestions" -H "$HEADER" -H "Content-Type: application/json" -d '{"goal": "FAT_LOSS"}'
echo -e "\n"

