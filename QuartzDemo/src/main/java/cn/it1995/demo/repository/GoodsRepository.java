package cn.it1995.demo.repository;

import cn.it1995.demo.object.Goods;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class GoodsRepository {

    private static ArrayList<Goods> goodsArrayList = new ArrayList<>();

    static {

        Goods goods1 = new Goods();
        goods1.setId(1);
        goods1.setName("石油50L");
        goods1.setCount(100);
        goodsArrayList.add(goods1);

        Goods goods2 = new Goods();
        goods2.setId(1);
        goods2.setName("石油150L");
        goods2.setCount(100);
        goodsArrayList.add(goods2);

        Goods goods3 = new Goods();
        goods3.setId(1);
        goods3.setName("石油250L");
        goods3.setCount(100);
        goodsArrayList.add(goods3);

        Goods goods4 = new Goods();
        goods4.setId(1);
        goods4.setName("石油300L");
        goods4.setCount(100);
        goodsArrayList.add(goods4);
    }

    public ArrayList<Goods> getGoodsArrayList(){

        return goodsArrayList;
    }
}
