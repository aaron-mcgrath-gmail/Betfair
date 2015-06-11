package com.betfair.aping.util;

import java.util.ArrayList;
import java.util.List;

import amc.betfair.calculator.Algorithm;
import amc.betfair.calculator.BeanshellAlgorithmExecutor;

public class TEST_CLASS {

  public static void main(String[] args) {
    Algorithm algorithm = new Algorithm();
//    algorithm.setAlgorithm("(a*(10/2))+b");
//    algorithm.setAlgorithm("a/2*5*b");
    algorithm.setAlgorithm("a/(2*5*b)");
    
    List<String> names = new ArrayList<String>();
    names.add("a");
    names.add("b");
    
    List<Double> values = new ArrayList<Double>();
    values.add(10d);
    values.add(10d);
    
    algorithm.setVariableNames(names);
    algorithm.setVariableValues(values);
    
    try {
      double result = new BeanshellAlgorithmExecutor().execute(algorithm);
      System.out.println(result);
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    
  }
  
}
