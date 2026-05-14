import os
import glob

replacements = {
    "package com.calorie.tracker.data.local": "package com.calorie.tracker.feature_journal.data.local",
    "package com.calorie.tracker.data.remote": "package com.calorie.tracker.core.network",
    "package com.calorie.tracker.presentation.dashboard": "package com.calorie.tracker.feature_journal.presentation.dashboard",
    "import com.calorie.tracker.data.local.MealDao": "import com.calorie.tracker.feature_journal.data.local.MealDao",
    "import com.calorie.tracker.data.local.MealEntity": "import com.calorie.tracker.feature_journal.data.local.MealEntity",
    "import com.calorie.tracker.data.remote.CalorieApi": "import com.calorie.tracker.core.network.CalorieApi"
}

# Special case for AppDatabase since we moved it to core/database
replacements["package com.calorie.tracker.feature_journal.data.local\n\nimport"] = "package com.calorie.tracker.core.database\n\nimport com.calorie.tracker.feature_journal.data.local.MealDao\nimport com.calorie.tracker.feature_journal.data.local.MealEntity\nimport"

def update_file(filepath):
    with open(filepath, 'r') as f:
        content = f.read()
    
    original = content
    for old, new in replacements.items():
        content = content.replace(old, new)
        
    if "AppDatabase.kt" in filepath:
        content = content.replace("package com.calorie.tracker.feature_journal.data.local", "package com.calorie.tracker.core.database")
        
    if content != original:
        with open(filepath, 'w') as f:
            f.write(content)
        print(f"Updated {filepath}")

for root, _, files in os.walk("android/app/src/main/java"):
    for file in files:
        if file.endswith(".kt"):
            update_file(os.path.join(root, file))

