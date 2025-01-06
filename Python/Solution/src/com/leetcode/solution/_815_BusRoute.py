"""
You are given an array routes representing bus routes where routes[i] is a bus route that the ith bus repeats forever.

For example, if routes[0] = [1, 5, 7], this means that the 0th bus travels in the sequence 1 -> 5 -> 7 -> 1 -> 5 -> 7 -> 1 -> ... forever.
You will start at the bus stop source (You are not on any bus initially), and you want to go to the bus stop target. You can travel between bus stops by buses only.

Return the least number of buses you must take to travel from source to target. Return -1 if it is not possible.



Example 1:

Input: routes = [[1,2,7],[3,6,7]], source = 1, target = 6
Output: 2
Explanation: The best strategy is take the first bus to the bus stop 7, then take the second bus to the bus stop 6.
Example 2:

Input: routes = [[7,12],[4,5,15],[6],[15,19],[9,12,13]], source = 15, target = 12
Output: -1



Constraints:

1 <= routes.length <= 500.
1 <= routes[i].length <= 105
All the values of routes[i] are unique.
sum(routes[i].length) <= 105
0 <= routes[i][j] < 106
0 <= source, target < 106
"""
from collections import defaultdict, deque

from typing import List

"""
Solution:
  BFS:
    Convert List[List[int]] to graph with Node is Bus, and Node.next is the bus that can be taken from current bus
    BFS to find smallest number of bus taken to reach target bus stop
"""

# Leetcode fastest solution
def numBusesToDestination(routes: List[List[int]], source: int, target: int) -> int:
  stop_to_buses = defaultdict(list)

  for bus_id, route in enumerate(routes):
    for stop in route:
      stop_to_buses[stop].append(bus_id)

  # If the source and target are the same stop, no buses are needed
  if source == target:
    return 0

  # Check if source and target stops are in the graph
  if source not in stop_to_buses or target not in stop_to_buses:
    return -1

  # Use BFS to find the minimum number of buses to reach the target stop
  queue = deque([source])
  buses_taken = set()
  stops_visited = set()
  res = 0

  while queue:
    # Increment the res for each level of stops
    res += 1
    stops_to_process = len(queue)

    for _ in range(stops_to_process):
      current_stop = queue.popleft()

      # Check buses passing through the current stop
      for bus_id in stop_to_buses[current_stop]:
        if bus_id in buses_taken:
          continue

        buses_taken.add(bus_id)

        # Check stops reachable from the current bus
        for next_stop in routes[bus_id]:
          if next_stop in stops_visited:
            continue

          # If the target is reached, return the res
          if next_stop == target:
            return res

          # Add the next stop to the queue and mark it as visited
          queue.append(next_stop)
          stops_visited.add(next_stop)

  # If no valid route is found
  return -1


'''
Own Code

from typing import List

class Node:
  def __init__(self, val):
      self.val = val
      self.next = set()

def numBusesToDestination(routes: List[List[int]], source: int, target: int) -> int:
  if(source == target):
    return 0
  bus_route_map = convert_to_dict_(routes)
  bus_graph = convert_dict_to_dict_graph(bus_route_map, routes)
  return bfs(bus_graph, source, target, bus_route_map, routes)

def convert_to_dict_(routes: List[List[int]]) -> dict:
  bus_route_map = {}
  for i in range(len(routes)):
    for j in range(len(routes[i])):
      if routes[i][j] not in bus_route_map:
        bus_route_map[routes[i][j]] = set()
      bus_route_map[routes[i][j]].add(i)
  return bus_route_map

def convert_dict_to_dict_graph(bus_route_map: dict, routes: List[List[int]]) -> dict:
  bus_graph = {}
  for i in range(len(routes)):
    if i not in bus_graph:
      bus_graph[i] = Node(i)
    node = bus_graph[i]
    for route in routes[i]:
      bus_set = bus_route_map[route]
      for bus in bus_set:
        if bus not in bus_graph:
          bus_graph[bus] = Node(bus)
        if bus != node.val:
          node.next.add(bus)
  return bus_graph

def bfs(bus_graph: dict, source: int, target: int, bus_route_map: dict, routes: List[List[int]]) -> int:
  number_bus_taken = 0
  bus_exist = set()
  bus_queue = []
  bus_set = bus_route_map.get(source)
  if(bus_set == None):
    return -1
  bus_queue.append(bus_set)

  while bus_queue:
    queue_list = [bus_queue.pop() for _ in range(len(bus_queue))]
    number_bus_taken += 1
    for element_set in queue_list:
      for element in element_set:
        node = bus_graph.get(element)
        if node.val in bus_exist:
          continue
        if target in routes[node.val]:
          return number_bus_taken
        bus_exist.add(node.val)
        bus_queue.append(node.next)

  return -1

'''

if __name__ == '__main__':
  routes = [[1,2,7],[3,6,7]]
  source = 1
  target = 6
  print(numBusesToDestination(routes, source, target)) # 2
  pass