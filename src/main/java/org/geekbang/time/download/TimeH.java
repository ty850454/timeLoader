package org.geekbang.time.download;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 * @author xy
 */
public class TimeH {
    public static final OkHttpClient CLIENT = new OkHttpClient();
    public static final Random RANDOM = new Random();

    public static void main(String[] args) throws IOException, InterruptedException {
        String title = "设计模式之美";
        File path = new File("out/" + title);
        if (!path.exists()) {
            if (!path.mkdirs()) {
                throw new RuntimeException("文件" + path + "创建失败");
            }
        }
         getData(path, 160463);
//        getData(path, 214014);
    }


    private static void getData(File path, long id) throws IOException, InterruptedException {
        RequestBody body = RequestBody.create("{\"id\": " + id + ",\"include_neighbors\":true,\"is_freelyread\":true}", null);

        Request request = new Request.Builder()
                .url("https://time.geekbang.org/serv/v1/article")
                .post(body)
                .addHeader("Cookie", "gksskpitn=f1340967-0f4b-46ac-8948-d2e06b648ac9; _ga=GA1.2.1899495483.1608515528; LF_ID=1608515528342-6599206-1683195; GCID=8d48ac2-a64fe99-b588358-9057b63; GRID=8d48ac2-a64fe99-b588358-9057b63; _gid=GA1.2.2052828371.1608610950; orderInfo={%22list%22:[{%22count%22:1%2C%22image%22:%22https://static001.geekbang.org/resource/image/yy/28/yy455465ac1af5dac5ee026d15c1a428.jpg%22%2C%22name%22:%22%E6%95%B0%E6%8D%AE%E7%BB%93%E6%9E%84%E4%B8%8E%E7%AE%97%E6%B3%95%E4%B9%8B%E7%BE%8E%22%2C%22desc%22:%2280%E8%AE%B2%20|%20101152%E4%BA%BA%E5%B7%B2%E5%AD%A6%E4%B9%A0%22%2C%22sku%22:100017301%2C%22price%22:{%22sale%22:9900%2C%22actual%22:1990}}]%2C%22invoice%22:false%2C%22app_id%22:3%2C%22cid%22:126%2C%22isFromTime%22:true%2C%22firstOrder%22:true%2C%22detail_url%22:%22https://time.geekbang.org/column/intro/100017301%22%2C%22utm_term%22:%22zeusNGLWQ%22}; GCESS=BQUEAAAAAAoEAAAAAAwBAQgBAwsCBQABCMBsFwAAAAAAAgQHr.FfBwRfzxu7BAQALw0AAwQHr.FfCQEBBgQwSvGd; Hm_lvt_59c4ff31a9ee6263811b23eb921a5083=1608619133,1608625495,1608625867,1608625928; Hm_lvt_022f847c4e3acd44d4a2481d9187f1e6=1608625823,1608625867,1608625911,1608625928; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%221535168%22%2C%22first_id%22%3A%22176899373e5ec6-0f732b4053fb63-c791e37-2073600-176899373e6dbd%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E5%BC%95%E8%8D%90%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC%22%2C%22%24latest_referrer%22%3A%22https%3A%2F%2Faccount.infoq.cn%2F%22%2C%22%24latest_landing_page%22%3A%22https%3A%2F%2Ftime.geekbang.org%2F%22%2C%22%24latest_utm_source%22%3A%22time_web%22%2C%22%24latest_utm_medium%22%3A%22menu%22%2C%22%24latest_utm_campaign%22%3A%22end%22%2C%22%24latest_utm_content%22%3A%22xiangqingyelink1104%22%2C%22%24latest_utm_term%22%3A%22timewebmenu%22%7D%2C%22%24device_id%22%3A%2217682ff25f7791-0ff45a155ee695-c791e37-2073600-17682ff25f8898%22%7D; _gat=1; SERVERID=1fa1f330efedec1559b3abbcb6e30f50|1608626076|1608619133; Hm_lpvt_59c4ff31a9ee6263811b23eb921a5083=1608626075; Hm_lpvt_022f847c4e3acd44d4a2481d9187f1e6=1608626075; gk_process_ev={%22count%22:41%2C%22utime%22:1608625918415%2C%22target%22:%22%22%2C%22referrer%22:%22https://time.geekbang.org/%22%2C%22referrerTarget%22:%22page_geektime_login%22}")
                .addHeader("Host", "time.geekbang.org")
                .addHeader("Origin", "https://time.geekbang.org")
                .addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/87.0.4280.66 Safari/537.36")
                .addHeader("Content-Type", "application/json")
                .addHeader("x-forwarded-for", "218.79.47.46")
                .build();
        Response response = CLIENT.newCall(request).execute();

        String string = response.body().string();
        JSONObject json = JSON.parseObject(string).getJSONObject("data");

//        String lineSeparator = System.lineSeparator();
//        StringBuilder builder = new StringBuilder();
        String title = json.getString("article_title");
        System.out.println(title);
//        builder.append("# ").append(title).append(lineSeparator);
//        builder.append(json.getString("author_name")).append(lineSeparator);
//        builder.append("![](").append(json.getString("article_cover")).append(")").append(lineSeparator);
//        builder.append("> ").append(json.getString("article_summary")).append(lineSeparator).append(lineSeparator);
//        builder.append("<html>").append(lineSeparator);
//        builder.append("<audio src=\"").append(json.getString("audio_download_url")).append("\" controls /></audio>").append(lineSeparator);
//        builder.append(json.getString("article_content")).append(lineSeparator);
//        builder.append("</html>").append(lineSeparator);


        File file = new File(path, title.replace("|", "-").replace("/", " ") + ".json");
        if (file.exists()) {
            if (!file.delete()) {
                throw new RuntimeException("文件" + file + "已存在无法删除");
            }
        }
        if (!file.createNewFile()) {
            throw new RuntimeException("文件" + file + "创建失败");
        }

        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        writer.write(string);
        writer.close();

        JSONObject neighbors = json.getJSONObject("neighbors");
        if (neighbors != null) {
            JSONObject right = neighbors.getJSONObject("right");
            if (right != null) {
                Long rightId = right.getLong("id");
                if (rightId != null) {
                    Thread.sleep(RANDOM.nextInt(10000) + 1000);
                    getData(path, rightId);
                }
            }
        }

    }





}
