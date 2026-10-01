import java.util.*;

class ThroneInheritance {

    // Stores children of each person
    private Map<String, List<String>> children;

    // Stores whether a person is dead
    private Set<String> dead;

    // Name of the king
    private String king;

    public ThroneInheritance(String kingName) {
        king = kingName;

        children = new HashMap<>();
        dead = new HashSet<>();

        children.put(kingName, new ArrayList<>());
    }

    public void birth(String parentName, String childName) {

        // Create list for parent if it doesn't exist
        children.putIfAbsent(parentName, new ArrayList<>());

        // Add child at the end
        children.get(parentName).add(childName);

        // Create empty child list for the new person
        children.put(childName, new ArrayList<>());
    }

    public void death(String name) {

        // Just mark the person as dead
        dead.add(name);
    }

    public List<String> getInheritanceOrder() {

        List<String> result = new ArrayList<>();

        // Start DFS from king
        dfs(king, result);

        return result;
    }

    private void dfs(String person, List<String> result) {

        // Add person only if alive
        if (!dead.contains(person)) {
            result.add(person);
        }

        // Visit children from oldest to youngest
        for (String child : children.get(person)) {
            dfs(child, result);
        }
    }
}