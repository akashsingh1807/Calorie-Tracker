import re

file_path = 'android/composeApp/src/commonMain/kotlin/com/calorie/tracker/feature_journal/presentation/dashboard/DashboardScreen.kt'
with open(file_path, 'r') as f:
    content = f.read()

# Replace brutalist border strokes
content = re.sub(r'^\s*border = androidx\.compose\.foundation\.BorderStroke\(3\.dp, androidx\.compose\.ui\.graphics\.Color\.Black\),\n', '', content, flags=re.MULTILINE)

# Replace brutalist shapes
content = re.sub(r'shape = androidx\.compose\.foundation\.shape\.RoundedCornerShape\(0\.dp\)', 'shape = androidx.compose.foundation.shape.RoundedCornerShape(24.dp)', content)

# Remove Card shape and colors explicitly if we switch to BounceCard
content = re.sub(r'Card\(\s*(modifier\s*=\s*[^\n]+,)?\s*shape\s*=\s*androidx\.compose\.foundation\.shape\.RoundedCornerShape\(24\.dp\),\s*colors\s*=\s*CardDefaults\.cardColors\(containerColor\s*=\s*[^\)]+\)\s*\)', r'BounceCard(\1)', content)

# Try just globally renaming Card to BounceCard where possible? 
# Wait, let's keep it simple: just remove the hardcoded 0.dp shapes and brutalist borders. The theme (Shapes.kt and Color.kt) will handle the rest if we just remove the hardcoded styles.

with open(file_path, 'w') as f:
    f.write(content)
print("Dashboard screen updated")
