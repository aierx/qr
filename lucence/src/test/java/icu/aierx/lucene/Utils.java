package icu.aierx.lucene;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;

import java.io.IOException;
import java.io.StringReader;

/**
 * @author leiwenyong
 * @since 2022/5/4
 */
public class Utils {
    /*
     * 显示分词（TokenStream流再用CharTermAttribute捕获）
     */
    public static void displayToken(String str, Analyzer a) {
        try {
            // "content"没有任何意义
            // 通过分词器Analyzer创建TokenStream流
            TokenStream stream = a.tokenStream("content", new StringReader(str));
            stream.reset();
            System.out.printf("%20s:",a.getClass().getSimpleName());
            // 创建用于接收信息的CharTermAttribute,这个属性会添加到流中,随着TokenStream增加
            CharTermAttribute cta = stream.addAttribute(CharTermAttribute.class);
            while (stream.incrementToken()) {
                System.out.print("[" + cta + "]");
            }
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
