### AnagramFinder

A simple Java CLI utility that reads a text file of words and prints groups of anagrams found in the file. Words that are anagrams of each other are printed together on the same line.

---

### Features
- **Groups anagrams** by sorting each word's characters into a signature
- **Plain text I/O**: reads from a `.txt` file, prints groups to stdout
- **Zero dependencies** beyond the standard Java runtime

---

### Requirements
- **Java**: JDK 8 or newer
- **OS**: Works on Windows, macOS, and Linux (commands below show Windows PowerShell examples)

---

### Project Structure
- `src/AnagramFinder.java`: Main program
- `sample.txt`: Example input file (read by default)
- `out/production/AnagramFinder/AnagramFinder.class`: Example compiled output (may differ on your machine)

---

### Getting Started
1. Place your input words (one per line or separated by whitespace per line) into `sample.txt` in the project root.
2. Compile the program.
3. Run the program from the project root so it can find `sample.txt`.

---

### Build
From the project root (`AnagramFinder` directory):

```powershell
# Create output directory (if it doesn't exist)
mkdir out 2>$null

# Compile
javac -d out src\AnagramFinder.java
```

This compiles classes into `out`.

---

### Run
Run from the project root so the program can read `sample.txt`:

```powershell
java -cp out AnagramFinder
```

By default, the program reads `sample.txt` (hardcoded path) located in the project root. It prints each anagram group on its own line.

---

### Input Format
- Each line is treated as a single word (the program currently reads each line as-is).
- Example `sample.txt`:

```
act
cat
tree
race
care
acre
bee
```

---

### Output Example
Given the sample above, output could look like:

```
race care acre
bee
act cat
tree
```

Order within groups depends on input order; group order depends on hash map iteration and may vary.

---

### How It Works
- Each word is converted into a sorted-character "signature" (e.g., `cat` → `act`).
- A map groups words by this signature.
- The program prints the grouped lists.

Time complexity per word is approximately \(O(k \log k)\) for sorting, where \(k\) is word length. (Find more about performance in the [Design Decisions file](docs/manual.pdf))

---

### Customization
- **Change input file**: Currently the filename is hardcoded as `sample.txt` in `AnagramFinder.java`.
  - To use a different file, either rename your file to `sample.txt` or change the string in `new FileReader("sample.txt")` and recompile.
- **Preprocessing**: If you want to ignore case or punctuation, normalize the input before generating the signature (e.g., convert to lowercase, strip non-letters).
