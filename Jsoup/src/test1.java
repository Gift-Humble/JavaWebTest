import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;

public class test1 {
    public static void main(String[] args) {
        String html = "<html><body><p>Hello HTML</p></body></html>";
        Document doc = Jsoup.parse(html);
        Elements es = doc.getElementsByTag("p");
        for (Element e : es) {
            System.out.println(e.text());
        }
        String url = "http://39.105.44.56";
        Document doc3 = null;//超过五秒报错
        try {
            doc3 = Jsoup.parse(new URL(url), 5000);
            System.out.println("基于URL方式得到document\n" + doc3);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
