package cn.it1995.demo.job;

import cn.it1995.demo.object.Goods;
import cn.it1995.demo.repository.GoodsRepository;
import cn.it1995.demo.socket.WebSocket;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.text.SimpleDateFormat;
import java.util.Date;

public class QuartzJob extends QuartzJobBean {

    @Autowired
    GoodsRepository goodsRepository;

    @Autowired
    WebSocket webSocket;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        String str = "";

        for(Goods goods : goodsRepository.getGoodsArrayList()){

            str += goods.toString();
        }

        webSocket.onMessage(str);
    }
}
