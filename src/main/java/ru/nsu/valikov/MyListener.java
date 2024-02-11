package ru.nsu.valikov;

import antlr.LispBaseListener;
import antlr.LispParser.ExpressionContext;
import antlr.LispParser.ProgramContext;
import org.antlr.v4.runtime.tree.ParseTree;

public class MyListener extends LispBaseListener {

    @Override
    public void enterProgram(ProgramContext ctx) {
        System.out.println("int main(){");
    }

    @Override
    public void exitProgram(ProgramContext ctx) {
        System.out.println("return 0;\n}");
    }

    @Override
    public void enterExpression(ExpressionContext ctx) {
        System.out.println(switch (ctx.PLUS().getText()) {
            case "+" -> {
                var l = ctx.NUMBER();
                yield String.join("+", l.stream().map(ParseTree::getText).toList());
            }
            default -> throw new IllegalStateException("Unexpected value: " + ctx.OP().getText());
        });
    }
}
