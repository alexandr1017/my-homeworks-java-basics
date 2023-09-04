package org.example;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.*;
import java.util.concurrent.RecursiveTask;


public class GoGoLinkTask extends RecursiveTask<String> {
    public static final String REGEX_URL = "^(https?|ftp|file)://[-a-zA-Z0-9+&@/%=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
    private String url;
    private List<String> visitedLinks;
    private static int count;


    public GoGoLinkTask(String url, List<String> visitedLinks) {
        this.url = url;
        this.visitedLinks = visitedLinks;
    }


    protected String compute() {

        String tabulate = StringUtils.repeat("\t",
                url.lastIndexOf("/") != url.length() - 1 ? StringUtils.countMatches(url, "/") - 2
                        : StringUtils.countMatches(url, "/") - 3);
        StringBuffer stringBuffer = new StringBuffer(tabulate + url + "\n");
        try {

            Thread.sleep(150);

            System.setProperty("https.protocols", "TLSv1,TLSv1.1,TLSv1.2");
            Connection.Response res = Jsoup.connect(url).userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64)" +
                    "AppleWebKit/537.36 (KHTML, like Gecko)" +
                    "Chrome/58.0.3029.110 Safari/537.3").ignoreHttpErrors(true).ignoreContentType(true).execute();
            Document doc = res.parse();
            Elements links = doc.select("a");


            List<GoGoLinkTask> subTasks = new ArrayList<>();

            for (Element item : links) {
                String href = item.attr("abs:href");

                if (href.startsWith(url)
                        && href.matches(REGEX_URL)
                        && !visitedLinks.contains(href)
                        && !href.equals(url)
                        && !href.contains("#")
                        && !href.endsWith("pdf")
                        && !href.endsWith("jpg")
                        && !href.endsWith("jpeg")
                        && !href.endsWith("png")) {

                    visitedLinks.add(href);
                    count++;
                    System.out.println("Append link #: " + count + " " + href + '\n');

                    GoGoLinkTask subTask = new GoGoLinkTask(href,visitedLinks);
                    subTask.fork();
                    subTasks.add(subTask);
                }
            }
            subTasks.sort(Comparator.comparing(o -> o.url));
            for (GoGoLinkTask task : subTasks) {
                stringBuffer.append(task.join());
            }
            return stringBuffer.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
