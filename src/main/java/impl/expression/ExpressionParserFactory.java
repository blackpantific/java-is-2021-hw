package impl.expression;

import api.expression.ExpressionParser;
import implementation.ExpressionParserImpl;

public class ExpressionParserFactory {
    public static ExpressionParser createInstance() {
        return new ExpressionParserImpl();
    }
}