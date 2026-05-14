import os
import shutil

moves = [
    ("android/app/src/main/java/com/calorie/tracker/data/local/MealDao.kt", "android/app/src/main/java/com/calorie/tracker/feature_journal/data/local/MealDao.kt"),
    ("android/app/src/main/java/com/calorie/tracker/data/local/MealEntity.kt", "android/app/src/main/java/com/calorie/tracker/feature_journal/data/local/MealEntity.kt"),
    ("android/app/src/main/java/com/calorie/tracker/data/local/AppDatabase.kt", "android/app/src/main/java/com/calorie/tracker/core/database/AppDatabase.kt"),
    ("android/app/src/main/java/com/calorie/tracker/data/remote/CalorieApi.kt", "android/app/src/main/java/com/calorie/tracker/core/network/CalorieApi.kt"),
    ("android/app/src/main/java/com/calorie/tracker/presentation/dashboard/DashboardScreen.kt", "android/app/src/main/java/com/calorie/tracker/feature_journal/presentation/dashboard/DashboardScreen.kt"),
    ("android/app/src/main/java/com/calorie/tracker/presentation/dashboard/DashboardViewModel.kt", "android/app/src/main/java/com/calorie/tracker/feature_journal/presentation/dashboard/DashboardViewModel.kt")
]

for src, dst in moves:
    if os.path.exists(src):
        os.makedirs(os.path.dirname(dst), exist_ok=True)
        shutil.move(src, dst)
        print(f"Moved {src} to {dst}")
    else:
        print(f"{src} does not exist.")
