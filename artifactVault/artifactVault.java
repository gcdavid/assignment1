import java.util.Arrays;
import java.util.Comparator;

class ArtifactVault {
    private Artifact[] vault;
    private int size;

    // Constructor to initialize the vault array
    public ArtifactVault(int capacity) {
        this.vault = new Artifact[capacity];
        this.size = 0; // Tracks the number of artifacts added
    }

    // Add an artifact to the first empty slot
    public void addArtifact(Artifact artifact) {
        if (size < vault.length) {
            vault[size] = artifact; // Add the artifact to the next empty slot
            size++; // Increment the size count
            System.out.println("Added artifact: " + artifact.getName());
        } else {
            System.out.println("Vault is full. Cannot add more artifacts.");
        }
    }

    // Remove an artifact by its name
    public void removeArtifact(String name) {
        for (int i = 0; i < size; i++) {
            if (vault[i] != null && vault[i].getName().equals(name)) {
                System.out.println("Removed artifact: " + vault[i].getName());
                vault[i] = null; // Remove the artifact by setting its slot to null
                shiftLeft(i); // Shift the remaining artifacts to the left to fill the gap
                size--; // Decrease size count
                return;
            }
        }
        System.out.println("Artifact not found: " + name);
    }

    // Shift all elements to the left after removal to maintain compactness
    private void shiftLeft(int index) {
        for (int i = index; i < size - 1; i++) {
            vault[i] = vault[i + 1];
        }
        vault[size - 1] = null; // Clear the last slot
    }

    // Find an artifact using linear search
    public Artifact findArtifactLinear(String name) {
        for (int i = 0; i < size; i++) {
            if (vault[i] != null && vault[i].getName().equals(name)) {
                return vault[i];
            }
        }
        return null;
    }

    // Find an artifact using binary search (assuming the array is sorted by artifact age)
    public Artifact findArtifactBinary(String name) {
        // Sort the array by artifact age before performing binary search
        sortByAge();

        int left = 0;
        int right = size - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            Artifact midArtifact = vault[mid];

            if (midArtifact != null) {
                int comparison = midArtifact.getName().compareTo(name);

                if (comparison == 0) {
                    return midArtifact;
                } else if (comparison < 0) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                return null; // If artifact is null, binary search fails
            }
        }

        return null;
    }

    // Helper method to sort the artifacts by age
    public void sortByAge() {
        Arrays.sort(vault, 0, size, Comparator.comparingInt(Artifact::getAge));
    }

    
        public static void main(String[] args) {
            ArtifactVault vault = new ArtifactVault(5);
    
            vault.addArtifact(new Artifact("Artifact A", 100));
            vault.addArtifact(new Artifact("Artifact B", 200));
            vault.addArtifact(new Artifact("Artifact C", 150));
    
            // Linear search
            Artifact foundArtifact = vault.findArtifactLinear("Artifact B");
            if (foundArtifact != null) {
                System.out.println("Found via linear search: " + foundArtifact);
            }
    
            // Binary search (array is assumed to be sorted by age)
            Artifact foundBinaryArtifact = vault.findArtifactBinary("Artifact A");
            if (foundBinaryArtifact != null) {
                System.out.println("Found via binary search: " + foundBinaryArtifact);
            }
    
            // Remove an artifact
            vault.removeArtifact("Artifact B");
    
            // Try to find the removed artifact
            Artifact removedArtifact = vault.findArtifactLinear("Artifact B");
            if (removedArtifact == null) {
                System.out.println("Artifact B not found, as expected.");
            }
        }
    
    
}


