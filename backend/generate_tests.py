import os
import re

def create_test_file(java_path, is_controller=False):
    with open(java_path, 'r') as f:
        content = f.read()
    
    package_match = re.search(r'package\s+(com\.calorie\.tracker\.[a-zA-Z0-9_]+);', content)
    class_match = re.search(r'public\s+class\s+([a-zA-Z0-9_]+)', content)
    
    if not package_match or not class_match:
        return
        
    package_name = package_match.group(1)
    class_name = class_match.group(1)
    
    test_package = package_name
    test_class = f"{class_name}Test"
    
    rel_dir = package_name.replace('.', '/')
    test_dir = os.path.join('src', 'test', 'java', rel_dir)
    os.makedirs(test_dir, exist_ok=True)
    
    test_file_path = os.path.join(test_dir, f"{test_class}.java")
    
    if os.path.exists(test_file_path):
        return
        
    template = f"""package {test_package};

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class {test_class} {{

    @InjectMocks
    private {class_name} unitUnderTest;

    @Test
    public void contextLoads() {{
        assertNotNull(unitUnderTest);
    }}
}}
"""

    with open(test_file_path, 'w') as f:
        f.write(template)
    print(f"Generated {test_file_path}")

def main():
    for root, dirs, files in os.walk('src/main/java/com/calorie/tracker/controller'):
        for file in files:
            if file.endswith('.java'):
                create_test_file(os.path.join(root, file), is_controller=True)
                
    for root, dirs, files in os.walk('src/main/java/com/calorie/tracker/service'):
        for file in files:
            if file.endswith('.java'):
                create_test_file(os.path.join(root, file), is_controller=False)

if __name__ == "__main__":
    main()
