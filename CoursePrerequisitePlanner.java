import java.util.*;

public class CoursePrerequisitePlanner {

    private Map<String, List<String>> graph;
    private Map<String, Integer> indegree;

    public CoursePrerequisitePlanner() {
        graph = new HashMap<>();
        indegree = new HashMap<>();
    }

    public void addCourse(String course) {
        if (!graph.containsKey(course)) {
            graph.put(course, new ArrayList<>());
            indegree.put(course, 0);
        }
    }

    public void addPrerequisite(String prerequisite, String course) {
        if (!graph.containsKey(prerequisite) || !graph.containsKey(course)) {
            System.out.println("Course not found!");
            return;
        }

        if (prerequisite.equals(course)) {
            System.out.println("A course cannot depend on itself!");
            return;
        }

        if (!graph.get(prerequisite).contains(course)) {
            graph.get(prerequisite).add(course);
            indegree.put(course, indegree.get(course) + 1);
        }
    }

    public void displaySortedCourses() {
        List<String> courses = new ArrayList<>(graph.keySet());
        Collections.sort(courses);

        System.out.println("\nCourses in alphabetical order:");

        for (String course : courses) {
            System.out.println(course);
        }
    }

    private boolean dfs(String course, Map<String, Integer> visited,
                        Deque<String> stack) {

        visited.put(course, 1);

        for (String next : graph.get(course)) {
            int state = visited.get(next);

            if (state == 1) {
                return false;
            }

            if (state == 0) {
                if (!dfs(next, visited, stack)) {
                    return false;
                }
            }
        }

        visited.put(course, 2);
        stack.push(course);

        return true;
    }

    public void dfsTopologicalSort() {
        Map<String, Integer> visited = new HashMap<>();

        for (String course : graph.keySet()) {
            visited.put(course, 0);
        }

        Deque<String> stack = new ArrayDeque<>();

        for (String course : graph.keySet()) {
            if (visited.get(course) == 0) {
                if (!dfs(course, visited, stack)) {
                    System.out.println("\nCycle detected! No valid course order.");
                    return;
                }
            }
        }

        System.out.println("\nCourse order using DFS:");

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    public void bfsTopologicalSort() {
        Map<String, Integer> degree = new HashMap<>(indegree);
        Queue<String> queue = new LinkedList<>();

        for (String course : graph.keySet()) {
            if (degree.get(course) == 0) {
                queue.offer(course);
            }
        }

        List<String> order = new ArrayList<>();

        while (!queue.isEmpty()) {
            String course = queue.poll();
            order.add(course);

            for (String next : graph.get(course)) {
                degree.put(next, degree.get(next) - 1);

                if (degree.get(next) == 0) {
                    queue.offer(next);
                }
            }
        }

        if (order.size() != graph.size()) {
            System.out.println("\nCycle detected! No valid course order.");
            return;
        }

        System.out.println("\nCourse order using BFS:");

        for (String course : order) {
            System.out.println(course);
        }
    }

    public void displayGraph() {
        System.out.println("\nCourse Dependency Graph:");

        for (String course : graph.keySet()) {
            System.out.println(course + " -> " + graph.get(course));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CoursePrerequisitePlanner planner = new CoursePrerequisitePlanner();

        System.out.println("COURSE PREREQUISITE PLANNER");

        System.out.print("Enter number of courses: ");
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            System.out.print("Enter course name: ");
            String course = sc.nextLine().trim();
            planner.addCourse(course);
        }

        System.out.print("\nEnter number of prerequisite relationships: ");
        int m = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < m; i++) {
            System.out.println("\nRelationship " + (i + 1));

            System.out.print("Enter prerequisite course: ");
            String prerequisite = sc.nextLine().trim();

            System.out.print("Enter dependent course: ");
            String course = sc.nextLine().trim();

            planner.addPrerequisite(prerequisite, course);
        }

        planner.displayGraph();
        planner.displaySortedCourses();
        planner.dfsTopologicalSort();
        planner.bfsTopologicalSort();

        sc.close();
    }
}