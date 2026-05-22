import os
import re

directory = 'android/composeApp/src/commonMain/kotlin/com/calorie/tracker'

for root, _, files in os.walk(directory):
    for file in files:
        if file.endswith('.kt'):
            file_path = os.path.join(root, file)
            with open(file_path, 'r') as f:
                content = f.read()

            original_content = content
            content = re.sub(r'^\s*border = androidx\.compose\.foundation\.BorderStroke\(3\.dp, androidx\.compose\.ui\.graphics\.Color\.Black\),\n', '', content, flags=re.MULTILINE)
            content = re.sub(r'shape = androidx\.compose\.foundation\.shape\.RoundedCornerShape\(0\.dp\)', 'shape = androidx.compose.foundation.shape.RoundedCornerShape(24.dp)', content)
            # Remove from TextFields
            content = re.sub(r'shape = RoundedCornerShape\(0\.dp\)', 'shape = RoundedCornerShape(16.dp)', content)

            if original_content != content:
                with open(file_path, 'w') as f:
                    f.write(content)
                print(f"Updated {file_path}")

print("Done")
