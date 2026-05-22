import re

file_path = 'android/composeApp/src/commonMain/kotlin/com/calorie/tracker/feature_journal/presentation/dashboard/DashboardScreen.kt'
with open(file_path, 'r') as f:
    content = f.read()

# Fix the broken BounceCard syntax
content = re.sub(r'BounceCard\((.*?),\s*\)\s*\,\s*\)\s*\{', r'BounceCard(\1) {', content, flags=re.DOTALL)
content = re.sub(r'BounceCard\((.*?),\s*\)\s*\)\s*\{', r'BounceCard(\1) {', content, flags=re.DOTALL)
content = re.sub(r'BounceCard\(\s*\)\s*\)\s*\{', r'BounceCard() {', content, flags=re.DOTALL)


with open(file_path, 'w') as f:
    f.write(content)
print("BounceCard syntax fixed in DashboardScreen")
