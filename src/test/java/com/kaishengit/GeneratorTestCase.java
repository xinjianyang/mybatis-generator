package com.kaishengit;

import com.kaishengit.entity.Detail;
import com.kaishengit.entity.DetailExample;
import com.kaishengit.mapper.DetailMapper;
import com.kaishengit.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Created by User on 2017/10/27.
 */
public class GeneratorTestCase {


    private SqlSession sqlSession;

    private DetailMapper detailMapper;

    private DetailExample detailExample;

    @Before
    public void init(){
        sqlSession = MyBatisUtil.getSqlSession();
        detailMapper = sqlSession.getMapper(DetailMapper.class);
        detailExample = new DetailExample();
    }

    @After
    public void close(){
        sqlSession.close();
    }

    @Test
    public void insert (){
        Detail detail = new Detail("美术","张三");
        detailMapper.insert(detail);

        sqlSession.commit();

    }

    @Test
    public void delete (){
        detailMapper.deleteByPrimaryKey(20);

        sqlSession.commit();
    }


    @Test
    public void select(){
        Detail detail = detailMapper.selectByPrimaryKey(1);
        System.out.println(detail);

    }

    @Test
    public void selectList(){
       List<Detail> detailList = detailMapper.selectByExample(new DetailExample());

       for(Detail detail : detailList){
           System.out.println(detail);
       }
    }

    @Test
    public void update(){
        Detail detail = new Detail("music","jackma");
        detail.setId(19);
        detailMapper.updateByPrimaryKey(detail);

        sqlSession.commit();
    }

    @Test
    public void find(){
/*
        DetailExample detailExample = new DetailExample();
        detailExample.createCriteria().andCourseEqualTo("语文");

        List<Detail> detailList = detailMapper.selectByExample(detailExample);
        for(Detail detail : detailList){
            System.out.println(detail);
        }*/

        /*DetailExample detailExample = new DetailExample();*/
        detailExample.createCriteria().andCourseLike("%语文%");
        List<Detail> detailList = detailMapper.selectByExample(detailExample);

        for(Detail detail : detailList){
            System.out.println(detail);
        }
    }


    /**
     * where ...and...查询
     */
    @Test
    public void find1(){

        detailExample.createCriteria().andCourseLike("%语文%").andTeacherEqualTo("志明");
        List<Detail> detailList = detailMapper.selectByExample(detailExample);
        for(Detail detail : detailList){
            System.out.println(detail);
        }

    }


    /**
     * or查询
     * 结果排序
     */
    @Test
    public void find2(){
        detailExample.or().andCourseEqualTo("语文");
        detailExample.or().andTeacherEqualTo("春晓");
        detailExample.setOrderByClause("id desc");
        List<Detail> detailList = detailMapper.selectByExample(detailExample);
        for(Detail detail : detailList){
            System.out.println(detail);
        }
    }

}
