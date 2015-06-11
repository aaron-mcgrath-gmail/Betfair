package amc.betfair.calculator;

import bsh.Interpreter;

public class BeanshellAlgorithmExecutor implements AlgorithmExecutor {

  public double execute(Algorithm algorithm) throws Exception {
    Interpreter interpreter = new Interpreter();
    
    for(int counter = 0; counter < algorithm.getVariableNames().size(); counter ++) {
      interpreter.set(algorithm.getVariableNames().get(counter), algorithm.getVariableValues().get(counter));
    }

    interpreter.eval("result = (" + algorithm.getAlgorithm() + ")");
    
    return (Double) interpreter.get("result");
  }
}
