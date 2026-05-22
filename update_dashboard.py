import re

file_path = 'android/composeApp/src/commonMain/kotlin/com/calorie/tracker/feature_journal/presentation/dashboard/DashboardScreen.kt'
with open(file_path, 'r') as f:
    content = f.read()

# 1. Update Imports
content = content.replace('import com.calorie.tracker.ui.components.BounceCard', 'import com.calorie.tracker.ui.components.Flip7Card\nimport com.calorie.tracker.ui.components.Flip7CardVariant\nimport com.calorie.tracker.ui.components.Flip7Button\nimport com.calorie.tracker.ui.components.Flip7ButtonVariant\nimport com.calorie.tracker.ui.components.Flip7SectionTitle')

# 2. Replace BounceCard -> Flip7Card
content = content.replace('BounceCard', 'Flip7Card')

# 3. Replace regular Cards with Flip7Card (naive replace for standard cards without complex shapes)
# Wait, there are regular Cards that were not replaced by BounceCard yet (e.g. Card(modifier=..., shape=..., colors=...)).
# I will regex replace them.
content = re.sub(r'Card\(\s*modifier\s*=\s*(.*?),\s*shape\s*=\s*androidx\.compose\.foundation\.shape\.RoundedCornerShape\(.*?\),\s*colors\s*=\s*CardDefaults\.cardColors\(.*?\),?\s*\)', r'Flip7Card(modifier = \1)', content)

# 4. Replace buttons
content = content.replace('Button(', 'Flip7Button(')
content = content.replace('OutlinedButton(', 'Flip7Button(variant = Flip7ButtonVariant.TEAL, ')

# 5. Section Titles
# There are text titles like Text(text = "Today's Meals", ...)
# Replace them with Flip7SectionTitle
content = re.sub(r'Text\(\s*text\s*=\s*"Today\'s Meals",\s*fontWeight\s*=\s*FontWeight\.SemiBold,\s*fontSize\s*=\s*18\.sp,\s*color\s*=\s*Color\.Black\s*\)', r'Flip7SectionTitle(emoji = "🍽️", title = "Today\'s Meals")', content)
content = re.sub(r'Text\(\s*text\s*=\s*"Today\'s Meals",\s*fontSize\s*=\s*18\.sp,\s*fontWeight\s*=\s*FontWeight\.SemiBold,\s*color\s*=\s*Color\.Black\s*\)', r'Flip7SectionTitle(emoji = "🍽️", title = "Today\'s Meals")', content)

# Remove the old section title if it was a simpler Text node (without semiBold, etc just to be safe)
# Actually, the user's DashboardScreen has a Text(text = "Today's Meals") somewhere. Let's just catch the basic one.
content = re.sub(r'Text\(\s*text\s*=\s*"Today\'s Meals"[^\)]+\)', r'Flip7SectionTitle(emoji = "🍽️", title = "Today\'s Meals")', content)

# Same for Micronutrients
# wait, MicronutrientsCard is in a separate file or inline? I'll let it be for now.

with open(file_path, 'w') as f:
    f.write(content)
print("Dashboard screen updated for Flip7")
