package ru.nsu.valikov;

import antlr.LispLexer;
import antlr.LispParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class Main {

    public static void main(String[] args) {
        var code = "(+ 1 2 3)";
        var lexer = new LispLexer(CharStreams.fromString(code));
        var parser = new LispParser(new CommonTokenStream(lexer));
        var tree = parser.program();
        var walker = new ParseTreeWalker();
        var listener = new MyListener();
        walker.walk(listener, tree);
    }
}