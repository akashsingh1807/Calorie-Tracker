import re

file_path = 'android/composeApp/src/commonMain/kotlin/com/calorie/tracker/feature_journal/presentation/dashboard/DashboardScreen.kt'
with open(file_path, 'r') as f:
    content = f.read()

# Add imports
imports = """import com.calorie.tracker.ui.components.Flip7Card
import com.calorie.tracker.ui.components.Flip7CardVariant
import com.calorie.tracker.ui.components.Flip7Button
import com.calorie.tracker.ui.components.Flip7ButtonVariant
import com.calorie.tracker.ui.components.Flip7SectionTitle
"""
content = content.replace("import com.calorie.tracker.model.Meal", "import com.calorie.tracker.model.Meal\n" + imports)

# Remove brutalist shapes
content = re.sub(r'border\s*=\s*androidx\.compose\.foundation\.BorderStroke\(3\.dp,\s*androidx\.compose\.ui\.graphics\.Color\.Black\),?\n?', '', content)
content = re.sub(r'shape\s*=\s*androidx\.compose\.foundation\.shape\.RoundedCornerShape\(0\.dp\),?\n?', '', content)

# Replace brutalist buttons with Flip7Button (only the ones we can safely match)
# e.g., OutlinedButton(onClick = { ... }, ... ) { Text("Label", ...) }
# Let's just fix the cards to Flip7Card first
content = re.sub(r'Card\(\s*(modifier\s*=\s*[^\n]+,?)?\s*colors\s*=\s*CardDefaults\.cardColors\(containerColor\s*=\s*Color\.White\),?\s*\)', r'Flip7Card(\1)', content)

# Section Titles
content = re.sub(r'Text\(\s*text\s*=\s*"Today\'s Meals",\s*fontWeight\s*=\s*FontWeight\.SemiBold,\s*fontSize\s*=\s*18\.sp,\s*color\s*=\s*Color\.Black\s*\)', r'Flip7SectionTitle(emoji = "🍽️", title = "Today\'s Meals")', content)
content = re.sub(r'Text\(\s*text\s*=\s*"Micronutrients",\s*fontWeight\s*=\s*FontWeight\.SemiBold,\s*fontSize\s*=\s*18\.sp,\s*color\s*=\s*Color\.Black\s*\)', r'Flip7SectionTitle(emoji = "🥗", title = "Micronutrients")', content)

with open(file_path, 'w') as f:
    f.write(content)
print("Dashboard cleaned")
