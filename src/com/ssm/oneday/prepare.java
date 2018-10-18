package com.ssm.oneday;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentFactory;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class prepare {
    public static void main(String[] args) throws IOException, DocumentException {
        // 加载。properties文件
        Properties pop = new Properties();
        pop.load(new FileInputStream("resouces/test.properties"));
//        System.out.print(pop.getProperty("url")+"\n");
//        System.out.print(pop.getProperty("driver"));
        // 读xml文件
        // 1.创建一个读对象
        SAXReader reader =new SAXReader();
        // 2.根据读对象去获取一个Document对象
        Document doc = reader.read(new File("resouces/test.xml"));
        // 3.根据Document对象获取一根节点
        Element rootElement = doc.getRootElement();
        // 4.根据根节点获取一个list的子节点对象(指定哪种子节点)
        List<Element> elements = rootElement.elements("student");
        // 5.for循环遍历子节点取出其中的值
        for(Element em : elements){
            System.out.print(em.element("name").getText());
            System.out.print(em.element("age").getText());
            System.out.print("\n");
        }

    }
}
