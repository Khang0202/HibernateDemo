/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.nmkhang.hibernatedemov1;

import com.nmkhang.pojo.Category;
import com.nmkhang.repository.ProductRepository;
import com.nmkhang.repository.StatsRepository;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import org.hibernate.Session;

/**
 *
 * @author admin
 */
public class HibernateDemoV1 {

    public static void main(String[] args) throws ParseException {
        Map<String, String> params = new HashMap<>();
        params.put("year", "2020");
        params.put("quarter", "3");
        StatsRepository s = new StatsRepository();
        s.StatsRevenue(params).forEach(o -> System.err.printf("%d - %s - %s\n", o[0], o[1], o[2]));
        
        
//        StatsRepository s = new StatsRepository();
//        s.countProductByCate().forEach(o -> System.err.printf("%d - %s - %d\n", o[0], o[1], o[2]));
//        try(Session session = HibernateUtils.getSESSION_FACTORY().openSession()){
//            Query q = session.createQuery("From Category");
//            List<Category> cates = q.getResultList();
//            cates.forEach(p -> System.out.println(p.getName()));
//        }
//        ProductRepository proRe = new ProductRepository();
//        proRe.getProducts(null).forEach(p -> System.out.println(p.getName()));
    }
}
