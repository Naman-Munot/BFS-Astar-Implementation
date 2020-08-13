# BFS-Astar-Implementation

A program that will take an input file that describes the terrain map, landing site,
target sites, and characteristics of the robot. For each target site, you should find the optimal
(shortest) safe path from the landing site to that target. A path is composed of a sequence of
elementary moves. Each elementary move consists of moving the rover to one of its 8 neighbors.


To find the solution I have used the following algorithms:

- Breadth-first search (BFS)
- Uniform-cost search (UCS)
- A* search (A*)

### Input: 
The file input.txt in the current directory of your program will be formatted as follows:

### First line:
Instruction of which algorithm to use, as a string: BFS, UCS or A*

### Second line: 
Two strictly positive 32-bit integers separated by one space character, for
“W H” the number of columns (width) and rows (height), in cells, of the map

### Third line: 
Two positive 32-bit integers separated by one space character, for
“X Y” the coordinates (in cells) of the landing site. 0 £ X £ W-1 and 0 £ Y £ H-1
(that is, we use 0-based indexing into the map; X increases when moving East and
Y increases when moving South; (0,0) is the North West corner of the map)

### Fourth line:
Positive 32-bit integer number for the maximum difference in elevation between
two adjacent cells which the rover can drive over. The difference in Z between two adjacent cells must be smaller than or equal (£ )
to this value for the rover to be able to travel from one cell to the other.

### Fifth line: 
Strictly positive 32-bit integer N, the number of target sites.

### Next N lines:
Two positive 32-bit integers separated by one space character, for “X Y” the coordinates (in cells) of each target site. 0 £ X £ W-1 and 0 £ Y £ H-1
(that is, we again use 0-based indexing into the map).

### Next H lines: 
W 32-bit integer numbers separated by any numbers of spaces for the elevation (Z) values of each of the W cells in each row of the map.
```
For example:
A*
8 6
4 4
7
2
1 1
6 3
0 0  0  0  0  0  0  0
0 60 64 57 45 66 68 0
0 63 64 57 45 67 68 0
0 58 64 57 45 68 67 0
0 60 61 67 65 66 69 0
0  0  0  0  0  0  0 0
```
In this example, on a 8-cells-wide by 6-cells-high grid, we land at location (4, 4), where (0, 0) is the North West corner of the map. The maximum elevation change
that the rover can handle is 7 (in arbitrary units which are the same as for the Z values of the
map). We want to visit 2 targets, at locations (1, 1) and (6, 3).
The Z elevation map is then given as six lines in the file, with eight Z values in each line,
separated by spaces.

### Output:
The file output.txt which your program creates in the current directory should be formatted as follows:
N lines: Report the paths in the same order as the targets were given in the input.txt file

Write out one line per target. Each line should contain a sequence of X,Y pairs
of coordinates of cells visited by the rover to travel from the landing site to the
corresponding target site for that line. Only use a single comma and no space
to separate X,Y and a single space to separate successive X,Y entries.
If no solution was found (target site unreachable by rover from given landing
site), write a single word FAIL in the corresponding line.

For example, output.txt may contain:
```
4,4 3,4 2,3 2,2 1,1
4,4 5,4 6,3
```
Here, the first line is a sequence of five X,Y locations which trace the path from the proposed landing site (4,4) to the first target (1,1). 
The second line is a sequence of three X,Y locations which trace the path from the proposed landing site (4,4) to the second target (6,3).
