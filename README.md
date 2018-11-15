# Algorithm_Percolation, Sort and MapRouting

Implementation and improvement of some algorithms in the algorithm class. 

## Percolation

### Problem Description

Model an infiltration system with N×N grid points, each grid point being either an open grid or a blocked grid. A full site is an open grid that connects to an open grid of the top row through a series of adjacent (left, right, top, bottom) open grid points. If there is a full site in the bottom row, the system is said to be infiltrated. 

Using a **union-find data structure**, the program is programmed to estimate the value of the percolation threshold by Monte Carlo simulation. 

## Results

1> Permeation matrix side length n = 10, Number of experiments t = 10

![image_1csaj3a34khtdcs3gl81k4ho9.png-28.4kB][1]

2> Permeation matrix side length n = 100, Number of experiments t = 100

![image_1csaj7b90gjp6crt7316831cbhm.png-30.8kB][2]

The BFS is used for Percolation, and the time complexity is $0 (n^2)$. 

From the experimental results, the average value of the permeability was $0.6$, that is, $0.6*n*n$ points were opened for each experiment.

Every time a point is opened, it is necessary to re-evaluate whether the graph is fully infiltrated, that is, the time complexity of one experiment is $0(n^4)$ for a total of t experiments $$\text{the time complexity is }0(t*n^4)$$

In each experiment, map[n*n] and fullopen[n*n] are used to store the state of each point in the graph and the fully open point, and a total of t experiments are performed $$\text{the space complexity is }0(t*n^2)$$ 

The relevant parameters of the sought threshold are obtained, but the time increases rapidly with the increase of $n$, and the space complexity is also large. The performance when the value of $n$, $t$ is large is not very good. 

## Sort

### Problem Description

Implement **Insertion Sort(IS)**, **Top-down Mergesort(TDM)**, **Bottom-up Mergesort(BUM)**, **Random Quicksort(RQ)**, **Quicksort with Dijkstra 3-way Partition(QD3P)**. Experiment with different input scale data to compare the time and space occupancy performance of the above sorting algorithm. For each input run 10 times, record each time/space occupancy and average. 

### Results

![image_1csajsh0eo6bjbq1g8c15n51rvg13.png-113.6kB][3]

## Map Routing

### Problem Description

The Dijkstra shortest path algorithm was improved by testing the US mainland file usa.txt (containing 87,575 intersections and 121,961 roads) to quickly answer the shortest path query for vertex pairs on this network. Assume that all x and y coordinates are integers between 0 and 10,000. 

### Improvement

1> **Reduce the number of vertices examined** and stop searching once the shortest path to the destination is found. 

By this method, the runtime of each shortest path query can be made proportional to E' log V', where E' and V' are Dijkstra algorithm checks. The number of edges and vertices. And just re-initialize those values that were changed in the previous query to speed up the query. 

2> The **A\* algorithm** uses the European geometry of the problem to reduce search time. 

For general graphs, Dijkstra relaxes the edge v-w by updating $d[w]$ to $d[v] + \text{the distance from v to w}$. For maps, update $d[w]$ to $d[v] + \text{the distance from v to w} + \text{Euclide distance from w to d} — \text{Euclide distance from v to d}$. 

Improved algorithm speed has been significantly improved. 


  [1]: http://static.zybuluo.com/JosieException/st3srar0ud7nty0jq995yrkk/image_1csaj3a34khtdcs3gl81k4ho9.png
  [2]: http://static.zybuluo.com/JosieException/9oz6i4grbu3osugat7zih7uo/image_1csaj7b90gjp6crt7316831cbhm.png
  [3]: http://static.zybuluo.com/JosieException/p5h32wvxj1f91w4dxcvp7ki9/image_1csajsh0eo6bjbq1g8c15n51rvg13.png
