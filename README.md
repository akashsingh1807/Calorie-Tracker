# 🥗 AI Calorie Tracker

An AI-powered journal-style calorie and fitness tracking application. Instead of manually searching for foods, users can log meals using natural language text or by simply taking a picture of their food. The system utilizes Google's Gemini Vision API to automatically identify food items and estimate nutritional content.

## ✨ Core Features
- **🧠 AI Food Recognition**: Upload an image or type what you ate, and the AI will extract the food items.
- **📱 Smart Food Journal**: Log meals, water intake, and fasting periods seamlessly.
- **📊 Advanced Analytics**: Monitor daily, weekly, and monthly trends for calories, macros, and weight.
- **🤖 AI Meal Coach**: Get personalized healthy meal suggestions based on your fitness goals (e.g., Fat Loss, Muscle Gain).
- **🔒 Secure Authentication**: Stateless JWT-based user authentication.

## 🛠 Tech Stack

### Backend
- **Java 17 & Spring Boot 3.x**
- **PostgreSQL** (Primary Relational Database)
- **Redis** (Caching & Session Management)
- **MinIO** (S3-compatible Object Storage for Image Uploads)
- **Spring Security + jjwt** (Stateless JWT Authentication)
- **Google Gemini API** (Generative AI for text and vision analysis)

### Android App
- **Kotlin**
- **Jetpack Compose** (Modern UI toolkit)
- **Clean Architecture** (Package-by-Feature structure)
- **Retrofit & OkHttp** (Network layer)
- **Room Database** (Local caching & Offline support)

---

## 🚀 Getting Started Locally

### Prerequisites
- Docker & Docker Compose
- Java 17 & Maven
- Android Studio (for the mobile app)

### 1. Start the Infrastructure (Databases)
The backend requires PostgreSQL, Redis, and MinIO to be running.
```bash
cd backend
docker-compose up -d
```

### 2. Configure Environment Variables
Create a local configuration file to securely store your API keys.
1. Navigate to `backend/src/main/resources/`
2. Create a file named `application-local.yml`
3. Add your Gemini API key (Get a free one at [Google AI Studio](https://aistudio.google.com/)):
```yaml
gemini:
  api:
    key: YOUR_GEMINI_API_KEY_HERE
```

### 3. Run the Spring Boot Backend
Start the application using the `local` Spring profile so it picks up your API keys:
```bash
cd backend
./mvnw spring-boot:run -Dspring-boot.run.profiles=local
```
The backend API will be available at `http://localhost:8081`. You can view and test the Swagger UI at `http://localhost:8081/swagger-ui/index.html`.

### 4. Run the Android App
1. Open the `android/` folder in Android Studio.
2. Wait for Gradle to sync dependencies.
3. Build and Run the app on an Android Emulator.

---

## ☁️ CI/CD Deployment
This repository is configured with GitHub Actions. Any push to the `main` branch will automatically:
1. Run backend unit tests.
2. Build a Docker container of the backend.
3. Deploy the container to Google Cloud Run.

*(Requires setting up GCP Service Accounts and secrets in GitHub repository settings).*
