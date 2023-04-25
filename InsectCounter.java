import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class InsectCounter {
    public static void main(String[] args) {

        // Read in the insect pattern file
        String insectFilename = "insect.txt";  // Filename of the insect pattern file
        StringBuilder sbInsect = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(insectFilename))) {
            String line;
            while ((line = br.readLine()) != null) {
                sbInsect.append(line).append("\n");  // Append each line of the insect pattern file to the StringBuilder
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        String insectPattern = sbInsect.toString();  // Convert the StringBuilder to a String

        // Read in the land file
        String landFilename = "land.txt";  // Filename of the land file
        StringBuilder sbLand = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(landFilename))) {
            String line;
            while ((line = br.readLine()) != null) {
                sbLand.append(line).append("\n");  // Append each line of the land file to the StringBuilder
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        String land = sbLand.toString();  // Convert the StringBuilder to a String

        int count = countOccurrences(land, insectPattern);  // Count the number of occurrences of the insect pattern in the land

        // Print the result
        System.out.println("Number of insects found: " + count);  // Print the number of occurrences of the insect pattern
        
    }

    // Function to count the number of occurrences of the insect pattern in the land
    public static int countOccurrences(String land, String insectPattern) {
        int count = 0;  // Initialize count to 0
        String[] patternLines = insectPattern.split("\n");  // Split the insect pattern into lines
        String[] landLines = land.split("\n");  // Split the land into lines
    
        // Iterate over each possible location of the insect pattern in the land
        for (int i = 0; i <= landLines.length - patternLines.length; i++) {
            for (int j = 0; j <= landLines[i].length() - patternLines[0].length(); j++) {
                boolean match = true;  // Initialize match to true
    
                // Check if the insect pattern matches the land at the current location
                for (int k = 0; k < patternLines.length; k++) {
                    if (!landLines[i + k].substring(j, j + patternLines[k].length()).equals(patternLines[k])) {
                        match = false;
                        break;
                    }
                }
    
                if (match) {
                    count++;  // If there is a match, increment count
                }
            }
        }
    
        return count;  // Return the number of occurrences of the insect pattern in the land
    }
}
