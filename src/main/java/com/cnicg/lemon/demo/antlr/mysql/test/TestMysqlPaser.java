package com.cnicg.lemon.demo.antlr.mysql.test;

import com.cnicg.lemon.demo.antlr.mysql.parse.autogen.MySQLStatementLexer;
import com.cnicg.lemon.demo.antlr.mysql.parse.autogen.MySQLStatementParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;

import javax.swing.event.DocumentEvent;
import java.util.LinkedList;
import java.util.List;

public class TestMysqlPaser {
    public static void main(String[] args) {
        CharStream charStream = CharStreams.fromString("SELECT * from t_order_item WHERE status in (select status from t_order where user_id = 10 and order_id = 1000)");
        MySQLStatementLexer lexer = new MySQLStatementLexer(charStream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        MySQLStatementParser parser = new MySQLStatementParser(tokens);
        MySQLStatementParser.ExecuteContext executeContext = parser.execute();
//        ParseTree tree = executeContext.getChild(0);
//        System.out.println(tree.getClass().getSimpleName());
        List<ParserRuleContext> allCtx = getAllCtx(executeContext);

        System.out.println(allCtx.size());
        System.out.println("---------");
        allCtx.forEach(e -> System.out.println(e.getClass().getSimpleName()));
        System.out.println("---------");

    }

    private static List<ParserRuleContext> getAllCtx(ParserRuleContext node) {
        List<ParserRuleContext> result = new LinkedList<>();
        result.add(node);
        for (ParserRuleContext each: getChildrenNodes(node)){
            result.addAll(getAllCtx(each));
        }
        return result;
    }

    private static List<ParserRuleContext> getChildrenNodes(ParserRuleContext node) {
        List<ParserRuleContext> result = new LinkedList<>();
        for (int i=0;i<node.getChildCount();i++){
            ParseTree child = node.getChild(i);
            if(child instanceof ParserRuleContext){
                result.add((ParserRuleContext) child);
            }
        }
        return result;
    }
}
