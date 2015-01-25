import java.util.*;

public class EvaluateLinearExpression {
	public int evaluate(String exp) {
		String[] split = exp.split("=");
		Expression left = helper(split[0]);
		Expression right = helper(split[1]);
		Expression result = calculate(left, right, "-");
		return (-result.val) / result.coefficient;
	}
	
	private Expression helper(String exp){
		Stack<String> op = new Stack<>();
		Stack<Expression> vals = new Stack<>();
		String[] split = exp.split("\\s+");
		for(int i = 0; i < split.length; i++){
			String token = split[i];
			switch (token) {
			case "": break;
			case "(":
				op.push(token);
				break;
			case ")":
				String p = op.pop();
				while(!p.equals("(")){
					Expression right = vals.pop();
					Expression left = vals.pop();
					vals.push(calculate(left, right, p));
					p = op.pop();
				}
				break;
			case "+":
			case "-":
				op.push(token);
				break;
			case "*":
			case "/":
				p = op.pop();
				Expression right = vals.pop();
				Expression left = vals.pop();
				vals.push(calculate(left, right, p));
				break;
			default:
				int index = token.indexOf('x');
				if(index == -1){
					vals.push(new Expression(0,Integer.valueOf(token)));
				}else{
					if(index == 0){
						vals.push(new Expression(1,0));
					}else{
						vals.push(new Expression(Integer.valueOf(token.substring(0,index)),0));
					}
				}
				break;
			}
		}
		while(!op.isEmpty()){
			String p = op.pop();
			Expression right = vals.pop();
			Expression left = vals.pop();
			vals.push(calculate(left, right, p));
		}
		return vals.pop();
	}
	
	private Expression calculate(Expression e1, Expression e2, String op){
		Expression exp = new Expression(0, 0);
		switch (op) {
		case "+":
			exp.coefficient = e1.coefficient + e2.coefficient;
			exp.val = e1.val + e2.val;
			break;
		case "-":
			exp.coefficient = e1.coefficient - e2.coefficient;
			exp.val = e1.val - e2.val;
			break;
		case "*":
			exp.coefficient = e1.coefficient * e2.coefficient + e1.coefficient* e1.val;
			exp.val = e1.val * e2.coefficient + e1.val *e2.val;
			break;
		case "/":
			exp.coefficient = e1.coefficient / e2.coefficient + e1.coefficient/ e1.val;
			exp.val = e1.val / e2.coefficient + e1.val /e2.val;
			break;
		default:
			break;
		}
		return exp;
	}
	
	public static void main(String[] args) {
		EvaluateLinearExpression solution = new EvaluateLinearExpression();
		String exp = "4x + 2 * ( 5 + 3x ) = 42";
		System.out.println(solution.evaluate(exp));
				
	}
}

class Expression {
	int coefficient, val;
	public Expression(int coefficient, int val) {
		this.coefficient = coefficient;
		this.val = val;
	}
}
