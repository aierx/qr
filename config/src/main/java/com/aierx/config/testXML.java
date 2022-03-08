package com.aierx.config;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class testXML {
    public static void main(String[] args) {
        // 创建DocumentBuilderFactory的对象
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            //创建DocumentBuilder对象
            DocumentBuilder db = dbf.newDocumentBuilder();
            //通过documentBuilder对象 的parser方法加载books。xml文件到当前项目下
            Document document = db.parse("books.xml");
            //获取所有book节点的集合
            NodeList booklist = document.getElementsByTagName("book");
            System.out.println("一共有" + booklist.getLength() + "本书");
            //遍历每一个book节点
            for (int i = 0; i <= booklist.getLength(); i++) {
                //通过item(i)方法获取book节点
                Node book = booklist.item(i);
                //获取book节点的所有属性集合
                NamedNodeMap attrs = book.getAttributes();
                System.out.println("第" + (i + 1) + "本书共有" + attrs.getLength() + "个属性");
                //遍历book的属性
                for (int j = 0; j < attrs.getLength(); j++) {
                    //通过item方法获取book节点的属性
                    Node attr = attrs.item(j);
                    //获取属性名
                    System.out.print("属性名:" + attr.getNodeName());
                    //获取属性值
                    System.out.println("--属性值" + attr.getNodeValue());
                    NodeList chilNod = book.getChildNodes();
                    System.out.println("第" + (i + 1) + "本书共有" + chilNod.getLength() + "个子节点");
                    for (int k = 0; k < chilNod.getLength(); k++) {
                        Node chil = chilNod.item(k);
                        //区分text 类型node
                        if (chilNod.item(k).getNodeType() == Node.ELEMENT_NODE) {
                            System.out.print("子节点名：" + chil.getNodeName() + ":");
                            System.out.println("    子节点值：" + chilNod.item(k).getFirstChild().getNodeValue());
                            //System.out.println("子节点值："+chilNod.item(k).getTextContent());
                        }
                    }
                }
            }
        } catch (ParserConfigurationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (org.xml.sax.SAXException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}