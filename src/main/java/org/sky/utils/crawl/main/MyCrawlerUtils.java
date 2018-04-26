package org.sky.utils.crawl.main;

import org.sky.sjzq.model.TbStSjzq;
import org.sky.sys.utils.ConfUtils;
import org.sky.utils.crawl.link.LinkFilter;
import org.sky.utils.crawl.link.Links;
import org.sky.utils.crawl.page.Page;
import org.sky.utils.crawl.page.PageParserTool;
import org.sky.utils.crawl.page.RequestAndResponseTool;
import org.sky.utils.crawl.util.FileTool;
import org.jsoup.select.Elements;

import java.io.File;
import java.util.Set;

public class MyCrawlerUtils {

    /**
     * 使用种子初始化 URL 队列
     *
     * @param seeds 种子 URL
     * @return
     */
    private static void initCrawlerWithSeeds(String[] seeds) {
        for (int i = 0; i < seeds.length; i++){
            Links.addUnvisitedUrlQueue(seeds[i]);
        }
    }


    /**
     * 抓取过程
     *
     * @param seeds
     * @return
     */
    public static CrawlData crawling(String xqbh) {
    	String dir = ConfUtils.getValue("temp_dir")+xqbh+File.separator;
    	CrawlData data = new CrawlData();
    	String seed = "http://www.baobeihuijia.com/view.aspx?id="+xqbh;
        //初始化 URL 队列
        initCrawlerWithSeeds(new String[] {seed});

        //定义过滤器，提取以 http://www.baidu.com 开头的链接
        LinkFilter filter = new LinkFilter() {
            public boolean accept(String url) {
                if (url.startsWith("http://www.baobeihuijia.com"))
                    return true;
                else
                    return false;
            }
        };

        //循环条件：待抓取的链接不空且抓取的网页不多于 1000
        while (!Links.unVisitedUrlQueueIsEmpty()  && Links.getVisitedUrlNum() <= 1000) {

            //先从待访问的序列中取出第一个；
            String visitUrl = (String) Links.removeHeadOfUnVisitedUrlQueue();
            if (visitUrl == null){
                continue;
            }

            //根据URL得到page;
            Page page = RequestAndResponseTool.sendRequstAndGetResponse(visitUrl);

            //获取Page的文本信息
            Elements dom = PageParserTool.select(page,"div[id='table_1_normaldivr']");
            if(!dom.isEmpty()){
                //System.out.println("开始打印所有reginfo：------ ");
                //System.out.println(dom);
                //System.out.println("结束打印所有reginfo：------ ");
                Elements reginfo = dom.select("ul");
                if(!reginfo.isEmpty()) {
                	String reginfoString = reginfo.toString();
                	reginfoString=reginfoString.replace("<ul>", "");
                	reginfoString=reginfoString.replace("</ul>", "");
                	reginfoString=reginfoString.replace("<li>", "");
                	reginfoString=reginfoString.replace("</li>", ";");
                	reginfoString=reginfoString.replace("<span>", "");
                	reginfoString=reginfoString.replace("</span>", "");
                	reginfoString=reginfoString.replace("&nbsp;", "");
                	reginfoString=reginfoString.replace("：", ":");
                	reginfoString=reginfoString.replace("\n", "");
                	System.out.println(reginfoString.trim());
                	String[] infoList = reginfoString.trim().split(";");
                	TbStSjzq sj = new TbStSjzq();
                	sj.setXqbh(xqbh);
                	for(String info:infoList) {
                		if(info.split(":").length<=1) {
            				continue;
            			}
                		if(info.contains("寻亲类别")) {
                			sj.setXqlb(info.split(":")[1]);
                		}
                		if(info.contains("姓名")) {
                			sj.setXm(info.split(":")[1]);
                		}
                		if(info.contains("性别")) {
                			sj.setXb(info.split(":")[1]);
                		}
                		if(info.contains("出生日期")) {
                			sj.setCsrq(info.split(":")[1]);
                		}
                		if(info.contains("失踪时身高")) {
                			sj.setSzssg(info.split(":")[1]);
                		}
                		if(info.contains("失踪时间")) {
                			sj.setSzsj(info.split(":")[1]);
                		}
                		if(info.contains("失踪人所在地")) {
                			sj.setSzrszd(info.split(":")[1]);
                		}
                		if(info.contains("失踪地点")) {
                			sj.setSzdd(info.split(":")[1]);
                		}
                		if(info.contains("寻亲者特征描述")) {
                			sj.setXqztzms(info.split(":")[1]);
                		}
                		if(info.contains("其他资料")) {
                			sj.setQtzl(info.split(":")[1]);
                		}
                		if(info.contains("注册时间")) {
                			sj.setZcsj(info.split(":")[1]);
                		}
                		if(info.contains("跟进志愿者")) {
                			sj.setGjzyz(info.split(":")[1]);
                		}
                	}
                	data.setData(sj);
                }
            }
            //将保存文件
            
            FileTool.saveToLocal(page,dir);
            //将已经访问过的链接放入已访问的链接中；
            Links.addVisitedUrlSet(visitUrl);
            //得到超链接
            Set<String> links = PageParserTool.getLinks(page,"img");
            for (String link : links) {
                Links.addUnvisitedUrlQueue(link);
                System.out.println("新增爬取路径: " + link);
            }
        }
        String imgBase64 = FileTool.getImgBase64(dir, xqbh);
        data.setBase64(imgBase64);
        return data;
    }


    //main 方法入口
    public static void main(String[] args) {
        MyCrawlerUtils crawler = new MyCrawlerUtils();
        crawler.crawling("319431");
    }
}
