package com.TripPlanner.demo.controller;

import com.TripPlanner.demo.model.TopAttractions;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TSP {
    private Stack<Long> stack;

    public TSP() {
        stack = new Stack<Long>();
    }

    public List<Long> tsp(Double[][] cityGraph) {
        Integer numberOfNodes = cityGraph[1].length - 1;
        List<Long> route = new ArrayList<>();
        Long[] visited = new Long[numberOfNodes + 1];
        visited[1] = Long.valueOf(1);
        stack.push((long) 1);
        Long element;
        int dst = 0;
        int i;
        Double min;

        boolean minFlag = false;
        route.add((long) 1);
        while (!stack.isEmpty()) {
            element = stack.peek();
            i = 1;
            min = Double.MAX_VALUE;
            while (i <= numberOfNodes) {
                if (cityGraph[Math.toIntExact(element)][i] > 1 && visited[i] == 0) {
                    if (min > cityGraph[Math.toIntExact(element)][i]) {
                        min = cityGraph[Math.toIntExact(element)][i];
                        dst = i;
                        minFlag = true;
                    }
                }
                i++;
            }
            if (minFlag) {
                visited[dst] = Long.valueOf(1);
                stack.push((long) dst);
                route.add((long) dst);
                minFlag = false;
                continue;
            }
            stack.pop();
        }
        return route;
    }

    public static List<TopAttractions> TSPUtil(Double[][] cityGraph, Integer number_of_nodes) {
        for (int i = 1; i <= number_of_nodes; i++) {
            for (int j = 1; j <= number_of_nodes; j++) {
                if (cityGraph[i][j] == 1 && cityGraph[j][i] == 0) {
                    cityGraph[j][i] = 1.0;
                }
            }
        }
        TSP tspNearestNeighbour = new TSP();
        //tspNearestNeighbour.tsp(cityGraph);
        List<TopAttractions> topAttractionsList=null;
        TopAttractions topAttractions;
        for (Long i:tspNearestNeighbour.tsp(cityGraph)) {
            topAttractionsList.add(topAttractionsList.get(Math.toIntExact(i)));
        }
        return topAttractionsList;
    }
}
