import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

// queue node used in BFS
class Node
{
// (x, y) represents coordinates of a cell in matrix
int x, y;

// maintain a parent node for printing final path
Node parent;

Node(int x, int y, Node parent) {
this.x = x;
this.y = y;
this.parent = parent;
}

@Override
public String toString() {
return "(" + x + ", " + y + ')';
}
};

public class Main {

// N x M matrix
private static int N;
private static int M;

// Below arrays details all 4 possible movements from a cell
private static int[] row = { 1, 1, -1, -1, -1, 0, 0, 1};
private static int[] col = { 1, -1, -1, 1, 0, -1, 1, 0 };

// int[][] dirs={{0, 1}, {0, -1}, {-1, 0}, {1, 0}, {1,1}, {1,-1} ,{-1,-1}, {-1,1} };

// The function returns false if pt is not a valid position
private static boolean isValid(int x, int y) {
return (x >= 0 && x < N) && (y >= 0 && y < M);
}

// Find shortest route in the matrix from source cell (x, y) to
// destination cell (N - 1, N - 1)
public static Node findPath(int matrix[][], int x, int y)
{
// create a queue and enqueue first node
Queue<Node> q = new ArrayDeque<>();
Node src = new Node(x, y, null);
q.add(src);

// set to check if matrix cell is visited before or not
Set<String> visited = new HashSet<>();

String key = src.x + "," + src.y;
visited.add(key);

// run till queue is not empty
while (!q.isEmpty())
{
// pop front node from queue and process it
Node curr = q.poll();
int i = curr.x, j = curr.y;

// return if destination is found
if (i == 2 && j == 4) {
return curr;
}

// value of current cell
// int n = matrix[i][j];

// check all 4 possible movements from current cell
// and recur for each valid movement
for (int k = 0; k < 8; k++)
{
// get next position coordinates using value of current cell
x = i + row[k];
y = j + col[k];
               
               // System.out.println(matrix[i][j]);
// check if it is possible to go to next position
// from current position
if (isValid(x, y) && matrix[i][j]-matrix[x][y] <= 5)
{
// construct next cell node
Node next = new Node(x, y, curr);

key = next.x + "," + next.y;

// if it not visited yet
if (!visited.contains(key)) {
// push it into the queue and mark it as visited
q.add(next);
visited.add(key);
}
}
}
}

// return null if path is not possible
return null;
}

// Utility function to print path from source to destination
private static int printPath(Node node) {
if (node == null) {
return 0;
}
int len = printPath(node.parent);
System.out.print(node + " ");
return len + 1;
}

public static void main(String[] args)
{
int[][] matrix =
{
  // {1,2,1,-2,0},
  // {1,1,1,2,9},
   //{9,-1,1,-1,11},
   //{1,2,1,1,-1}
{1,12,2,0,0},
{2,11,1,11,0},
{3,2,-1,9,0}
};

N = matrix.length;
M= matrix[0].length;
// System.out.println(N);
// System.out.println(M);

// Find a route in the matrix from source cell (0, 0) to
// destination cell (N - 1, N - 1)
Node node = findPath(matrix, 0, 0);

if (node != null) {
System.out.print("Shortest path is: ");
int len = printPath(node) - 1;
System.out.println("\nShortest path length is " + len);
} else {
System.out.println("Destination not found");
}
}
}